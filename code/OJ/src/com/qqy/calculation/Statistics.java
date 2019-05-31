package com.qqy.calculation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 数字统计
 * 给定N=100311，则有2个0，3个1，和1个3。
 * 每个输入包含1个测试用例，即一个不超过1000位的正整数N。
 * 对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。
 *
 * 思路
 *  利用HashMap存储统计数据，key为0,1....,9,value为出现次数
 * Author:qqy
 */
public class Statistics {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String num=in.next();
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<10;i++){
                map.put(i,0);
            }
            char[] chars=num.toCharArray();
            int i=0;
            while(i<num.length()){
                int key=chars[i]-'0';
                int val=map.get(key);
                val++;
                map.put(key,val);
                i++;
            }
            int j=0;
            while(j<10) {
                if(map.get(j)!=0) {
                    System.out.print(j+":"+map.get(j)+" ");
                }
                j++;
            }
        }
    }
}
