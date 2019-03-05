package com.qqy.jcf;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 利用集合，将int转为String
 * Author:qqy
 */
public class Test15 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        List<String> stringList = intList.stream().map(integer -> String.valueOf(integer))
                .collect(Collectors.toList());
        System.out.println(stringList);
    }
}
