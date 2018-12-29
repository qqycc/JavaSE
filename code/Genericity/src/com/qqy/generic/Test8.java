package com.qqy.generic;

/**
 * 泛型擦除
 * Author: qqy
 */
public class Test8 {
    public static void main(String[] args) {
        Message<String> message1 = new Message<>();
        message1.setMessage("hello");

        Message<Integer> message2 = new Message<>();
        message2.setMessage(100);

        System.out.println(message1.getMessage());
        System.out.println(message2.getMessage());

        //利用instanceof验证
        System.out.println(message1 instanceof Message);
        System.out.println(message2 instanceof Message);

        //利用getClass()返回的类型验证
        System.out.println(message1.getClass().getName());
        System.out.println(message2.getClass().getName());


    }
}

class Message<T> {

    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}