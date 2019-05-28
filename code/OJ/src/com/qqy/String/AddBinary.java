package com.qqy.string;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * Author:qqy
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int mark=0;
        //只要其中一个没走完，就接着执行
        while (i >= 0 || j >= 0) {
            int sum=mark;
            if (i >= 0) {
                sum+=a.charAt(i--)-'0';
            }
            if (j >= 0) {
                sum+=b.charAt(j--)-'0';
            }
            builder.insert(0,sum%2);
            mark=sum/2;
        }
        if(mark>0){
            builder.insert(0,1);
        }
        return builder.toString();
    }
}
