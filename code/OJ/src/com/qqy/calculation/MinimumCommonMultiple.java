package com.qqy.calculation;

import java.util.Scanner;

/**
 * 最小公倍数
 * Author:qqy
 */
public class MinimumCommonMultiple {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

            int a=in.nextInt();
            int b=in.nextInt();

            for(int i=1;i<=b;i++){
                int res=i*a;
                if(res%b==0){
                    System.out.println(res);
                    break;
                }
            }

    }
}
