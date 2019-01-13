package com.qqy.thread;

/**
 * 主线程的默认名
 * Author: qqy
 */
public class Test7 {
    public static void main(String[] args) {
        Thread thread=new Thread(new MyThread4());
        thread.run();  //main
    }
}

class MyThread4 implements Runnable{
    @Override
    public void run() {
        //当前线程的名称
        System.out.println(Thread.currentThread().getName());
    }
}