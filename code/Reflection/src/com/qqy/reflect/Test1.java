package com.qqy.reflect;

import java.util.Date;

/**
 * Class对象获取
 * 1. object.getClass
 * 2. ClassName.class
 * 3. Class.forName("className");
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {

        Date date = new Date();

        //1.
        Class classz = date.getClass();

        //一般在开发反射的代码中我们经常使用类的全限定名（包名+类名）

        //2.
        Class<java.util.Date> dateClass = java.util.Date.class;
        System.out.println(dateClass);        //class java.util.Date
        try {
            Date date2 = dateClass.newInstance();
            System.out.println(date2);        //Sat Jan 19 08:32:58 CST 2019
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //3.
        Class dateClass1 = null;
        try {
            //注意使用全限定名
            dateClass1 = Class.forName("java.util.Date");
            System.out.println(dateClass1);    //class java.util.Date
        //类找不到异常
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //当前这三个Class对象都是由Class<java.util.Date>获取，都来描述
        //java.util.Date这个类
        System.out.println("比较三个Class对象");
        System.out.println(classz == dateClass);   //true
        System.out.println(classz == dateClass1);  //true

        //true原因：
        //Class类是描述我们在Java中定义的类
        //Class类的对象是Class文件加载到JVM中的标识对象（类加载器）
        //Class类的对象在JVM中有且只有一个
    }
}
