package com.qqy.map;

import java.util.*;

/**
 * 1.记录最多8条错误记录，对相同的错误记录（即文件名称和行号完全匹配）只记录一条，错误计数增加；（文件所在的目录不同，文件名和行号相同也要合并）
 * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；（如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并(直接忽略)）
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 * Author:qqy
 */
public class RecordCount1 {
    public static void main(String[] args) {
        String[] temp = new String[]{"E:\\V1R2\\product\\fpgadrive.c 1325", "D:\\fpgadriveewrwerer.c 1325", "F:\\fpgadriveewrwerer.c 1325", "F:\\fpwadriveewrwerer.c 1325"};
        cal(temp);
    }

    public static void print(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void cal(String[] temp) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int count;
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < temp.length; i++) {
            String str = temp[i].substring(temp[i].lastIndexOf('\\') + 1);
            if (str.split(" ")[0].length() <= 16) {
                if (!map.containsKey(str)) {
                    map.put(str, 1);
                } else {
                    count = map.get(str);
                    count++;
                    map.put(str, count);
                }
            } else {
                String cut = str.substring(str.length() - 16 - str.split(" ")[1].length());
                if (!map.containsKey(cut)) {
                    map.put(cut,1);
                }else {
                    if (list.contains(str)) {
                        count = map.get(cut);
                        count++;
                        map.put(cut, count);
                    }
                }
            }
            sum++;
            if(!list.contains(str)) {
                list.add(str);
            }
            if (sum == 8) {
                print(map);
                break;
            }
        }
        print(map);
    }
}
