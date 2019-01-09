package com.qqy.jcf;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 覆写equals()
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        Person per = new Person("张三", 18);
        Person per1 = new Person("李四", 20);
        Person per2 = new Person("王五", 22);
        List<Person> list = new ArrayList<>();
        list.add(per);
        list.add(per1);
        list.add(per2);

        //借用Object定义的equals方法，比较地址是否相同
        //覆写equals()->true;不覆写->false
        System.out.println(list.contains(new Person("张三", 18)));
        list.remove(new Person("王五", 22));
        System.out.println(list);

        //Map<K,V>  K取hashCode
        Person jack = new Person("Jack", 22);
        Person jack2 = new Person("Jack", 22);
        System.out.println(jack.equals(jack2));//手工equals 覆写比内容,但hashCode值不同
        System.out.println(jack.hashCode() == jack2.hashCode());
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                " age=" + age +
                "}";
    }

    //手工覆写
//    @Override
//    public boolean equals(Object obj) {
//        //对象相同
//        if (this == obj) {
//            return true;
//        }
//        if (this == null) {
//            return false;
//        }
//        if (!(obj instanceof Person)) {
//            return false;
//        }
//        //向下转型为Person对象比较属性
//        Person per = (Person) obj;
//        return this.age == per.age && this.name.equals(per.name);
//    }

    //1. equals 和 hashCode 方法覆写一定要一起使用
    //2. equals参与判断的属性都要参与hashCode的计算
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}