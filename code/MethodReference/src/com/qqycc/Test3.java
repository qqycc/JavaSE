package com.qqycc;

/**
 * 引用构造方法
 * Author: qqy
 */

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + this.name + "age=" + this.age + "}";
    }
}

interface IUti3<R, PN, PR> {
    R createPer(PN p1, PR p2);
}

public class Test3 {
    public static void main(String[] args) {
        IUti3<Person, String, Integer> util = Person::new;
        //相当于调用了Person的new Person();
        System.out.println(util.createPer("张三", 45));
        Person per = new Person("张三", 45);
        System.out.println(per);
    }
}
