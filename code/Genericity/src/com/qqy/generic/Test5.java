package com.qqy.generic;

/**
 * 泛型上限
 * Author: qqy
 */
public class Test5 {
    public static void main(String[] args) {
        MyClass1<Integer> my1 = new MyClass1<>();
        my1.setValue(123);
        print(my1);
    }

    public static void print(MyClass1<? extends Number> my) {
        System.out.println(my.getValue());
    }
}

//类中设定泛型上限不能用？
class MyClass1<T extends Number> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}