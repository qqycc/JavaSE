package com.qqy.pc;

/**
 * 生产者与消费者模型——单生产、单消费
 * Author: qqy
 */
public class Test3 {
    public static void main(String[] args) {
        Goods1 goods1=new Goods1();
        Thread produceThread=new Thread(new Producer1(goods1),"生产者");
        Thread customThread=new Thread(new Customer1(goods1),"消费者");
        produceThread.start();
        customThread.start();
    }
}

//商品类
class Goods1{
    private String goodsName;
    private int count;

    //生产商品方法
    public synchronized void set(String goodsName){
        if (count>0){
            System.out.println("库存充足，稍等一会儿");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodsName=goodsName;
        this.count++;
        System.out.println(Thread.currentThread().getName()+"生产"+toString());
        //唤醒等待消费的线程，消费商品
        notify();
    }

    //消费商品方法
    public synchronized void get(){
        //不断判断执行条件
        if(count==0){
            System.out.println("无商品，稍等片刻");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;
        System.out.println(Thread.currentThread().getName()+"消费"+toString());
        //唤醒等待生产的线程，生产商品
        notify();
    }

    //toString
    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}

//消费者线程
class Customer1 implements Runnable{
    private Goods1 goods;

    public Customer1(Goods1 goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
            goods.get();
    }
}

//生产者线程
class Producer1 implements Runnable{
    private Goods1 goods;

    public Producer1(Goods1 goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        goods.set("YSL");
    }
}