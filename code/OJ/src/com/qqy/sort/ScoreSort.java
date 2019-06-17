package com.qqy.sort;

import java.util.*;

/**
 * 查找和排序
 * 输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列，相同成绩
 * 都按先录入排列在前的规则处理。
 * 输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开
 * Author:qqy
 */
public class ScoreSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int num = Integer.parseInt(in.nextLine());
            int order = Integer.parseInt(in.nextLine());
            //将学生与成绩以键值对的形式存储（按输入顺序存储）
            Map<String, String> map = new LinkedHashMap<>();
            for (int i = 0; i < num; i++) {
                String str = in.nextLine();
                String[] temp = str.split(" ");
                map.put(temp[0], temp[1]);
            }
            //将成绩存入一个数组
            Collection coll = map.values();
            Object[] score = coll.toArray();
            if (score.length != 0) {
                //对成绩进行排序
                bubbleSort(score, order);
                String val = "";
//                for (int i = 0; i < num; i++) {
                int i = 0;
                while (i < num) {
                    if (score[i] != val) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if ((score[i]).equals(entry.getValue())) {
                                System.out.println(entry.getKey() + " " + entry.getValue());
                                val = entry.getValue();
                            }
                        }
                    }
                    i++;
                }
//                }
            }
        }
    }

    public static void bubbleSort(Object[] array, int order) {
        //假设有序
        boolean flag = true;
        //外部循环一共需要n-1次冒泡排序
        for (int i = 0; i < array.length - 1; i++) {
            //外部循环第i次需要比较n-2-i次
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (order == 0) {
                    //将两个数字中较小的置后
                    if (Integer.parseInt((String) array[j]) < Integer.parseInt((String) array[j + 1])) {
                        Object t = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = t;

                        //进入到if中，则表明有数字进行交换,无序
                        flag = false;
                    }
                } else {
                    //将两个数字中较大的置后
                    if (Integer.parseInt((String) array[j]) > Integer.parseInt((String) array[j + 1])) {
                        Object t = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = t;
                        //进入到if中，则表明有数字进行交换,无序
                        flag = false;
                    }
                }
            }
            //有序，退出循环
            if (flag) {
                break;
            }
        }
    }
}
