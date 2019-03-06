package com.qqy.jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * skip与limit方法
 * Author:qqy
 */
public class Test17 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "1、Java", "2、C++", "3、Python", "4、JavaScript", "5、Nginx", "6、Tomcat");

        //没有数据显示
//        list.stream()
//                .skip(7)
//                .limit(1)
//                .forEach(System.out::println);

        //跳过1个，取3个，打印其中包括"Java"的
        /*
        以下3个方法不会立即调用，当流式操作的过程中调用了终结方法（foreach -> 返回void，不再返回流），才会执行
        优点：
        1.不用每次都遍历几何元素
        2.高效进行处理
        */
        list.stream()
                .skip(1)
                .limit(3)
                .filter(s -> s.contains("Java"))
                .forEach(System.out::println);
    }
}
