package com.qqy.reflect;

/**
 * 取得父类信息
 * Author: qqy
 */
public class Test2 {
    public static void main(String[] args) {
        //1.获取Class对象所描述的类的包
        //2.获取Class对象所描述的类的继承的类
        //3.获取Class对象所描述的类的实现的接口

        try {
            Class testClass = Class.forName("com.qqy.reflect.Test4");

            //1.
            Package packageObj = testClass.getPackage();
            System.out.println("打印包名：");
            System.out.println(packageObj.getName());//包名  com.qqy.reflect

            //getSuperclass()返回值只有一个 —— 单继承
            Class superclass = testClass.getSuperclass();
            System.out.println("打印父类toString()");
            System.out.println(superclass);        //class com.qqy.reflect.Test2
            System.out.println("打印父类SimpleName：" + superclass.getSimpleName());  //打印父类SimpleName：Test2
            System.out.println("打印父类Name：" + superclass.getName()); //打印父类Name：com.qqy.reflect.Test2

            Class[] classes = testClass.getInterfaces();
            System.out.println("打印实现的接口：");
            //interface com.qqy.reflect.IMessage
            //interface com.qqy.reflect.IFruit
            for (Class c : classes) {
                System.out.println(c);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

interface IMessage {

}

interface IFruit {

}

//隐式extends Object
class Test3 extends Test2 implements IMessage, IFruit {

}



