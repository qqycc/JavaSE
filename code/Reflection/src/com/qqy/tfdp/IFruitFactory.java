package com.qqy.tfdp;

/**
 * 传统工厂模式
 * Author: qqy
 */
public class IFruitFactory {
    private IFruitFactory() {

    }

    public static IFruit getIFruit(String fruitName) {
        if ("apple".equalsIgnoreCase(fruitName)) {
            return new Apple();
        }
        if ("orange".equalsIgnoreCase(fruitName)) {
            return new Orange();
        }
        throw new IllegalArgumentException(fruitName + " not found");
    }
}
