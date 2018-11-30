package com.qqycc.Singleton;

import com.qqycc.Singleton.Singleton;

/**
 * Author: qqy
 */
public class TestSingleton {
    public static void main(String[] args) {
        //无法直接调用构造方法实例化对象，但可调用getInstance()
        Singleton singleton=Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();
        System.out.println(singleton==singleton1);   //true  getInstance()返回的是同一个对象
    }
}
