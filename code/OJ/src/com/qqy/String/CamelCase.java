package com.qqy.string;

import java.util.Scanner;

/**
 * 驼峰命名法
 * Author:qqy
 */
public class CamelCase {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            while(str.contains("_")) {
                int index = str.indexOf('_');
                str=str.replaceFirst("_", "");
                str=str.substring(0,index)+str.substring(index,index+1).toUpperCase()+str.substring(index+1);
            }
            System.out.println(str);
        }
    }
}
