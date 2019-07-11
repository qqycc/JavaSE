package com.qqy.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 找到缺少的字母
 * Author:qqy
 */
public class MissingLetters {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String comp=in.nextLine();
            String lack=in.nextLine();
            find(comp,lack);
        }
    }

    public static void find(String comp,String lack){
        List<Character> list=new ArrayList<>();
        int i=0,j=0;
        for(;i<comp.length()&&j<lack.length();i++){
            char ch=comp.charAt(i);
            if(ch==lack.charAt(j)){
                j++;
            }else{
                char temp=String.valueOf(ch).toUpperCase().charAt(0);
                if(!list.contains(temp)) {
                    list.add(temp);
                }
            }
        }
        if(i!=comp.length()-1){
            while(i==comp.length()-1){
                char temp=String.valueOf(comp.charAt(i)).toUpperCase().charAt(0);
                if(!list.contains(temp)) {
                    list.add(temp);
                }
            }
        }
        for(char ch:list) {
            System.out.print(ch);
        }
    }
}
