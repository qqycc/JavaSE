package com.qqy.newcheck.impl;

import com.qqy.newcheck.GoodsCenter;
import com.qqy.newcheck.Goods;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:qqy
 */
public class GoodsCenterImpl implements GoodsCenter {
    //创建商品集合，key -> 商品编号，value -> 商品名称
    private final Map<String, Goods> goodsMap = new HashMap<>();

    //将商品信息保存至goods.txt
    private String filePath = System.getProperty("user.dir") + File.separator + "goods.txt";

    @Override
    public void addGoods(Goods good) {
        this.goodsMap.put(good.getId(), good);
    }

    @Override
    public void removeGoods(String goodId) {
        this.goodsMap.remove(goodId);
    }

    //修改存在商品的名称
    @Override
    public void updateGoods(Goods good) {
        if (this.goodsMap.containsKey(good.getId())) {
            this.goodsMap.put(good.getId(), good);
        }
    }

    @Override
    public boolean isExistGoods(String goodId) {
        return this.goodsMap.containsKey(goodId);
    }

    @Override
    public Goods getGoods(String goodId) {
        return this.goodsMap.get(goodId);
    }

    @Override
    public String listGoods() {
        StringBuilder str = new StringBuilder();
        str.append("************** 商品信息 **************\n");
        str.append("\t编号\t\t\t名称\t\t\t单价\n");
        //根据商品名称获取商品信息
        for (Goods good : this.goodsMap.values()) {
            str.append("\t" + good.getId() + "\t\t\t" + good.getName() + "\t\t\t" + good.getPrice() + "\n");
        }
        str.append("*************************************\n");
        return str.toString();
    }

    @Override
    public void store() {
        System.out.println("保存所有商品信息到文件，每个商品信息 -> 编号：名称：价格");
        //将商品信息输出到goods.txt
        //输出格式 -> 商品编号：商品名称：商品价格
        File file = new File(filePath);
        //自动关闭流
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(file)
        )) {
            for (Goods goods : this.goodsMap.values()) {
                writer.write(String.format("%s:%s:%.2f\n", goods.getId(), goods.getName(), goods.getPrice()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        //读取goods.txt中的商品信息，经过处理，存入商品集合
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file)
        )) {
            String read;
            while((read=reader.readLine())!=null){
                String[] values=read.split(":");
                if(values.length==3){
                    Goods good=new Goods(values[0],values[1],Double.parseDouble(values[2]));
                    this.addGoods(good);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
