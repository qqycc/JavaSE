package com.qqy.search;

import java.util.HashMap;
import java.util.Map;

/**
 * 查看红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。找到该红包金额。
 * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 * 若没有金额超过总数的一半，返回0。
 *
 * 思路：
 *     获取数组长度的一半记为len，将出现的金额存储在Map中，Map的key为金额，value为出现次数。
 *     将每个次数与len比较。
 * Author:qqy
 */
public class Gift {
    public int getValue(int[] gifts, int n) {
        int len=gifts.length/2;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<gifts.length;i++){
            if(!map.containsKey(gifts[i])){
                map.put(gifts[i],0);
            }else{
                int count=map.get(gifts[i]);
                count++;
                map.put(gifts[i],count);
            }
        }
        for(int i=0;i<gifts.length;i++){
            if(map.get(gifts[i])>len){
                return gifts[i];
            }
        }
        return 0;
    }
}
