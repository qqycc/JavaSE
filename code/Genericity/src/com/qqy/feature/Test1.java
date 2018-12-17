package com.qqy.feature;

/**
 * 传递多类参数（包含可变参数）
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        print("hello");
        print("hello", " world ");
        String str1 = "C'est";
        String str2 = "la";
        String str3 = "vie!";
        System.out.println(str1 + " " + str2 + " " + str3);
        print(str1, " ", str2, " ", str3);
    }

    //传递多类参数，可变参数一定放在最后，并且只能设置一个可变参数
    public static void print(String message, String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message);
        for (int i = 0; i < args.length; i++) {
            stringBuilder.append(args[i]);
        }
        System.out.println(stringBuilder.toString());
    }
}
