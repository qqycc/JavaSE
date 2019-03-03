package com.qqy.jcf;

import java.util.*;

/**
 * Collections工具类
 * Author:qqy
 */
public class Test13 {
    public static void main(String[] args) {
        //ArrayList打印a——z
        List<String> data = new ArrayList<>();
        for (int i = 65; i < 123; i++) {
            data.add(String.valueOf((char) i));
        }
        System.out.println("原始数据：" + data);

        //反转方法
        Collections.reverse(data);
        System.out.println("反转之后：" + data);

        //查找
        System.out.println(data.get(0));
        System.out.println(data.size());
        //如果它包含在列表中，搜索关键字的索引;否则， (-(insertion point) - 1)
        //binarySearch()
        //使用二叉搜索算法搜索指定对象的指定列表。 该列表必须根据被按升序排列natural ordering元素（如由sort(List)方法）之前使该呼叫。
        //如果没有排序，结果是未定义的。 如果列表包含与指定对象相等的多个元素，则不能保证将找到哪个元素。
        //不能依赖于添加的顺序，最好自己提供排序算法，int类型不需要指定比较器
        int index = Collections.binarySearch(data, "z");  //  -(58)-1
        System.out.println("查看z的下标：" + index);
        System.out.println("查看A的下标：" + Collections.binarySearch(data, "A")); //-0-1

        //乱序
        Collections.shuffle(data);
        System.out.println(data);

        //1.非同步集合-> 同步集合
        //2.集合 -> 不可修改
        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("1", "Java"));
        //UnmodifiableMap将Map包装成一个不可修改的Map
        map = Collections.unmodifiableMap(map);
        //不能修改
        // map.put("2", "C++");
    }
}
