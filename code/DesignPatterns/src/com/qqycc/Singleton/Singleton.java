package com.qqycc.Singleton;

/**
 * 饿汉式单例
 * Author: qqy
 */

public class Singleton {
    //为了不让INSTANCE被再次修改，添加final
    private static final Singleton INSTANCE =new Singleton();

    //为了满足一个类只允许实例化一个对象，将构造方法私有化
    private Singleton(){
    }

    //为了实例化对象，提供这个类的公开的静态方法
    public static Singleton getInstance(){
        return INSTANCE;
    }
}
