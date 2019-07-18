package com.qqy.string;

import java.util.Scanner;

/**
 * 一个字符串添加一个字符能否变为回文串
 * 思路：
 *  要么在头添加要么在尾添加，只需要判断去头或去尾的子字符串是否为回文串即可
 * Author:qqy
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            boolean flag=palindromeString(str);
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean palindromeString(String str){
        boolean flag=check(str);
        if(!flag){
            flag=check(str.substring(1));
            if(!flag){
                flag=check(str.substring(0,str.length()-1));
            }
        }
        return flag;
    }

    public static boolean check(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i++)!=str.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
