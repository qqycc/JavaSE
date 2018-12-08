package com.qqycc.bulidin;

import java.util.function.Supplier;

/**
 * 供给型函数接口
 * Author: qqy
 */
class Person{
    public String name;
    public int age;

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return "Person{name="+this.name+"age="+this.age+"}";
    }
}

public class Test1 {
    public static void main(String[] args) {
        Supplier<Person> supplier=()->{
            return new Person("Mary", 18);
        };
        System.out.println(supplier.get());

        Supplier<String>supplier1="Hello"::toUpperCase;
        System.out.println(supplier1.get());
    }
}
