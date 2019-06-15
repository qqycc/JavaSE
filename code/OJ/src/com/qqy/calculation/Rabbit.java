package com.qqy.calculation;

import java.util.Scanner;

/**
 * Author:qqy
 */
public class Rabbit {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int month=in.nextInt();
            System.out.println(getRabbit(month));
        }
    }

    public static int getRabbit(int month){
        //前两个月只有一只兔子
        if(month==1||month==2){
            return 1;
        }
        //从第4个月开始
        //有生育能力的兔子记为old
        int old=1;
        //没有生育能力的兔子记为young，第四个月时已经生了一只,1个月大
        int young=1;
        //一个月大的兔子记为one
        int one=1;
        //两个月大的兔子记为two
        int two=0;
        for(int i=4;i<=month;i++){
            //第二个月的兔子拥有了生育能力
            old+=two;
            //第一个月的兔子变成了第二个月的兔子
            two=one;
            //有生育能力的生兔子
            one=old;
            //没有生育能力的=one+two
            young=one+two;
        }
        return old+young;
    }
}
