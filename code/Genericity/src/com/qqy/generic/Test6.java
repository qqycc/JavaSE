package com.qqy.generic;

/**
 * 泛型下限
 * Author: qqy
 */
public class Test6 {
    public static void main(String[] args) {
        MyClass<String> my1 = new MyClass<>();
        my1.setValue("bonjour");
        print(my1);
    }

    public static void print(MyClass<? super String> my) {
        System.out.println(my.getValue());
    }
}

