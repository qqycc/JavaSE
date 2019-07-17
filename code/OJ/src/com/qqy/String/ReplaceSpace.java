package com.qqy.string;

/**
 * 空格替换
 * Author:qqy
 */
public class ReplaceSpace {
    public static String replaceSpace(String iniString, int length) {
        String str=iniString.replace(" ","%20");
        return str;
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("Hello  Wor",10));
    }
}
