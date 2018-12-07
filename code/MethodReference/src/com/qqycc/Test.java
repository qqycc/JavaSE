package com.qqycc;

/**
 * 引用静态方法
 * Author: qqy
 */

interface IUtil<P,R>{   //泛型
    R switchPara(P p);   //P类型—>R类型
}

public class Test {
    public static void main(String[] args) {
        //接口对象覆写抽象方法，该抽象方法的实现照用String的valueOf方法
        IUtil<Integer,String> util=String :: valueOf;
        //相当于调用String.valueOf(10);
        System.out.println(util.switchPara(10));
        System.out.println(Integer.valueOf(10));
    }
}
