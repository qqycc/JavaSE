package com.qqy.String;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 思路：
 *      先去掉字符串前后的空格，再计算每一个单词的长度，碰到空格就清零。
 *
 * Author:qqy
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        s=s.trim();
        if(s.isEmpty()){
            return 0;
        }

        int len=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                len=0;
            }else{
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String s="a ";
        System.out.println(lengthOfLastWord(s));
    }
}
