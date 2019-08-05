
package com.qqy;


import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        while(in.hasNext()){
            int personNum=in.nextInt();
            int[] score=new int[personNum+1];
            for(int i=1;i<=personNum;i++){
                score[i]=in.nextInt();
            }

            int queryNum=in.nextInt();
            int[] queryArr=new int[queryNum+1];
            for(int i=1;i<=queryNum;i++){
                queryArr[i]=in.nextInt();
            }

            for(int j=1;j<=queryNum;j++) {
                cal(queryArr[j],score);
            }
        }
    }

    public static void cal(int index,int[] score){
        int count=0;
        int compare=score[index];
        for(int temp:score){
            if(compare>temp){
                count++;
            }
        }
        double res=((double)count-1)/((double)score.length-1)*100;
        System.out.println(String.format("%.6f",res));
    }
}

