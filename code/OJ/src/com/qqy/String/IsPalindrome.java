package com.qqy.String;

import java.util.Stack;

/**
 * 回文结构
 * Author:qqy
 */
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        String string=String.valueOf(x);
        int len=string.length();
        char[] num=new char[len];
        int count=len/2;
        Stack stack=new Stack();
        for(int i=0;i<len;i++) {
            num[i]=string.charAt(i);
            if(!Character.isDigit(num[0])){
                return false;
            }
            if(len%2!=1&&i<count){
                stack.push(num[i]);
            }else if(len%2==1&&i<=count) {
                stack.push(num[i]);
            }
        }
        while(!stack.isEmpty()){
            if((count>=len)||(!stack.pop().equals(num[count]))){
                return false;
            }
            count++;
        }
        return true;
    }

    public static void main(String[] args) {
        int i=12521;
        System.out.println(isPalindrome(i));
    }
}
