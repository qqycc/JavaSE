package com.qqy.jcf.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap
 * Author:qqy
 */
public class Test2 {
    public static void main(String[] args) {
        //1.如果key是系统（JDK,第三方）定义的类排序规则有可能已经定义完成
        //  如果要修改，可以通过TreeMap的构造方法传入比较器(Comparator)接口的实现类对象（lambda表达式）
        //2.如果key是自定义的类，可以实现比较接口Comparable
        //  也可以不去实现，在使用的时候指定比较器(Comparator)接口的实现类对象
        //3.使用时指定Comparator方式比较灵活

        //更改比较器，逆序
        Map<Integer, String> map = new TreeMap<>((o1, o2) -> o1.compareTo(o2) * -1);

        map.put(1, "Java");
        map.put(2, "C++");
        map.put(4, "PHP");
        map.put(3, "C"); //由key决定如何排序，从大到小的排序
        System.out.println(map);
    }
}
