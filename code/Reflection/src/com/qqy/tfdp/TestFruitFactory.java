package com.qqy.tfdp;

/**
 * 测试
 * Author: qqy
 */
public class TestFruitFactory {
    public static void main(String[] args) {
        if (args.length == 1) {
            String fruitName = args[0];
            //传统工厂模式
            //IFruit fruit = IFruitFactory.getIFruit(fruitName);

            //简单工厂模式
            IFruit fruit = NewIFruitFactory.getIFruit(fruitName);
            fruit.eat();
        } else {
            System.out.println("程序没有输入参数");
        }
    }
}