package com.qqy.pc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者模型——多生产、多消费
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        Queue<Goods> goods=new LinkedList<>();
        //标记商品
        AtomicInteger name=new AtomicInteger(1);
        Object monitor=new Object();

        //两个生产者
        Producer producer=new Producer(goods,monitor,name);
        Producer producer1=new Producer(goods,monitor,name);
        //两个消费者
        Customer customer=new Customer(goods,monitor);
        Customer customer1=new Customer(goods,monitor);

        new Thread(producer,"生产者1").start();
        new Thread(producer1,"生产者2").start();
        new Thread(customer,"消费者1").start();
        new Thread(customer1,"消费者2").start();
    }
}

class Goods{
    private String name;

    public Goods(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                '}';
    }
}

//生产者
class Producer implements Runnable{
    private final Queue<Goods> goods;

    private final Object monitor;

    private final AtomicInteger atomicInteger;

    Producer(Queue<Goods> goods, Object monitor, AtomicInteger atomicInteger) {
        this.goods = goods;
        this.monitor = monitor;
        this.atomicInteger = atomicInteger;
    }


    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (monitor) {
                //商品池满了
                if (this.goods.size() == 10) {
                    try {
                        //等待，直到通知没有商品了
                        this.monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Goods goods=new Goods(String.valueOf(atomicInteger.getAndAdd(1)));
                    //将生产的商品加入队列
                    this.goods.add(goods);
                    //打印生产商品信息
                    System.out.println(Thread.currentThread().getName()+"  生产"+goods);
                }
            }
        }
    }
}

//消费者
class Customer implements Runnable{
    private final Queue<Goods> goods;

    private final Object monitor;

    Customer(Queue<Goods> goods, Object monitor) {
        this.goods = goods;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor){
                //商品为空，通知所有生产者
                if(this.goods.isEmpty()){
                    this.monitor.notifyAll();
                }else{
                    //消费商品
                    Goods goods=this.goods.poll();
                    //打印消费信息
                    System.out.println(Thread.currentThread().getName()+"  消费"+goods);
                }
            }
        }
    }
}