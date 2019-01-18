package com.qqy.synchronization;

/**
 * synchronized对象锁
 * 全局锁
 * Author: qqy
 */
public class Test6 {
    public static void main(String[] args) {
        MyThread5 mt=new MyThread5();
        for(int i=0;i<3;i++){
            new Thread(mt,"线程"+i+"  ").start();
        }
    }
}

class MyThread5 implements Runnable{

    @Override
    public void run() {
        Sync2 sync=new Sync2();
        sync.test();
    }
}

class Sync2{
    //静态方法，锁住的是下方代码段
    public static synchronized void test(){
        System.out.println(Thread.currentThread().getName()+"test开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"test结束");
    }
}

//class Sync2{
//    //在代码块中锁住当前class对象
//    public void test() {
//        synchronized (Sync2.class) {
//            System.out.println(Thread.currentThread().getName() + "test开始");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "test结束");
//        }
//    }
//}