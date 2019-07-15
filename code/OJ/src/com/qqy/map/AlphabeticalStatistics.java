package com.qqy.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 计算字符串中大写字母出现的次数
 * Author:qqy
 */
public class AlphabeticalStatistics {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            count(str);
        }
    }

    public static void count(String str){
        Map<Character,Integer> map =new HashMap<>();
        for(int i='A';i<='Z';i++){
            map.put((char)i,0);
        }
        for(int j=0;j<str.length();j++){
            char ch=str.charAt(j);
            if(ch>='A'&&ch<='Z'){
                int count= map.get(ch);
                count++;
                map.put(ch,count);
            }
        }
        print(map);
    }

    public static void print(Map<Character,Integer> map){
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
