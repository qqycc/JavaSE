package com.qqy.String;

import java.util.Scanner;

/**
 * 密码验证
 * 要求：
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号，以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * Author:qqy
 */
public class PasswordVerification {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            if(verification(str)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }

    public static boolean verification(String str){
        //1.
        if(str.length()<=8){
            return false;
        }
        //2.设置4个标记
        int num=0;
        int upper=0;
        int lower=0;
        int other=0;
        char[] chars=str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(chars[i]>='0'&&chars[i]<='9'){
                num=1;
            }else if(chars[i]>='a'&&chars[i]<='z'){
                lower=1;
            }else if(chars[i]>='A'&&chars[i]<='Z'){
                upper=1;
            }else{
                other=1;
            }
        }
        if((num+lower+upper+other)<3){
            return false;
        }
        //3.
        for(int i=0;i<str.length()-3;i++){
            if(str.substring(i+3).contains(str.substring(i,i+3))){
                return false;
            }
        }
        return true;
    }
}