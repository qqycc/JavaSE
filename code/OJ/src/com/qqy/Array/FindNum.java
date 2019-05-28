package com.qqy.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 每个测试输入包含n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
 * 输出出现次数大于等于n/2的数。
 *
 * Author:qqy
 */
public class FindNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list=new LinkedList<>();
        while (in.hasNextInt()) {
           list.add(in.nextInt());
        }

        int n = list.size();
        while (!list.isEmpty()) {
            Object num = ((LinkedList<Integer>) list).peek();
            int count = 0;
            while (list.contains(num)) {
                list.remove(num);
                count++;
            }
            if (count >= n / 2) {
                System.out.println(num);
                break;
            }
        }
    }
}
