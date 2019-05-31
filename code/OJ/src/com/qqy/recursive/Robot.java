package com.qqy.recursive;

/**
 * 有一个X*Y的网格，只能走格点且只能向右或向下走，要从左上角走到右下角。计算机器人有多少种走法。
 * 给定两个正整数int x，int y，请返回走法数目。保证x+y小于等于12。
 *
 * 思路
 *      向右走：x-1
 *      向下走：y-1
 *
 * Author:qqy
 */
public class Robot {
    public static int countWays(int x, int y) {
        if(x==0||y==0)return 0;
        if(x==1||y==1)return 1;
        return countWays(x-1,y)+countWays(x,y-1);
    }
}
