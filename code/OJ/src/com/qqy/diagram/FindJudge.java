package com.qqy.diagram;

/**
 * 在一个小镇里，按从 1 到 N 标记了 N 个人
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 *
 * 思路：
 *  计算每个人的出度和入度，出度为0，入度为N-1的是法官
 * Author:qqy
 */
public class FindJudge {
    public int findJudge(int N, int[][] trust) {
        //出入度表
        int[][] person=new int[N][2];
        for(int[] temp:trust){
            //信任者
            int out=temp[0];
            //被信任者
            int in=temp[1];
            //出度
            person[out-1][0]++;
            //入度
            person[in-1][1]++;
        }
        for(int i=0;i<N;i++){
            if(person[i][0]==0&&person[i][1]==N-1){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust=new int[][]{{1,3},{2,3},{3,1}};
        System.out.println(new FindJudge().findJudge(3,trust));
    }
}
