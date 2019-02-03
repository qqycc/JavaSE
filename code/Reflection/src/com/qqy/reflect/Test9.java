package com.qqy.reflect;

/**
 * 类加载器
 * Author:qqy
 */
public class Test9 {
    public static void main(String[] args) {
        Class<?> classz=Test.class;  //Class类的对象
        //取得当前类加载器
        System.out.println(classz.getClassLoader());
        //取得父加载器
        System.out.println(classz.getClassLoader().getParent());
        System.out.println(classz.getClassLoader().getParent().getParent());
    }
}
