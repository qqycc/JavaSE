package com.qqy.string;

import java.util.Scanner;

/**
 * 消息加密：对消息原文中的每个字母，分别用该字母之后的第5个字母替换，并且消息原文的所有字母都是大写的。
 * 密码中的字母与原文中的字母对应关系如下。
 * 密码字母：ABCDEFGHIJKLMNOPQRSTUVWXYZ 原文字母：VWXYZABCDEFGHIJKLMNOPQRSTU
 * 现求解密后的明文
 * Author:qqy
 */
public class Decrypt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            char[] ch = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                ch[i] = str.charAt(i);
                if (ch[i] >69 && ch[i] < 91) {
                    ch[i] -= 5;
                    continue;
                }
                if (ch[i] > 64 && ch[i] < 70) {
                    ch[i] += 21;
                }
            }
            String res=String.valueOf(ch);
            System.out.println(res);
        }
    }
}
