package com.qqy.String;

import java.util.Stack;

/**
 * 回文结构
 * Author:qqy
 */
public class IsPalindrome {
    /**
     * 方法一：
     * 思路
     * 设置两个标记，一个从前向后走，另一个从后向前走不等时，返回false
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome1(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 方法二：
     * 思路
     * 将字符串从中间分开，
     * 1）字符串长度为奇数，将len/2-1入栈，每次跳出一个，和len/2+1开始比
     * 2）字符串长度为偶数，将len/2-1入栈，每次跳出一个，和len/2开始比
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        int len = str.length();
        Stack stack = new Stack();
        int index = len / 2;
        //将len/2-1入栈
        for (int i = 0; i < index; i++) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty() && index < str.length()) {
            //奇数
            if (len % 2 == 1) {
                if (!stack.pop().equals(str.charAt(1 + index++))) {
                    return false;
                }
            } else if (len % 2 != 1) {
                if (!stack.pop().equals(str.charAt(index++))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 将字符串B插入字符串A中，使得字符串A称为回文结构，并返回可插入的个数
     *
     * @param a
     * @param b
     * @return
     */
    public static int insert(String a, String b) {
        int count = 0;
        for (int i = 0; i <= a.length(); i++) {
            StringBuilder sb = new StringBuilder(a);
            sb.insert(i, b);
            if (isPalindrome(sb.toString())) {
                count++;
            }
        }
        return count;
    }
}
