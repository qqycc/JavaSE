package com.qqy.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到未尾时循环至开头继续进行
 * 求最后一个被删掉的数的原始下标位置。
 * 以8个数（N=7）为例：{0，1，2，3，4，5，6，7}，0->1->2（删除）->3->4->5（删除）->6->7->0（删除），
 * 如此循环直到最后一个数被删除。
 * Author:qqy
 */
public class Josephus {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int N=in.nextInt();
            Stack stack1=new Stack();
            Stack stack2=new Stack();
            int M=2;
            int count=M;
            if(M==0){
                System.out.println(N);
            }
            if(N==0){
                System.out.println(0);
            }
            //入栈
            for(int i=N-1;i>=0;i--){
                stack1.push(i);
            }
            //循环至只剩1个元素
            while(stack1.size()+stack2.size()!=1){
                //出M次，删1次
                while(count!=0){
                    isEmpty1(stack1, stack2);
                    stack2.push(stack1.pop());
                    count--;
                }
                isEmpty1(stack1, stack2);
                stack1.pop();
                count=M;
            }
            int result= (int) (stack1.isEmpty()?stack2.peek():stack1.peek());
            System.out.println(result);
        }


    }
    private static void isEmpty1(Stack stack1, Stack stack2) {
        if(stack1.isEmpty()){
            //把stack2中的数全部放入stack1
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }
}
