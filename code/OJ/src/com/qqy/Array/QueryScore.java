package com.qqy.array;

import java.util.Scanner;

/**
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0<N<=30000，0<M<5000），分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来M行，每一行有一个字符C（只取Q或U），和两个正整数A，B
 *  当C为Q的时候，表示询问ID从A到B（包括A，B）的学生当中，成绩最高的是多少
 *  当C为U的时候，表示把ID为A的学生的成绩更改为B。
 * 输出描述：
 * 对于每一次询问操作，在一行里面输出最高成绩.
 * Author:qqy
 */
public class QueryScore {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int num=in.nextInt();
            int count=in.nextInt();
            int[] score=new int[num];
            for(int i=0;i<num;i++){
                score[i]=in.nextInt();
            }
            for(int j=0;j<count;j++){
                String req=in.next();
                int a=in.nextInt();
                int b=in.nextInt();
                if(req.equals("Q")){
                    int end=Math.max(a,b);
                    int start=Math.min(a,b);
                    int max=score[start-1];
                    for(int i=start;i<end;i++){
                        max=Math.max(max,score[i]);
                    }
                    System.out.println(max);
                }
                if(req.equals("U")){
                    score[a-1]=b;
                }
            }
        }
    }
}
