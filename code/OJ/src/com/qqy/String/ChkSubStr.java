package com.qqy.string;

/**
 * 子串判断
 * 现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p，判断p中的每一个较短字符串是否为s的子串。
 * 给定一个string数组p和它的大小n，同时给定string s为母串，返回一个boolean数组，每个元素代表p中的对应字符串是否为s的子串。
 * 保证p中的串长度小于等于8，且p中的串的个数小于等于500，同时保证s的长度小于等于1000。
 * Author:qqy
 */
public class ChkSubStr {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] result = new boolean[n];
        //依次比较p中的字符串
        for (int i = 0; i < n; i++) {
            String str = p[i];
            int len = p[i].length();
            boolean res = check(str, s, len);
            result[i] = res;
        }
        return result;
    }

    public static boolean check(String str, String s, int len) {
        //若p中字符串长度大于给定字符串长度，不是子串
        if (str.length() > s.length()) {
            return false;
        }
        //依次取出等长子字符串比较
        for (int j = 0; j <= s.length() - len; j++) {
            if (str.compareTo(s.substring(j, j + len)) == 0) {
                return true;
            }
        }
        return false;
    }
}
