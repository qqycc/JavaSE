package com.qqy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射调用普通方法
 * Author: qqy
 */
public class Test5 {
    public static void main(String[] args) {
        try {
            Class classes = Class.forName("com.qqy.reflect.Person");

            //1.获取Person类中的所有普通方法
            Method[] methods = classes.getMethods();
            for (Method m : methods) {
                System.out.println(m);
            }

            //2.获取Person类中的setName方法
            Method setNameMethod = classes.getMethod("setName", java.lang.String.class);

            //3.调用方法
            Person person = (Person) classes.newInstance();
            //set()返回值是void
            Object voidObject = setNameMethod.invoke(person, "张三");
            System.out.println("setName=" + voidObject);  //setName=null
            System.out.println(person);                   //Person{name='张三', age=null}
            //获取Person类中的getName方法
            Method getNameMethod = classes.getMethod("getName");
            Object stringObject = getNameMethod.invoke(person);
            System.out.println("getName=" + stringObject);   //getName=张三
            System.out.println(person);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
