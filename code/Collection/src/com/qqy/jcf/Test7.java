package com.qqy.jcf;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * HashSet
 * Author:qqy
 */
public class Test7 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("C++");
        set.add("C");
        set.add("PHP");
        set.add("Python");
        set.add("Java");

        //遍历
        Iterator<String> iterator = set.iterator();
        //也可使用foreach
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //判断元素是否存在（String已覆写equals()）
        System.out.println(set.contains("Java"));//true
        System.out.println(set.contains("JavaScript"));//false
    }
}
