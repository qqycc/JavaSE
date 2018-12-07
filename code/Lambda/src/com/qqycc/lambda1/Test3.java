package com.qqycc.lambda1;

/**
 * 方法体只有一条命令的Lambda
 * Author: qqy
 */
@FunctionalInterface
interface Message{
    void chat();
}

public class Test3 {
    public static void main(String[] args) {
        // 接口不能实例化
        // 匿名内部类创建实例化对象
        Message msg=new Message() {
            @Override
            public void chat() {
                System.out.println("匿名内部类实现的message聊天");
            }
        };

        //Lambda表达式
        Message msg1=()-> System.out.println("Lambda实现的message聊天");

        msg.chat();
        msg1.chat();
    }

}
