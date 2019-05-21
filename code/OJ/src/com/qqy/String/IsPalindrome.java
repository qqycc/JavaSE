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

    public static int insert(String a,String b) {
        if(a.isEmpty()||b.isEmpty()){
            return 0;
        }

        int count=0;
        int len=a.length()+b.length();
        char[] charsA=new char[len];
        char[] charsB=new char[b.length()];
        Stack stack=new Stack();
        //将字符串A转化为字符数组
        for(int i=0;i< a.length();i++){
            charsA[i]=a.charAt(i);
        }
        //将字符串B转化为字符数组
        for(int i=0;i< b.length();i++){
            charsB[i]=b.charAt(i);
        }
        //j记录B插入的位置
        for(int j=0;j<=a.length();j++) {
            //把B之前的先入栈
            for(int k=0;k<j;k++){
                stack.push(charsA[k]);
            }
            //入B
            for(int m=0;m<b.length();m++){
                stack.push(charsB[m]);
            }
            //把A中剩下的入栈
            for(int n=j;n<a.length();n++){
                stack.push(charsA[n]);
            }
            //出栈放入charsA中
            for(int z=0;z<charsA.length;z++){
                charsA[z]= (char) stack.pop();
            }
            String res=String.valueOf(charsA);
            boolean flag= isPalindrome(res);
            if(flag){
                count++;
            }
        }
        return count;
    }

    public static boolean isPalindrome(String str){
        int len=str.length();
        Stack stack=new Stack();
        int index=len/2;
        //将len/2-1入栈
        for(int i=0;i<index;i++){
            stack.push(str.charAt(i));
        }

        while(!stack.isEmpty()&&index<str.length()){
            //奇数
            if(len%2==1){
                if(!stack.pop().equals(str.charAt(1+index++))){
                    return false;
                }
            }else if(len%2!=1){
                if(!stack.pop().equals(str.charAt(index++))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a="bcbc";
        String b="c";
        System.out.println(insert(a,b));
    }
}
