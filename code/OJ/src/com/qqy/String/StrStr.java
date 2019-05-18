package com.qqy.String;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * 思路:
 *      从haystack的第一位开始，取得haystack中与needle等长的字符串，两者比较
 * Author:qqy
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if(haystack==null){
            return -1;
        }
        if(needle==null){
            return 0;
        }

        int len=needle.length();
        String hay;
        for(int i=0;i<haystack.length()-len+1;i++){
            hay=haystack.substring(i,i+len);
            if(hay.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
