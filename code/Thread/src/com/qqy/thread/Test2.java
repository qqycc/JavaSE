package com.qqy.thread;

/**
 * 通过匿名内部类实现runnable接口
 * Author: qqy
 */
public class Test2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            //匿名内部类
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }

//    public static void main(String[] args) {
//        //匿名内部类、lambda表达式
//        Runnable runnable = () -> System.out.println("hello");
//        new Thread(runnable).start();
//    }
}

