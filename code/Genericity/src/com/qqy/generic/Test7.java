package com.qqy.generic;

/**
 * 泛型接口
 * Author: qqy
 */
public class Test7 {
    public static void main(String[] args) {
        IGeneric<Integer> iGeneric=new GenericImpl<Integer>();
        System.out.println(iGeneric.test(25));
        IGeneric iGeneric1=new GenericImpl1();
        System.out.println(iGeneric1.test("bonjour"));
    }
}

interface IGeneric<T>{
    T test(T t);
}

//1.子类继续保留泛型
class GenericImpl<T> implements IGeneric<T>{

    @Override
    public T test(T t) {
        return t;
    }
}

//2.子类定义时给出具体类型
class GenericImpl1 implements IGeneric<String>{

    @Override
    public String test(String s) {
        return s;
    }
}