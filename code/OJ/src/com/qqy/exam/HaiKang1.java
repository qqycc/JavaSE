package com.qqy.exam;

import static java.lang.Math.abs;

/**
 * 使用加法实现减乘除
 * Author:qqy
 */
public class HaiKang1 {
    public static int sub(int a, int b) {
        int value = (b < 0 ? 1 : -1);
        int res = 0;
        while (b != 0) {
            res += value;
            b += value;
        }
        return a + res;
    }

    public static boolean positive(int a, int b) {
        return (a > 0 && b > 0) || (a < 0 && b < 0);
    }

    public static int times(int a, int b) {
        if (abs(a) > abs(b)) return times(b, a); //faster
        int result = 0;
        for (int i = 1; i <= abs(a); i++) {
            result += abs(b);
        }
        if (positive(a, b)) return result;
        else return sub(0, result);
    }

    public static int divide(int a, int b) {
        int count = 0;
        for (int i = abs(a); i >= b; i -= abs(b)) {
            count++;
        }
        int remaining = sub(abs(a), times(abs(b), count));
        if (times(remaining, 2) >= abs(b)) {
            count++;
        }
        if (positive(a, b)) return count;
        else return sub(0, count);
    }
}
