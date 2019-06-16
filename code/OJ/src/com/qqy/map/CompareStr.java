package com.qqy.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入字符串包含[0-9]、[a-z]、[A-Z]
 * 给定两个字符串，判断第二个字符串中出现的字符以及其个数是否是第一个字符串的子集。
 * 如果是，那么输出"Yes"和有多少多余的字符；如果不是，那么输出"No"和缺了多少字符。
 * 思路：
 * 利用Map存储每个字符串中的字符及其个数，之后进行比较。
 * Author:qqy
 */
public class CompareStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String sell = in.nextLine();
            String buy = in.nextLine();
            System.out.println(compare(sell, buy));
        }
    }

    public static String compare(String sell, String buy) {
        //若第一个字符串比第二个短，肯定不符合
        if (sell.length() < buy.length()) {
            return "No " + (buy.length() - sell.length());
        }

        Map<Character, Integer> sellMap = toMap(sell);
        Map<Character, Integer> buyMap = toMap(buy);

        boolean flag = true;
        int lack = 0, plus = 0;
        for (Map.Entry<Character, Integer> entry : buyMap.entrySet()) {
            if (sellMap.containsKey(entry.getKey())) {
                int sellCount = sellMap.get(entry.getKey());
                int buyCount = entry.getValue();
                if (sellCount < buyCount) {
                    lack += (buyCount - sellCount);
                    flag = false;
                } else if (sellCount > buyCount) {
                    plus += sellCount - buyCount;
                }
            }else{
                flag=false;
                lack+=entry.getValue();
            }
        }
        if (flag) {
            for (Map.Entry<Character, Integer> entry : sellMap.entrySet()) {
                if (!buyMap.containsKey(entry.getKey())) {
                    plus += entry.getValue();
                }
            }
            return "Yes " + plus;
        } else {
            return "No " + lack;
        }
    }

    public static Map<Character, Integer> toMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                //包装类不能直接进行“+，-,*,/，++，--”
                int count = map.get(ch);
                map.put(ch, ++count);

                map.put(ch,map.get(ch)+1);
//                map.put(ch,++map.get(ch));
            }
        }
        return map;
    }
}
