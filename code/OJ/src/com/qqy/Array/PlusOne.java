package com.qqy.array;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 假设除了整数 0 之外，这个整数不会以零开头。
 * 思路：
 *      从后向前遍历数组，只要最后一个数不为9，直接加1；
 *      若为9.最后一位置0，继续向前检查；
 *      若检查到第一位都是9，新建一个数组，增加一位。
 * Author:qqy
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                if(i==0){
                    int[] arr=new int[digits.length+1];
                    arr[0]=1;
                    for(int j=1;j<arr.length;j++){
                        arr[j]=0;
                    }
                    digits=arr;
                    break;
                }
                digits[i]=0;
            }else{
                digits[i]+=1;
                break;
            }
        }
        return digits;
    }
}
