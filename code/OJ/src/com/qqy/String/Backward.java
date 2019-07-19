package com.qqy.string;

import java.util.Scanner;

/**
 * 反转字符串(单词不变)
 * Author:qqy
 */
public class Backward {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            String[] arr=str.split(" ");
            for(int i=arr.length-1;i>=0;i--){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
