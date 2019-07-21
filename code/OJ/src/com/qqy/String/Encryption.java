package com.qqy.string;

import java.util.Scanner;

/**
 * 字符串加解密
 * Author:qqy
 */
public class Encryption {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            char[] aucPassword=in.nextLine().toCharArray();
            char[] result=in.nextLine().toCharArray();
            encrypt(aucPassword);
            unEncrypt(result);
        }
    }

    public static void encrypt(char[] aucPassword){
        for(char ch:aucPassword){
            if((ch>='a'&&ch<'z')){
                ch= (char) (ch-('a'-'B'));
                System.out.print(ch);
                continue;
            }
            if(ch=='z'){
                ch='A';
                System.out.print(ch);
                continue;
            }
            if((ch>='A'&&ch<'Z')){
                ch= (char) (ch+('b'-'A'));
                System.out.print(ch);
                continue;
            }
            if(ch=='Z'){
                ch= 'a';
                System.out.print(ch);
                continue;
            }
            if(ch>='0'&&ch<'9'){
                ch= (char) (ch+1);
                System.out.print(ch);
                continue;
            }
            if(ch=='9'){
                ch='0';
                System.out.print(ch);
            }
        }
        System.out.print('\n');
    }

    public static void unEncrypt(char[] result){
        for(char ch:result){
            if((ch>'A'&&ch<='Z')){
                ch= (char) (ch+('a'-'B'));
                System.out.print(ch);
                continue;
            }
            if(ch=='A'){
                ch='z';
                System.out.print(ch);
                continue;
            }
            if((ch>'a'&&ch<='z')){
                ch= (char) (ch-('b'-'A'));
                System.out.print(ch);
                continue;
            }
            if(ch=='a'){
                ch='Z';
                System.out.print(ch);
                continue;
            }
            if(ch>'0'&&ch<='9'){
                ch= (char) (ch-1);
                System.out.print(ch);
                continue;
            }
            if(ch=='0'){
                ch='9';
                System.out.print(ch);
            }
        }
    }
}
