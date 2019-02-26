package com.qqy.jcf;


import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList
 * Author:qqy
 */

public class Test6 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("hello");
        list.add("vie");
        list.add("amour");
        System.out.println(list);
        list.remove("hello");
        System.out.println(list);
    }
}
