package com.qqy.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。
 * 首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。
 * 接着先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。
 * 接着把牌合并起来就可以了。
 * 例如有6张牌，最开始牌的序列是1，2，3，4，5，6。首先分成两组，左手拿着1，2，3；右手拿着4，5，6。
 * 在洗牌过程中按顺序放下了6，3，5，2，4，1。把这六张牌再次合成一组牌之后，按照从上往下的顺序看这组牌，就变成了序列1，4，2，5，3，6。
 * 给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
 * <p>
 * 思路：
 * 1.先获得组数、每组个数和k
 * 2.取得每组数据
 * 3.洗牌
 * Author:qqy
 */
public class ShuffleCards {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int group = 0, num = 0, k = 0, flag = 0, x = 0;
        StringBuilder print = new StringBuilder();
        group = list.get(0);
        for (; group > 0; group--) {
            flag += 1 + num * 2 + 2 * x;
            x = 1;
            num = list.get(flag);
            k = list.get(flag + 1);
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            List<Integer> result;
            //初始化左右链表
            for (int i = flag + 2; i < num + flag + 2; i++) {
                left.add(list.get(i));
            }
            for (int i = num + flag + 2; i < num * 2 + flag + 2; i++) {
                right.add(list.get(i));
            }
            k--;
            //第一次洗牌
            result = shuffle(left, right, num * 2);

            for (; k > 0; k--) {
                //更新左右链表的值
                for (int n = 0; n < num; n++) {
                    left.set(n, result.get(n));
                }
                for (int n = num; n < num * 2; n++) {
                    right.set(n - num, result.get(n));
                }
                result = shuffle(left, right, num * 2);
            }
            for (int count = 0; count < result.size(); count++) {
                print.append(" " + result.get(count));
            }
        }
        System.out.println(print.delete(0, 1));
    }


    public static List shuffle(List<Integer> left, List<Integer> right, int num) {
        List<Integer> res = new ArrayList<>();
        //初始化结果链表
        for (int z = 0; z < num; z++) {
            res.add(0);
        }
        int index = num / 2 - 1;
        //更新结果链表的值
        for (int j = num - 1; j >= 0; j -= 2, index--) {
            res.set(j, right.get(index));
        }
        index = num / 2 - 1;
        for (int j = num - 2; j >= 0; j -= 2, index--) {
            res.set(j, left.get(index));
        }
        return res;
    }
}
