package com.qqy.Stack;

import java.util.Stack;

/**
 * 栈实现队列的push和pop
 * Author:qqy
 */
public class StackQueue {
    Stack<Integer> left = new Stack<Integer>();
    Stack<Integer> right = new Stack<Integer>();

    public void push(int node) {
        right.push(node);
    }

    public int pop() {
        if (left.isEmpty()) {
            while (!right.isEmpty()) {
                left.push(right.pop());
            }
        }
        return left.pop();
    }

}
