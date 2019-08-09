package com.qqy;

import java.util.Scanner;

/**
 * 字符串交叉
 * Author:qqy
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strArr = str.split(" ");
            String res=cal(strArr[0], strArr[1], strArr[2])?"TRUE":"FALSE";
            System.out.println(res);
        }
    }

    public static boolean cal(String str1, String str2, String str3) {
        if (str1 == null || str2 == null || str3 == null) {
            return false;
        }
        if (str1.length() + str2.length() != str3.length()) {
            return false;
        }
        if (str1.length() <= 0 && str2.length() <= 0 && str3.length() <= 0) {
            return true;
        }


        boolean[][] common = new boolean[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length(); i++) {
            if (str1.charAt(i - 1) == str3.charAt(i - 1)) {
                common[i][0] = true;
            }
        }
        for (int i = 1; i < str2.length(); i++) {
            if (str2.charAt(i - 1) == str3.charAt(i - 1)) {
                common[0][i] = true;
            }
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str3.charAt(i + j - 1)) {
                    common[i][j] = common[i - 1][j];
                }
                if (common[i][j]) {
                    continue;
                }
                if (str2.charAt(j - 1) == str3.charAt(i + j - 1)) {
                    common[i][j] = common[i][j - 1];
                }
            }
        }
        return common[str1.length()][str2.length()];
    }
}
