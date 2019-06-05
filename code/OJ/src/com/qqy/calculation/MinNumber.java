package com.qqy.calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定数字0-9各若干个。任意顺序排列这些数字，但必须全部使用。
 * 使得最后得到的数尽可能小（注意0不能做首位）。
 * 例如：给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
 * <p>
 * 思路:
 * 将大的数字放在集合的后面，按顺序追加，直到1为止。
 * 若0的个数不为空，留一个1，先将0追加完
 * Author:qqy
 */
public class MinNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] count = new int[10];
        for(int i=0;i<10;i++){
            count[i] = in.nextInt();
        }
        List<Integer> list = new ArrayList<Integer>();
        //到1为止，再对是否存在0进行讨论
        for (int j = 9; j > 0; j--) {
            while (count[j] != 0) {
                list.add(0, j);
                count[j]--;
            }
        }
        //有0,将0插入下标为1的位置
        while (count[0]!=0) {
            list.add(1,0);
            count[0]--;
        }
        Object[] objects=list.toArray();
        for(int k=0;k<objects.length;k++){
            System.out.print(objects[k]);
        }
    }
}
