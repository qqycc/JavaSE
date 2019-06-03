package com.qqy.calculation;

import java.util.Scanner;

/**
 * 打印正方形
 * Author:qqy
 */
public class Square {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int len=Integer.parseInt(in.next());
            char ch=in.next().charAt(0);
            start(len,ch);
            System.out.println();
            int num=0;
            if(len%2==0){
                num=len/2-2;
            }else{
                num=len/2-1;
            }
            for(int j=0;j<num;j++){
                mid(len,ch);
            }
            start(len,ch);
        }
    }

    public static void start(int len,char ch){
        for(int i=0;i<len;i++){
            System.out.print(ch);
        }
    }

    public static void mid(int len,char ch){
        System.out.print(ch);
        for(int i=0;i<len-2;i++){
            System.out.print(" ");
        }
        System.out.println(ch);
    }
}
