package com.qqy.string;

import java.util.Scanner;

/**
 * 删除指定字符
 * Author:qqy
 */
public class RemovePublicChar {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str1=in.nextLine();
            String str2=in.nextLine();
            for(int i=0;i<str1.length();i++){
                if(!str2.contains(String.valueOf(str1.charAt(i)))){
                    System.out.print(str1.charAt(i));
                }
            }
        }
    }
}
