package com.qqy.thread;

/**
 * 利用多线程模拟卖票(程序共享)——Runnable
 * Author: qqy
 */
public class Test3 {
    public static void main(String[] args) {
        MyThread2 myThread=new MyThread2();
        new Thread(myThread,"Thread-A").start();
        new Thread(myThread,"Thread-B").start();
    }
}

class  MyThread2 implements Runnable{
    private Integer ticket=10;

    @Override
    public void run() {
        while(ticket>0){
            //Thread.currentThread()获取当前线程
            System.out.println(Thread.currentThread()+"剩余"+this.ticket--+"票");
        }
    }
}