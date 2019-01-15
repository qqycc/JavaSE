package com.qqy.thread;

/**
 * 调用Thread类的interrupt（）方法
 * Author: qqy
 */
public class Test12 {
    public static void main(String[] args) {
        MyThread9 mt=new MyThread9();
        Thread thread=new Thread(mt,"A");
        thread.start();
        try {
            //主线程休眠
            Thread.sleep(6000);
            //主动调用thread中断方法
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread9 implements Runnable{

    @Override
    public void run() {
        int i=1;
        while(true){
            try {
                //判断线程的中断情况
                boolean bool=Thread.currentThread().isInterrupted();
                System.out.println(Thread.currentThread().getName()+"第"+i+"次执行");
                System.out.println(bool);
                //非阻塞情况
                if (bool){
                    System.out.println("线程退出");
                    break;
                }
                //阻塞情况
                i++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("阻塞中断，异常抛出，线程停止");
                boolean bool=Thread.currentThread().isInterrupted();
                System.out.println("Catch块中中断状态为："+bool);
                return;
            }
        }
    }
}