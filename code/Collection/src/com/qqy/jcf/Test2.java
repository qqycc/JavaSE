package com.qqy.jcf;

import java.util.*;

/**
 * 将List转成数组
 * Author: qqy
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("good");
        list.add("hello");
        list.add("good");

        //Object[] elementArray = list.toArray();
        String[] elementArray = new String[list.size()];
        for (int i = 0, len = list.size(); i < len; i++) {
            elementArray[i] = list.get(i);
        }
        System.out.println(Arrays.toString(elementArray));//[good, hello, good]

        String[] elementArray1 = new String[list.size()+2];
        list.toArray(elementArray1);
        System.out.println(Arrays.toString(elementArray1));//[good, hello, good, null, null]

        String[] elementArray2 = new String[list.size()-1];
        list.toArray(elementArray2);
        System.out.println(Arrays.toString(elementArray2));//[null, null]

        //不直接使用Collection接口,变为Object数组,不能用泛型方法,有可能产生ClassCastException
        Collection collection = list;
        collection.toArray();
    }
}
