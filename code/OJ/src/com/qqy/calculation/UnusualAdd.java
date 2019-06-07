package com.qqy.calculation;

/**
 * 不使用运算符，将两个数字相加
 * 思路：
 *      位的异或运算跟求'和'的结果一致，位的与运算跟求'进位'的结果一致。
 * Author:qqy
 */
public class UnusualAdd {
    public static int addAB(int A, int B) {
        int xor,and;
        while(B!=0){
            xor = A^B;
            and = (A&B)<<1;
            A=xor;
            B=and;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(addAB(6,2));
    }
}
