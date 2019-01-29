package com.qqy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射调用构造方法
 * Author: qqy
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            Class classes = Class.forName("com.qqy.reflect.Person");

            //1.构造方法
            //至少有一个构造方法
            Constructor[] constructors = classes.getConstructors();
            System.out.println("打印输出Person类的构造方法：");
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }

            System.out.println("打印输出Person类的一个参数的构造方法：");
            System.out.println(classes.getConstructor(java.lang.String.class));

            //2. class.newInstance => 直接通过类实例化对象 —— 类里面有无参数构造方法
            //Person();
            System.out.println((Person) classes.newInstance());

            //Person(String name)
            //3. Constructor => 获取构造方法对象，执行构造对象的newInstance(参数值...)
            Constructor constructor = classes.getConstructor(java.lang.String.class);
            //constructor.newInstance —— 类中可以没有无参数构造方法，直接传入参数值
            Person person = (Person) constructor.newInstance("张三");
            System.out.println(person);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Person {

    public String name;
    private Integer age;

    //无参构造方法
    public Person() {
    }

    //一个参数构造方法
    public Person(String name) {
        this.name = name;
    }

    //两个参数构造方法
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}