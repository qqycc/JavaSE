package com.qqycc.bulidin;

import java.util.function.Predicate;

/**
 * Author: qqy
 */
class Person2{
    public String name;
    public int age;

    public Person2(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return "Person{name="+this.name+"age="+this.age+"}";
    }
}

public class Test4 {
    public static void main(String[] args) {
        Predicate<String> predicate="Hello"::endsWith;
        //等价于"Hello".endsWith
        boolean res=predicate.test("o");
        System.out.println(res);  //true

        //参数 Object类型，判断——若参数对象是由Person类实例化的，返回true，否则返回false
        Predicate<Object> predicate1=(obj)->{
            return obj instanceof Person2;
        };
        System.out.println(predicate1.test("Hello")); //false
        System.out.println(predicate1.test(new Person2("Lila",20)));  //true

        predicate1="String"::equals;
        System.out.println(predicate1.equals("String"));  //false
    }
}
