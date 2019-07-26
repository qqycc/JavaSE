package com.qqy.string;

import java.util.Scanner;

/**
 * 单词反转 -> 去掉非字母的字符
 * Author:qqy
 */
public class ReserveSentence {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            str=str.replaceAll("[^A-Za-z]+"," ").trim();
            String[] arr=str.split(" ");
            System.out.print(arr[arr.length-1]);
            for(int i=arr.length-2;i>=0;i--){
                System.out.print(" "+arr[i]);
            }
        }
    }
}
