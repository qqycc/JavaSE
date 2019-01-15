package com.qqy.thread;

/**
 * 线程优先级
 * Author: qqy
 */
public class Test13 {
    public static void main(String[] args) {
        //主线程优先级
        System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
        MyThread10 mt=new MyThread10();
        Thread thread=new Thread(mt,"A");
        Thread thread1=new Thread(mt,"B");
        Thread thread2=new Thread(mt,"C");

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class MyThread10 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
