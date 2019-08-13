package com.qqy.string;

import java.util.Scanner;

/**
 * 输出字符串str中连续最长的数字字符串
 * 思路：
 *      1.将字符串转换为字符数组
 *      2.判断字符是否为数字
 *          是 -> 计数，记录下标为end
 *                  若 计数 > max，更新
 *          不是 -> 将计数与之前的max比较，计数归零
 *                  忽略继续向后走
 * Author:qqy
 */
public class MaxNumberString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int max=0;
            int end=0;
            int count=0;
            for(int i=0;i<str.length();i++){
                //是数字
                if(Character.isDigit(str.charAt(i))){
                    count++;
                    if(count>max){
                        max=count;
                        end=i;
                    }
                }else{
                    count=0;
                }
            }
            System.out.println(str.substring(end-max+1,end+1));
        }
    }
}
