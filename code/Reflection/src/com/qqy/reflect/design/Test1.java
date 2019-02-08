package com.qqy.reflect.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理实现
 * Author:qqy
 */
public class Test1 {
    public static void main(String[] args) {
        ISubject1 subject1=(ISubject1)new ProxySubject1().bind(new RealSubject1());
        subject1.eat(2);
    }
}

interface ISubject1{
    void eat(int count);
}

class RealSubject1 implements ISubject1{

    @Override
    public void eat(int count) {
        System.out.println("吃"+count+"两饭");
    }
}

class ProxySubject1 implements InvocationHandler{
    private Object realObj;

    /**
     * 绑定真实主题类
     * @param realObj
     * @return 代理类
     */
    public Object bind(Object realObj){
        this.realObj=realObj;
        return Proxy.newProxyInstance(realObj.getClass().getClassLoader(),realObj.getClass().getInterfaces(),this);
    }

    public void before(){
        System.out.println("洗手");
    }

    public void after(){
        System.out.println("洗碗");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object result=method.invoke(realObj,args);
        this.after();
        return result;
    }
}