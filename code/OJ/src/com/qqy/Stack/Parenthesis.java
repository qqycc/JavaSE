package com.qqy.Stack;

import java.util.Stack;

/**
 * 给定一个字符串A和它的长度n，判断是否是合法的括号串
 * 思路：
 *      碰到(就入栈，碰到）出栈，若最后有剩余，返回false
 * Author:qqy
 */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack stack=new Stack();
        for(int i=0;i<n;i++){
            char cur=A.charAt(i);
            if(cur=='('){
                stack.push(cur);
            }else if(cur==')'){
                if(!stack.isEmpty()) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
