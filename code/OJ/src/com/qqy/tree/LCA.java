package com.qqy.tree;

/**
 * 最近公共祖先
 * Author:qqy
 */
public class LCA {
    public static int getLCA(int a, int b) {
        if(a==b){
            return a;
        }
        return a>b?getLCA(a/2,b):getLCA(a,b/2);
    }

    public static void main(String[] args) {
        System.out.println(getLCA(9,7));
    }
}
