package com.qqy.calculation;

import java.util.Scanner;

/**
 * 整数与IP地址的转换
 * 思路：
 * IP -> 整数
 * 1.按.分割
 * 2.每部分化为二进制
 * 3.拼接起来
 * 4.转换为十进制
 * 整数 -> IP
 * 1.将十进制转换为二进制
 * 2.每8位转为十进制
 * 3.用.连接
 * <p>
 * Author:qqy
 */
public class IP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String ip = in.nextLine();
            int integer = in.nextInt();
            //IP -> 整数
            getNumber(ip);
            //整数 -> IP
            getIp(integer);
        }
    }

    public static void getNumber(String ip) {
        String[] strings = ip.split("\\.");
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 2; i++) {
            stringBuilder.append(binaryToDecimal(Integer.parseInt(strings[i]), true));
        }
        long num1 = decimalToBinary(Long.parseLong(stringBuilder.toString()), 16);
        stringBuilder.delete(0, 15);
        for (int i = 2; i < 4; i++) {
            stringBuilder.append(binaryToDecimal(Integer.parseInt(strings[i]), true));
        }
        long num2 = decimalToBinary(Long.parseLong(stringBuilder.toString()), 0);
        System.out.println(num1 + num2);
    }

    public static void getIp(int integer) {
        String binary = binaryToDecimal(integer, false);
        StringBuilder stringBuilder = new StringBuilder("");
        int first = 0;
        int last = 8;
        for (int i = 0; i < 4; i++, first += 8, last += 8) {
            String temp = binary.substring(first, last);
            stringBuilder.append(String.valueOf(decimalToBinary(Long.parseLong(temp), 0)));
            if (i != 3) {
                stringBuilder.append(".");
            }
        }
        System.out.println(stringBuilder);
    }

    //十进制转二进制
    public static String binaryToDecimal(int n, boolean flag) {
        StringBuilder str = new StringBuilder("");
        if (n == 0) {
            return "00000000";
        }
        while (n != 0) {
            str.append(n % 2);
            n = n / 2;
        }
        if (flag) {
            return String.format("%08d", Integer.parseInt(str.reverse().toString()));
        }

        int count = 32 - str.length();
        char[] ch = new char[count];
        for (int i = 0; i < count; i++) {
            ch[i] = '0';
        }
        return str.reverse().insert(0, ch).toString();
    }

    //二进制转十进制
    public static long decimalToBinary(long n, int p) {
        long decimal = 0l;
        while (true) {
            if (n == 0) {
                break;
            } else {
                long temp = n % 10;
                decimal += temp * Math.pow(2, p);
                n = n / 10;
                p++;
            }
        }
        return decimal;
    }
}
