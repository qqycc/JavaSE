package com.qqycc;

/**
 * 引用类中普通方法
 * Author: qqy
 */
interface IUtil2<R,P>{
    R compare(P p1,P p2);
}

public class Test2 {
    public static void main(String[] args) {
        IUtil2<Integer,String>util=String::compareTo;
        //相当于调用String.compareTo();
        System.out.println(util.compare("1","2"));
        System.out.println("1".compareTo("2"));
    }
}
