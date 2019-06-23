package com.qqy.calculation;

/**
 * 统计所有小于非负整数 n 的质数的数量
 * 思路：
 *  采用厄拉多塞筛法
 *      先将 2~n放入表中，然后在 2 的上面画一个圆圈，然后划去 2 的其他倍数；
 *      第一个既未画圈又没有被划去的数是 3，将它画圈，再划去 3 的其他倍数；
 *      现在既未画圈又没有被划去的第一个数是 5，将它画圈，并划去5的其他倍数……
 *      依次类推，一直到所有小于或等于N的各数都画了圈或划去为止。
 *      这时，表中画了圈的以及未划去的那些数正好就是小于 N 的素数。
 *
 * Author:qqy
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        //建立数组存放数字0~n-1,长度为n
        boolean[] arr=new boolean[n];
        //先全部设置为true
        //下标n，对应n
        //0和1不是质数，直接默认为false
        for(int i=2;i<n;i++){
            arr[i]=true;
        }

        //查找倍数，终止条件有内循环决定
        for(int i=2;i*i<n;i++){
            //且不为false（没有被画圈）
            if(arr[i]){
                //将倍数画圈
                //从i*i开始 -> i的i倍之前的都已经过处理
                for(int j=i*i;j<n;j+=i){
                    arr[j]=false;
                }
            }
        }

        int count=0;
        //利用foreach计数
        for(boolean item:arr){
            //素数为true
            count+= item?1:0;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
