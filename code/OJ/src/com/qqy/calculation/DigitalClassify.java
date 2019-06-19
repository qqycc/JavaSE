package com.qqy.calculation;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
 * A1=能被5整除的数字中所有偶数的和；
 * A2=将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
 * A3=被5除后余2的数字的个数；
 * A4=被5除后余3的数字的平均数，精确到小数点后1位；
 * A5=被5除后余4的数字中最大数字。
 * 输入描述：
 * 每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
 * 输出描述：
 * 对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 * 若其中某一类数字不存在，则在相应位置输出“N"。
 *
 * 思路：
 *  A1：即能被10整除的数
 * Author:qqy
 */
public class DigitalClassify {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String input=in.nextLine();
            classify(input);
        }
    }

    public static void classify(String input){
        String[] arr=input.split(" ");
        int num=Integer.parseInt(arr[0]);
        String a1=A1(arr,num);
        String a2=A2(arr,num);
        String a3=A3(arr,num);
        String a4=A4(arr,num);
        String a5=A5(arr,num);
        System.out.println(a1+" "+a2+" "+a3+" "+a4+" "+a5);
    }

    public static String A1(String[] arr,int num){
        int result=0;
        boolean flag=false;
        for(int i=1;i<=num;i++){
            int temp=Integer.parseInt(arr[i]);
            if(temp%10==0){
                result+=temp;
                flag=true;
            }
        }
        if(!flag) {
            return "N";
        }
        return String.valueOf(result);
    }

    public static String A2(String[] arr,int num){
        int result=0;
        boolean flag=false;
        int j=0;
        for(int i=1;i<=num;i++){
            int temp=Integer.parseInt(arr[i]);
            if(temp%5==1){
                result+=(temp*Math.pow(-1,j++));
                flag=true;
            }
        }
        if(!flag) {
            return "N";
        }
        return String.valueOf(result);
    }

    public static String A3(String[] arr,int num){
        int count=0;
        for(int i=1;i<=num;i++){
            int temp=Integer.parseInt(arr[i]);
            if(temp%5==2){
                count++;
            }
        }
        if(count==0){
            return "N";
        }
        return String.valueOf(count);
    }

    public static String A4(String[] arr,int num){
        DecimalFormat dou=new DecimalFormat("0.0");
        boolean flag=false;
        double result=0;
        int count=0;
        for(int i=1;i<=num;i++){
            int temp=Integer.parseInt(arr[i]);
            if(temp%5==3){
                result+=temp;
                count++;
                flag=true;
            }
        }
        if(!flag) {
            return "N";
        }
        result/=count;
        return dou.format(result);
    }

    public static String A5(String[] arr,int num){
        int max=0;
        boolean flag=false;
        for(int i=1;i<=num;i++){
            int temp=Integer.parseInt(arr[i]);
            if(temp%5==4&&temp>max){
                max=temp;
                flag=true;
            }
        }
        if(!flag) {
            return "N";
        }
        return String.valueOf(max);
    }
}
