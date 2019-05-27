package com.qqy.calculation;

import java.util.Scanner;

/**
 * 输入一行4个整数，分别为A-B，B-C，A+B，B+C，用空格隔开。范围均在-30到30之间（闭区间）。
 * 输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。
 * 如果不存在这样的整数A，B，C，则输出No
 *
 * 思路
 * one+three=2A
 * two+four=2B
 * three-one=2B
 * four-two=2C
 * 若A、B、C其一不是整数，返回No
 * 若都为整数，判断两个B是否相等。
 *
 * Author:qqy
 */
public class SolutionNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int one = in.nextInt();
            int two = in.nextInt();
            int three = in.nextInt();
            int four = in.nextInt();
            if ((one + three) % 2 == 0 && (two + four) % 2 == 0 && (three - one) % 2 == 0 && (four - two) % 2 == 0) {
                int a = (one + three) / 2;
                int b1 = (two + four) / 2;
                int b2 = (three - one) / 2;
                int c = (four - two) / 2;
                if (b1 == b2) {
                    System.out.println(a + " " + b1 + " " + c);
                    break;
                }
            }
            System.out.println("No");
        }
    }
}
