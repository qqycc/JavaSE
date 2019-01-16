package com.qqy.thread;

/**
 * 线程具有继承性
 * Author: qqy
 */
public class Test14 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority());
        Thread thread=new Thread(new MyThread11(),"子线程A");
        System.out.println(thread.getPriority());
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }
}

class MyThread11 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority());
        new Thread(new B(),"孙子线程B").start();
    }
}

class B implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority());
    }
}