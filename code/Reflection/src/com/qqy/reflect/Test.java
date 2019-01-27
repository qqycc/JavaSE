package com.qqy.reflect;

import java.util.Date;

/**
 * 初识反射
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        //1.普通的一个对象，通过java.util.Date这个类实例化的
        Date date = new Date();
        //2.反向操作，反射
        Class classz = date.getClass();
        //调用toString()
        System.out.println(classz);
    }
}
