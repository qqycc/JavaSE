package com.qqy.jcf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties基本使用
 * Author:qqy
 */
public class Test12 {
    public static void main(String[] args) {
        // *.properties ->  Properties
        //读取文件：load -> Properties   InputStream/Reader
        //写入文件：store -> *.properties OutputStream/Writer
        Properties properties = new Properties();
        try {
            //1.通过FileInputStream，缺点:当文件在源代码中，当代码挪动后，文件路径改变
//            properties.load(new FileInputStream("E:\JAVA\code\19.Collection\Collection\src\com\qqy\hello.properties"));
            //2.通过ClassLoader类加载器的方式读取属性文件时，指定包路径
            InputStream inputStream = Test12.class.getClassLoader().getResourceAsStream("com/qqy/hello.properties");
            properties.load(inputStream);

            //1.getProperty(key)
            //2.getProperty(key,defaultValue)
            System.out.println(properties.get("c++"));
            System.out.println(properties.getProperty("c++"));
            System.out.println(properties.getProperty("php"));   //null
            System.out.println(properties.getProperty("php", "PHP是最好的语言"));

            //赋值
            //1.put
            //2.setProperty (建议使用setProperty)
            properties.put("php", "PHP is best");
            properties.setProperty("Go", "Go is better");

            //存储
            properties.store(new FileOutputStream(
                    "E:\\JAVA\\code\\19.Collection\\Collection\\src\\com\\qqy\\hello1.properties"
            ), "写入数据");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
