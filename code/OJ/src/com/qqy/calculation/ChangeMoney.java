package com.qqy.calculation;

/**
 * 百万富翁(b)和陌生人(m)有一个换钱的计划。该计划如下：
 * m每天给 b 10万元，b第一天给我1分钱，第二天2分钱，第三天4分钱.…
 * 这样交换30天后，百万富翁交出了多少钱？陌生人交出了多少钱？（注意一个是万元，一个是分）
 * Author:qqy
 */
public class ChangeMoney {
    public static void main(String[] args) {
        long sumRich=30*10;
        long sumStranger=0;
        for(int i=1;i<=30;i++){
            sumStranger=sumStranger+(long)Math.pow(2,i-1);
        }
        System.out.print(sumRich+" "+sumStranger);
    }
}
