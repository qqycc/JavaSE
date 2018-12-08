package com.qqycc.bulidin;

import java.util.function.Consumer;

/**
 * 消费型函数式接口
 * Author: qqy
 */
public class Test3 {
    public static void main(String[] args) {
        Consumer<String> consumer=(str)->{
            System.out.println(str);
        };
        consumer.accept("Hello");

        Consumer<String[]> consumer1=(strs)->{
            for(String item:strs){
                System.out.println(item);
            }
        };
        consumer1.accept(new String[]{"v","i","e"});

        Consumer<String> consumer2=System.out::println;  //引用对象方法 out是一个对象
        consumer2.accept("C'est la vie");
    }
}
