package com.qqy.exam;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长不重复字串
 * Author:qqy
 */
public class GenShei2 {
    public int cal(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int count = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                count = Math.max(count, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return count;
    }
}
