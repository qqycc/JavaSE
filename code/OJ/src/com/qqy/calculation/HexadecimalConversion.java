package com.qqy.calculation;

import java.util.Scanner;
import static java.lang.Math.pow;

/**
 * 十六进制转十进制（输入的字符串以0X开头）
 * Author:qqy
 */
public class HexadecimalConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine().substring(2);
            cal(str);
        }
    }

    public static void cal(String str) {
        int result = 0;
        for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
            char ch = str.charAt(i);
            int temp = 0;
            if (ch >= 'A' && ch <= 'Z') {
                switch (ch) {
                    case 'A': {
                        temp = 10;
                        break;
                    }
                    case 'B': {
                        temp = 11;
                        break;
                    }
                    case 'C': {
                        temp = 12;
                        break;
                    }
                    case 'D': {
                        temp = 13;
                        break;
                    }
                    case 'E': {
                        temp = 14;
                        break;
                    }
                    case 'F': {
                        temp = 15;
                        break;
                    }
                    case 'G': {
                        temp = 16;
                        break;
                    }
                }
            } else {
                temp = Integer.parseInt(String.valueOf(ch));
            }
            result+=temp * pow(16, j);
        }
        System.out.println(result);
    }
}
