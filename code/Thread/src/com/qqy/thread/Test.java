package com.qqy.thread;

/**
 * 通过继承Thread类实现多线程
 * Author: qqy
 */
public class Test{
    //main()方法是主线程
    public static void main(String[] args) {
        MyThread myThread=new MyThread("线程1");
        MyThread myThread1=new MyThread("线程2");
        MyThread myThread2=new MyThread("线程3");
        //调用run（）方法，按顺序执行，不会启动线程，只是普通的方法调用
        myThread.run();
        myThread1.run();
        myThread2.run();
        //线程启动一定调用start（）方法,此方法会自动调用线程的run()方法，出现多线程交替
        myThread.start();
        myThread1.start();
        myThread2.start();
    }
}

class MyThread extends Thread{
    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    @Override
    //入口方法
    public void run() {
        //多线程处理的业务逻辑
        for(int i=0;i<10;i++){
            System.out.println(this.title+"、"+i);
        }
    }
}
