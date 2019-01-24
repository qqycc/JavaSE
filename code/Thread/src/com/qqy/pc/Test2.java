package com.qqy.pc;

/**
 * notify()
 * Author: qqy
 */
public class Test2 {
    public static void main(String[] args) {
        Object object=new Object();
        MyThread1 myThread1=new MyThread1(object,true);
        MyThread1 myThread2=new MyThread1(object,false);
        Thread waitThread=new Thread(myThread1,"等待线程");
        Thread notifyThread=new Thread(myThread2,"唤醒线程");
        waitThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThread.start();
    }
}

class MyThread1 implements Runnable{
    //锁定对象
    private Object object;
    //决定等待or唤醒
    private boolean flag;

    public MyThread1(Object object, boolean flag) {
        this.object = object;
        this.flag = flag;
    }

    //等待方法
    public void waitMethod(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"   wait()开始");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"   wait()结束");
        }
    }

    //唤醒方法
    public void notifyMethod(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"   notify()开始");
            object.notify();
            System.out.println(Thread.currentThread().getName()+"   notify()结束");
        }
    }
    @Override
    public void run() {
        if(flag){
            waitMethod();
        }else {
            notifyMethod();
        }
    }
}