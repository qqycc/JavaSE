package com.qqy.search;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 思路：
 *      利用二分法，取得mid值后，求其平方与所给值进行比较。
 * Author:qqy
 */
public class MySqrt {
    public int mySqrt(int x) {
        long left=1;
        long right=x;
        while(left<right){
            long mid = (right-left)/2+left;
            long com=mid*mid;
            if(com==x){
                return (int)mid;
            }else if(com>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(left*left>x){
            left--;
        }
        return (int)left;
    }
}
