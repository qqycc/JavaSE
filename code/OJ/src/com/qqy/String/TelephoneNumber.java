package com.qqy.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 电话的九宫格，一个数字对应一些字母，电话号码设计成与自己公司名字相对应。
 * 例如公司的Help Desk号码是4357，因为4对应H、3对应E、5对应L、7对应P，因此4357就是HELP。
 * 将一串电话号码列表转换成数字形式的号码，并去除重复的部分。
 * Author:qqy
 */
public class TelephoneNumber {
    public static void main(String[] args) {
        // symbol 和 number 对应下标的字符是有对应关系的.
        String symbol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number = "222333444555666777788899991234567890";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<String> arrayList = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String str = scanner.next();
                str = str.replace("-", "");
                String result = "";
                for (int j = 0; j < 7; j++) {
                    result += number.charAt(symbol.indexOf(str.charAt(j) + ""));
                }
                result = result.substring(0, 3) + "-" + result.substring(3, 7);
                if (!arrayList.contains(result)) {
                    arrayList.add(result);
                }
            }
            Collections.sort(arrayList);
            for (String anArrayList : arrayList) {
                System.out.println(anArrayList);
            }
            System.out.println();
        }
    }
}
