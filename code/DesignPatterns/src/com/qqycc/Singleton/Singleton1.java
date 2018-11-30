package com.qqycc.Singleton;

/**
 * 懒汉式单例
 * Author: qqy
 */
public class Singleton1 {
    private static Singleton1 instance=null;

    private Singleton1(){
    }

    public static Singleton1 getInstance(){
        if(instance==null){
            return new Singleton1();
        }
        return instance;
    }
}
