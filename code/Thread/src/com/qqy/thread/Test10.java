package com.qqy.thread;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

/**
 * join（）
 * Author: qqy
 */
public class Test10{
    public static void main(String[] args) {
        System.out.println("main线程开始");
        //业务逻辑
        MyThread7 mt=new MyThread7();
        //线程
        Thread thread=new Thread(mt,"A");
        thread.start();
        //在主线程中调用线程对象的join方法，会阻塞主线程
        //直到调用线程对象的run方法执行完毕，主线程才会继续执行
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main线程结束");

    }

    public static void printTime(){
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str=dateFormat.format(date);
        System.out.println(str);
    }
}

class MyThread7 implements Runnable{
    @Override
    public void run() {
        System.out.println("main线程休眠开始");
        Test10.printTime();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main线程休眠结束");
        Test10.printTime();
    }
}
