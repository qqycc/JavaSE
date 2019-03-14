package com.qqy.jcf;

import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleSupplier;
import java.util.stream.Collectors;

/**
 * Author:qqy
 */
public class TestMapReduce {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Iphone", 8999.99, 10));
        orderList.add(new Order("外星人笔记本", 12999.99, 5));
        orderList.add(new Order("MacBookPro", 18999.99, 5));
        orderList.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
        orderList.add(new Order("中性笔", 1.99, 200000));

        orderList.add(new Order("中性笔", 2, 20));
        orderList.add(new Order("外星人笔记本", 1000, 1));

        price(orderList);
        statistics(orderList);
        grouping(orderList);

        optimize(orderList);
    }

    //计算金额总和
    public static void price(List<Order> orderList){
        double total = 0.0D;
        for (Order order : orderList) {
            total += order.getPrice() * order.getAmount();
        }
        System.out.println("总金额是：" + total);

        //fork-join -> Java提供的并发处理
        //map - reduce 进行的总额计算
        double totalPrice = orderList
                .stream()
                //求出每一个订单的金额，并转为double流,eg:[10.4,22.4,18.5]
                .mapToDouble(o -> o.getPrice() * o.getAmount())
                /*
                OptionalDouble reduce(DoubleBinaryOperator op);
                public interface DoubleBinaryOperator {
                    double applyAsDouble(double left, double right);
                }

                DoubleStream 里面的每个元素求和
                left right
                left-> sum = 0  right -> x=10.4
                sum(left) 10.4(right) -> sum= left + right = 0 + 10.4
                sum(left) 22.4(right) -> sum = left + right = 10.4 + 22.4
                */
                .reduce(new DoubleBinaryOperator() {
                    @Override
                    public double applyAsDouble(double left, double right) {
                        return left+right;
                    }
                })
                //不存在，返回给定的值；存在，返回value
                //等价于orElse(0);
                .orElseGet(new DoubleSupplier() {
                    @Override
                    public double getAsDouble() {
                        return 0;
                    }
                });

        System.out.println("订单总价：" + totalPrice);
    }

    //map-reduce 统计分析
    public static void statistics(List<Order> orderList){
        DoubleSummaryStatistics summary= orderList.stream()
                .mapToDouble(o -> o.getPrice() * o.getAmount())
                .summaryStatistics();
        //有多少订单，最大订单，最小订单，总额，平均值
        System.out.println("数量：" + summary.getCount());
        System.out.println("最大值：" + summary.getMax());
        System.out.println("最小值：" + summary.getMin());
        System.out.println("总和：" + summary.getSum());
        System.out.println("平均值：" + summary.getAverage());
    }

    //自己实现订单分组(按title分组)
    public static void grouping(List<Order> orderList) {
        //key -> title,value -> 订单信息
        Map<String, List<Order>> map = new HashMap<>();
        for (Order order : orderList) {
            if (map.containsKey(order.getTitle())) {
                map.get(order.getTitle()).add(order);
            } else {
                List<Order> orders = new ArrayList<>();
                orders.add(order);
                map.put(order.getTitle(), orders);
            }
        }
        System.out.println(map);

        //计算title相同的订单金额
        Map<String, Double> doubleMap = new HashMap<>();
        for (Map.Entry<String, List<Order>> entry : map.entrySet()) {
            String title = entry.getKey();
            List<Order> orders = entry.getValue();
            double sum = 0.0D;
            for (Order o : orders) {
                sum += o.getPrice() * o.getAmount();
            }
            doubleMap.put(title, sum);
        }
        System.out.println(doubleMap);
    }
    public static void optimize(List<Order> orderList){
        //Stream , group by , foreach
        Map<String, Double> doubleMap = new HashMap<>();
        orderList.stream()
                //利用groupingBy()订单分组
                .collect(Collectors.groupingBy(Order::getTitle))
                .forEach((k, v) -> {
                    //String k
                    //List<Order> v
                    //计算金额总和
                    double total = v.stream()
                            .mapToDouble(o -> o.getPrice() * o.getAmount())
                            .reduce((sum, x) -> sum + x)
                            .orElse(0);

                    doubleMap.put(k, total);
                });
        System.out.println(doubleMap);
    }
}
