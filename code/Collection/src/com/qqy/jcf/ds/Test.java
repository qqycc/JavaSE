package com.qqy.jcf.ds;

import java.util.Stack;

/**
 * 栈
 * Author:qqy
 */
public class Test {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println("当前栈是否为空：" + stack.isEmpty());
        //入栈
        stack.push("Java");
        stack.push("C++");
        stack.push("PHP");

        System.out.println("当前栈是否为空：" + stack.isEmpty());
        System.out.println("当前栈的元素个数：" + stack.size());

        //观察栈顶
        System.out.println("栈顶是否是PHP：" + "PHP".equals(stack.peek()));  //true

        //出栈
        System.out.println(stack.pop());//PHP
        System.out.println(stack.pop());//C++
        System.out.println(stack.pop());//Java
        //EmptyStackException
//        System.out.println(stack.pop());//?
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
