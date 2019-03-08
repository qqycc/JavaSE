package com.qqy.jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * forEach
 * Author:qqy
 */
public class TestCollection {
    public static void main(String[] args) {
        //forEach 来自 Iterable，被Collection继承
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "C++", "Python", "JavaScript");

        //匿名内部类
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //Lambda表达式
        list.forEach(s-> System.out.println(s));

        //方法引用
        list.forEach(System.out::println);
    }
}
