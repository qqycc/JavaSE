package com.qqy.string;

import java.util.Scanner;

/**
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。
 * G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，在其中找出GC-Ratio最高的子序列。
 * 思路：
 *  1.获取字符串和最小子序列长度
 *  2.利用substring遍历获取指定长度的子字符串。
 *  3.计算每个子字符串的GC-Ratio，若大于之前的，替换。
 * Author:qqy
 */
public class DNA {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            int num=in.nextInt();

            double gc=0;
            String store;
            String res="";
            for(int i=0;i<=str.length()-num;i++){
                int count=0;
                //左闭右开
                store=str.substring(i,i+num);
                //遍历，找出G和C出现的次数
                for(int j=0;j<store.length();j++){
                    if(store.charAt(j)=='G'||store.charAt(j)=='C'){
                        count++;
                    }
                }
                //注意类型的转换，不然除出来是int
                if((double)count/num>gc){
                    gc=(double)count/num;
                    res=String.valueOf(store.toCharArray());
                }
            }
            System.out.println(res);
        }
    }
}
