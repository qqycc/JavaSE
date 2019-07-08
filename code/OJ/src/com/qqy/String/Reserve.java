package com.qqy.string;

import java.util.Scanner;

/**
 * 给定一句英语，将句中所有单词的顺序颠倒输出。
 * Author:qqy
 */
public class Reserve {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] strs=in.nextLine().split(" ");
            System.out.print(strs[strs.length-1]);
            for(int i=strs.length-2;i>=0;i--){
                System.out.print(" "+strs[i]);
            }
        }
    }
}
