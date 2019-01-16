package com.qqy.thread;

/**
 * 守护线程
 * 存在用户线程——主线程、Thread_B，守护线程——Thread_A，当Thread_B中断且主线程结束，Thread_A也随之结束
 * Author: qqy
 */
public class Test15 {
    public static void main(String[] args) {
        //主线程是用户线程
        System.out.println(Thread.currentThread().isDaemon());//false

        //线程1
        Thread threadA=new Thread(new DaemonRunnable(),"Thread_A");
        //将Thread_A设置为守护线程，此语句必须在start方法之前执行
        threadA.setDaemon(true);
        threadA.start();

        //线程2
        Thread threadB=new Thread(new DaemonRunnable(),"Thread_B");
        threadB.start();

        //主线程
        try {
            Thread.sleep(3000);
            //线程B中断（用户线程）
            threadB.interrupt();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DaemonRunnable implements Runnable {

    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "第" + i + "次");
                Thread.sleep(1000); //遇到中断走catch块
                i++;
            }
        } catch (InterruptedException e) {
            System.out.println("线程中断");
        }
    }
}