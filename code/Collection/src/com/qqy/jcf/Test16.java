package com.qqy.jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 符合添加的元素个数统计
 * Author:qqy
 */
public class Test16 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "C++", "Python", "JavaScript");

        Long count = list.stream()
                .filter(s -> s.contains("Java"))
                .count();
        System.out.println("包含Java的元素有：" + count+"个");
    }
}
