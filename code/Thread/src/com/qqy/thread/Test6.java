package com.qqy.thread;

/**
 * 线程命名与取得
 * Author: qqy
 */
public class Test6 {
    public static void main(String[] args) {
        Thread thread=new Thread(new MyThread3());
        Thread thread1=new Thread(new MyThread3());
        ////如果没有起名字，默认为Thread-数字（从0开始，依次递增）
        System.out.println(thread.getName() );//Thread-0
        System.out.println(thread1.getName() );//Thread-1

        //线程启动后改名字
        thread.start();
        //自定义线程名
        thread.setName("vie");
        System.out.println(thread.getName() );//vie
    }
}

class MyThread3 implements Runnable{
    @Override
    public void run() {

    }
}
