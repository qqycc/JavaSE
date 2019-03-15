package com.qqy.newcheck;

/**
 * 商品类
 * Author:qqy
 */
public class Goods {
    private String id;
    private String name;
    private double price;

    public Goods(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("[%2s] %s %.2f",this.getId(),this.getName(),this.getPrice());
    }
}
