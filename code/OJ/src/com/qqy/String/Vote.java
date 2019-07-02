package com.qqy.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 记票投票
 * Author:qqy
 */
public class Vote {
    public static Map<String,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int people=Integer.parseInt(in.nextLine());
            String[] peoplename=in.nextLine().split(" ");
            int vote=Integer.parseInt(in.nextLine());
            String[] votename=in.nextLine().split(" ");

            int count=0;
            for(int i=0;i<people;i++){
                AddCandidate(peoplename[i]);
            }
            for(int j=0;j<vote;j++){
                vote(votename[j]);
            }
            for(Map.Entry<String,Integer> entry:map.entrySet()){
                System.out.println(entry.getKey()+":"+entry.getValue());
                count+=entry.getValue();
            }
            System.out.println("Invalid:"+(vote-count));
        }
    }

    public static int AddCandidate(String name){
        if(!map.containsKey(name)){
            map.put(name,0);
            return 1;
        }
        return 0;
    }

    public static void vote(String name){
        if(map.containsKey(name)){
            int count=map.get(name);
            count++;
            map.put(name,count);
        }
    }
}
