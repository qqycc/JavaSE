package com.qqy.jcf;

import java.util.*;

/**
 * vector
 * Author: qqy
 */
public class Test4 {
    public static void main(String[] args) {
        //Vector相似于ArrayList
        List<String> vector=new Vector<>();
        vector.add("jack");
        vector.add("mary");
        System.out.println(vector);

        //Enumeration相当于迭代器(old API,了解即可)
        Enumeration<String> enumeration=((Vector<String>) vector).elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}
