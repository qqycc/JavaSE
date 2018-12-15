package com.qqycc.stream.print;

/**
 * Author: qqy
 */
public class TestFormat {
    public static void main(String[] args) {
        System.out.printf("%s","bonjour");
        System.out.printf("姓名：%s，年龄：%d，身高：%.2f","李四",18,180.6);
        System.out.println();
        //正：右对齐，负：左对齐
        System.out.printf("姓名：%4s\n年龄：%-4d\n身高：%8.2f\n","张三",25,168.8);
        //java.util.Formatter
        //String.format,System.out.printf用法一直
        String str=String.format("姓名：%s\n年龄：%d\n身高：%.2f\n","张三",25,168.8);
        //System是类，out是对象
        System.out.println(str);
    }
}
