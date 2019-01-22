package com.qqy.threadlocal;

/**
 * 内存泄漏
 * Author: qqy
 */
public class Test2 {
    public static void main(String[] args) {

    }
}

class MyRunnable implements Runnable{
    private ThreadLocal<String> threadLocal=new ThreadLocal<>();

    @Override
    public void run() {
        String name =Thread.currentThread().getName();
        threadLocal.set(name);
        System.out.println(name+"获取ThreadLocal的值"+threadLocal.get());
        //防止内存泄漏
        threadLocal.remove();
    }
}
