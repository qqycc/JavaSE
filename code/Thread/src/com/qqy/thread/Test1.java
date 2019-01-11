package com.qqy.thread;

/**
 *  Runnable()接口实现多线程
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        MyThread1 myThread=new MyThread1("线程1");
        MyThread1 myThread1=new MyThread1("线程2");
        MyThread1 myThread2=new MyThread1("线程3");
        //无论哪种方式实现多线程，线程启动一定调用Thread类提供的start（）方法
        new Thread(myThread).start();
        new Thread(myThread1).start();
        new Thread(myThread2).start();
    }
}

class MyThread1 implements Runnable{
    private String title;

    public MyThread1(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(this.title+"、"+i);
        }
    }
}
