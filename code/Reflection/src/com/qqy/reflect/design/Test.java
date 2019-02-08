package com.qqy.reflect.design;

/**
 * 传统代理模式 —— 基于接口，每一个接口都有一个子类和一个代理类
 * Author:qqy
 */
public class Test {
    public static void main(String[] args) {
        ISubject subject=new ProxySubject(new RealSubject());
        subject.eat();
    }
}

interface ISubject{
    void eat();
}

class RealSubject implements ISubject{

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}

class ProxySubject implements ISubject{
    private ISubject subject;

    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void eat() {
        beforeEat();
        this.subject.eat();
        afterEat();
    }

    public void beforeEat(){
        System.out.println("洗手");
    }

    public void afterEat(){
        System.out.println("洗碗");
    }
}