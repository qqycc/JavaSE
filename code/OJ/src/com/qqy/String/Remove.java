package com.qqy.string;


/**
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
 * 例如，输入"They are students."和"aeiou"，则删除之后的第一个字符串变成"Thy r stdnts."
 * 思路
 *      将第一个字符串转化为数组，依次判断该数组中的每一个字符是否包含在第二个字符串中
 *      不包含，打印。
 * Author:qqy
 */
public class Remove {
    public static void main(String[] args) {
        remove("They are students", "aeiou");
    }

    public static void remove(String a, String b) {
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!b.contains(String.valueOf(chars[i]))) {
                System.out.print(chars[i]);
            }
        }
    }
}
