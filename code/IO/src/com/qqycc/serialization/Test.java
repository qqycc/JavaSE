package com.qqycc.serialization;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file=Paths.get("E:","JAVA","Test.txt").toFile();
        //取得相应输出流
        Person1 per=new Person1("张三",18);
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
        //数据序列化输出
        oos.writeObject(per);
        oos.close();

        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
        //数据反序列化输入
        Object res=ois.readObject();
        System.out.println(res);  //Person{name=张三 age=0"}
        ois.close();
    }
}

//Serializable  标识接口
class Person1 implements Serializable{
    private String name;
    private transient int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                " age=" + age +
                "\"}";
    }
}
