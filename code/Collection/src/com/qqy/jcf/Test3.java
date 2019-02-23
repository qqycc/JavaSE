package com.qqy.jcf;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 迭代
 * Author: qqy
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bonjour");
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            //iterator.add("+");

            //修改迭代器内容set()时，不能写在next()之前，
//            iterator.set("+"); //error
            System.out.print(iterator.next() + ", ");  //hello, bonjour,
//            iterator.add("+");
//            System.out.print(iterator.next() + ", ");  //hello, bonjour,
            iterator.set("+");
            //对集合进行遍历并删除,用迭代器
            //iterator.remove();
        }
        System.out.println();
        for (String item : list) {
            System.out.print(item + ", ");  //+, +,
        }
    }
}
