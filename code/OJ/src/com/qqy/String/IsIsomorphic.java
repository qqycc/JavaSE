package com.qqy.string;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 思路：
 * 1.若两个字符串长度不同，返回false
 * 2.取s和t第i个字符，将两个字符的下标比较
 *   若相等，删除该字符，继续比较。
 * Author:qqy
 */
public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        StringBuffer ss = new StringBuffer(s);
        StringBuffer st = new StringBuffer(t);
        if (ss.length() != st.length()) {
            return false;
        }

        while (ss.length()!=0) {
            char coms = ss.charAt(0);
            char comt = st.charAt(0);
            while (ss.indexOf(String.valueOf(coms))!= -1 && st.indexOf(String.valueOf(comt)) != -1) {
                int indexs=ss.indexOf(String.valueOf(coms));
                int indext=st.indexOf(String.valueOf(comt));
                if (indexs == indext) {
                    ss.deleteCharAt(indexs);
                    st.deleteCharAt(indext);
                }
                //两者一个含有字符，一个不含，返回false
                if(ss.indexOf(String.valueOf(coms))!=st.indexOf(String.valueOf(comt))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab","aa"));
    }
}
