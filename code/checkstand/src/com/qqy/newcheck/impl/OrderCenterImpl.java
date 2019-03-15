package com.qqy.newcheck.impl;

import com.qqy.newcheck.Goods;
import com.qqy.newcheck.GoodsCenter;
import com.qqy.newcheck.OrderCenter;
import com.qqy.newcheck.Order;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:qqy
 */
public class OrderCenterImpl implements OrderCenter {
    private GoodsCenter goodsCenter;

    public OrderCenterImpl(GoodsCenter goodsCenter) {
        this.goodsCenter = goodsCenter;
    }

    //创建订单集合，key -> 订单编号，value -> 订单信息
    private final Map<String, Order> orderMap = new HashMap<>();

    private String filePath = System.getProperty("user.dir") + File.separator + "order.txt";

    @Override
    public void addOrder(Order order) {
        this.orderMap.put(order.getOrderId(), order);
    }

    @Override
    public void removeOrder(String orderId) {
        this.orderMap.remove(orderId);
    }

    @Override
    public String ordersTable() {
        StringBuilder str = new StringBuilder();
        str.append("=================所有订单=================\n");
        str.append("\t编号\t\t\t总价\n");

        for (Order order : this.orderMap.values()) {
            Map<String, Integer> totalOrder = order.getOrderInfo();
            double everyPrice = 0.0;
            //商品集合，key -> 商品编号，value -> 商品数量
            for (Map.Entry<String, Integer> entry : totalOrder.entrySet()) {
                String goodId = entry.getKey();
                Integer goodCount = entry.getValue();
                Goods good = goodsCenter.getGoods(goodId);
                everyPrice += good.getPrice() * goodCount;
                str.append("\t" + goodId + "\t\t\t" + everyPrice + "\n");
            }
            str.append("=========================================\n");
        }
        return str.toString();
    }

    @Override
    public String orderTable(String orderId) {
        Order order = this.orderMap.get(orderId);
        StringBuilder str = new StringBuilder();
        str.append("=================订单信息=================\n");
        str.append("编号：" + order.getOrderId() + "\n");
        str.append("打印时间：" + LocalDate.now().toString()+"\n");
        str.append("=========================================\n");
        str.append("编号\t\t\t名称\t\t\t数量\t\t\t单价\n");
        double totalPrice = 0.0;
        for (Map.Entry<String, Integer> entry : order.getOrderInfo().entrySet()) {
            Goods good = goodsCenter.getGoods(entry.getKey());
            str.append("" + good.getId() + "\t\t\t" + good.getName() + "\t\t\t"+entry.getValue()+"\t\t\t"+ good.getPrice() + "\n");
            totalPrice += entry.getValue() * good.getPrice();
        }
        str.append("=========================================\n");
        str.append("总价：" + totalPrice + "\n");
        str.append("=========================================\n");
        return str.toString();
    }

    @Override
    public void storeOrders() {
        System.out.println("保存所有订单到文件，每个订单信息 -> 编号和总价");
        //将所有订单信息保存至order.txt
        //输出格式 -> 编号：总价
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(file)
        )) {
            for(Order order:this.orderMap.values()){
                double totalPrice = 0.0;
                for (Map.Entry<String, Integer> entry : order.getOrderInfo().entrySet()) {
                    totalPrice += entry.getValue() *goodsCenter.getGoods(entry.getKey()).getPrice();
                }
                writer.write(String.format("%s:%.2f\n",order.getOrderId(),totalPrice));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String loadOrders() {
        File file = new File(filePath);
        StringBuilder str = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file)
        )) {
            String read;
            if ((file.length() == 0)){
                System.out.println("请先保存订单信息！！！");
            }else{
                System.out.println("加载文件中的订单信息...");
                double price;
                str.append("=================所有订单=================\n");
                str.append("\t编号\t\t\t总价\n");
                while ((read = reader.readLine()) != null) {
                    String[] values = read.split(":");
                    if (values.length == 2) {
                        Order order = new Order(values[0]);
                        price = Double.parseDouble(values[1]);
                        this.addOrder(order);
                        str.append("\t" + order.getOrderId() + "\t\t\t" + price + "\n");
                    }
                }
                str.append("=========================================\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    @Override
    public void cleanOrders() {
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file)
        ) {
            fileWriter.write("");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
