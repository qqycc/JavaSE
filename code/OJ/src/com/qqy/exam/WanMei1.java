package com.qqy.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 坐船问题
 * 第一行 体重
 * 第二行 承重
 * Author:qqy
 */
public class WanMei1 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNextLine()){
            String[] str=in.nextLine().split(" ");
            int limit=Integer.parseInt(String.valueOf(in.nextLine()));

            int[] people=new int[str.length];
            for(int i=0;i<str.length;i++){
                people[i]=Integer.parseInt(str[i]);
            }
            System.out.println(cal(people,limit));
        }
    }

    public static int cal(int[] people,int limit){
        int[] temp=new int[people.length];
        Arrays.sort(people);

        int count=0;
        int i=0;
        int j=people.length-1;
        while(i<=j){
            if(i==j){
                count++;
                break;
            }
            if(people[i]+people[j]>limit){
                count++;
                j--;
            }else {
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}
