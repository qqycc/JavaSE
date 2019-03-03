package com.qqy.jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream流
 * Author:qqy
 */
public class Test14 {
    public static void main(String[] args) {
        //stream  来自 Collection
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "C++", "Python", "JavaScript");

        //返回所有Stream流中所有元素的个数
        System.out.println(list.stream().count());  //4

        //旧方法
        List<String> lists = new ArrayList<>();
        for (String item : list) {
            if (item.contains("Java")) {
                lists.add(item.toUpperCase());
            }
        }
        System.out.println(lists);

        //利用stream的新方法
        List<String> newList = list
                .stream()
                .filter(s -> s.contains("Java"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());  //汇总到集合
        System.out.println(newList);
        //直接打印
        list.stream()
                .filter(s -> s.contains("Java"))  //返回此流中所有包含"Java"的元素组成的流
                .map(s-> s.toUpperCase())         //
                .forEach(System.out::println);    //打印
    }
}
