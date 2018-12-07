package com.qqycc.lambda1;

/**
 * 抽象方法只有一个参数
 * Author: qqy
 */
@FunctionalInterface
interface IMessage{
    void print(String msg);
}

public class Test2 {
    public static void main(String[] args) {
        IMessage msg=new IMessage(){
            @Override
            public void print(String msg) {
                System.out.println(msg);
            }
        };

        //参数列表中的参数名不能和其他变量名冲突
        IMessage msg1=m-> System.out.println(m+" bonsoir");

        msg.print("hello"); //hello
        msg1.print("bonjour");  //bonjour bonsoir
    }
}
