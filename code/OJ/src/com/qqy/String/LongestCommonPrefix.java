package com.qqy.String;

/**
 * 查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 思路：
 * 1. 比较所有字符串的第一个字符，相同->存储，不同 -> 返回
 * 2.在第一个字符相同的情况下，比较第二个字符，以此类推
 * Author:qqy
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        //不能缺少，否则，数组越界异常
        if (strs.length == 0) {
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }

        String str="";
        int p=0;
        while(true){
            for(int i=0;i<strs.length-1;i++){
                if(strs[i].length()<=p||strs[i+1].length()<=p||strs[i].charAt(p)!=strs[i+1].charAt(p))
                    return str;
            }
            str+=strs[0].substring(p, p+1);
            p++;
        }
    }

    public static void main(String[] args) {
        String[] str={"flower","flow","flew"};
        System.out.printf(longestCommonPrefix(str));
    }
}
