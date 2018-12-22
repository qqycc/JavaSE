package com.qqy.generic;

/**
 * 泛型方法
 * Author: qqy
 */

//只有方法中有<*>，才是泛型方法
public class Test3 <T>{
    private T msg;

    //构造方法
    public Test3(T msg) {
        this.msg=msg;
    }

    public T getMsg() {
        return msg;
    }

    //普通方法,括号中的T只与类有关
    public void method(T t){
        System.out.println(t);
    }

    //泛型方法
    //泛型方法与泛型类相互独立
    //此时的<T>与泛型类中的<T>无关
    public static <T> void print(T data){
        System.out.println(data);
    }

    public static <T,S> void print(T data,S value){
        System.out.println(data+" "+value);
    }

    //带返回值的泛型方法
    //<T> 声明是泛型方法，T 返回值，括号中的T是泛型参数
    public static <T> T convert(T data){
        return data;
    }

    //成员方法
    public <E> void msgprint(E value){
        System.out.println(value);
    }

    public static void main(String[] args) {
        print("hello");
        print(21);
        print(new Test1<>(22,"你好"));
        print("bonjour",18);

        Test3<String> msg=new Test3<>("c'est la vie");
        System.out.println(msg.getMsg());

        msg.msgprint("Amour");

        System.out.println(convert(33));
        System.out.println(convert("bonjour"));
    }
}
