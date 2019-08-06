package com.qqy;

/**
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 思路：
 *  以最小的价格买入，最大的价格卖出
 * Author:qqy
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        //局部最优
        int cur=0;
        //整体最优
        int total=0;
        for(int i=0;i<prices.length-1;i++){
            cur=Math.max(cur+prices[i+1]-prices[i],0);
            total=Math.max(cur,total);
        }
        return total;
    }
}
