package com.qqy.exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 最短路径问题
 * Author:qqy
 */
public class WanMei2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int len = str.length;

        int[][] road = new int[len][len];
        for (int j = 0; j < len; j++) {
            road[0][j] = Integer.parseInt(str[j]);
        }
        while (in.hasNextLine()) {
            for (int i = 1; i < len; i++) {
                str = in.nextLine().split(" ");
                for (int j = 0; j < len; j++) {
                    road[i][j] = Integer.parseInt(str[j]);
                }
            }

            dijkstra(road, len);
        }
    }

    public static void dijkstra(int[][] road, int len) {
        Queue visit = new LinkedList();
        int[] dis = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dis[i] = 0;
            }else if(road[0][i]!=-1){
                dis[i]=road[0][i];
            }else{
                dis[i]=Integer.MAX_VALUE;
            }
        }
        visit.add(0);
        while(visit.size()<len){
            int m=getIndex(visit,dis);
             visit.add(m);
             if(m!=-1){
                 for(int j=0;j<len;j++){
                     if(road[m][j]!=-1){
                         if(dis[j]>dis[m]+road[m][j]){
                             dis[j]=dis[m]+road[m][j];
                         }
                     }
                 }
             }
        }
        for(int h=1;h<len;h++){
            System.out.println(dis[h]);
        }

    }

    public static int getIndex(Queue queue,int[] dis){
        int m=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<dis.length;i++){
            if(!queue.contains(i)){
                if(dis[i]<min){
                    min=dis[i];
                    m=i;
                }
            }
        }
        return m;
    }
}
//0 1 12 -1 -1 -1
//        -1 0 9 3 -1 -1
//        -1 -1 0 -1 5 -1
//        -1 -1 4 0 13 15
//        -1 -1 -1 -1 0 4
//        -1 -1 -1 -1 -1 0