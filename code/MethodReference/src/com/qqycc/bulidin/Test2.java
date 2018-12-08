package com.qqycc.bulidin;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 功能型+供给型
 * Author: qqy
 */

class Person1{
    public String name;
    public int age;

    public Person1(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return "Person{name="+this.name+"age="+this.age+"}";
    }
}

public class Test2 {
    public static void main(String[] args) {
        //y=f(x)   x->Supplier,y->String
        Function<Supplier<Person>, String> function=(s)->{
            return s.get().toString();
        };
        //x=g()    (),x->Person
        Supplier<Person> s=()->{
            return new Person("Mary",18);
        };

        String res=function.apply(s);
        System.out.println(res);
    }
}
