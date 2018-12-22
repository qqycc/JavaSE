package com.qqy.generic;

/**
 * 通配符？
 * Author: qqy
 */
public class Test4 {
    public static void main(String[] args) {
        MyClass<Double> my=new MyClass<>();
        my.setValue(10.2);
        print(my);
    }

    public static void print(MyClass<?> my){
        //通配符不可修改
        //my.setValue(200);
        System.out.println(my.getValue());
    }
}

class MyClass<T>{
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
