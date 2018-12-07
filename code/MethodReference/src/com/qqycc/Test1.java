package com.qqycc;

/**
 * 引用对象方法
 * Author: qqy
 */
interface IUtil1<R>{   //泛型
    R switchPara();   //P类型—>R类型
}

public class Test1 {
    public static void main(String[] args) {
        IUtil1<String> util="hello"::toUpperCase;
        //相当于调用"hello".toUpperCase();
        System.out.println(util.switchPara());
        System.out.println("hello".toUpperCase());
    }
}
