package com.qqy.newcheck;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单类
 * Author:qqy
 */
public class Order {
    //订单创建完成之后，订单编号不能修改
    private final String orderId;

    //商品信息 -> 商品标号，商品数量
    //订单创建完成后，goodsInfo属性实例化HashMap
    private final Map<String, Integer> goodsInfo = new HashMap<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 添加商品
     * @param goodsId 商品编号
     * @param count   数量
     */
    public void add(String goodsId, Integer count) {
        //sum -> 改变后的商品数量
        Integer sum = this.goodsInfo.get(goodsId);
        //当前订单中不存在该商品
        if (sum == null) {
            sum = count;
        } else {
            sum += count;
        }
        //将新的商品数量与商品编号关联起来
        this.goodsInfo.put(goodsId, sum);
    }

    /**
     * 减少商品
     * @param goodsId
     * @param count
     */
    public void cancel(String goodsId, Integer count) {
        Integer sum = this.goodsInfo.get(goodsId);
        //当前订单存在该商品
        if (sum != null) {
            sum-=count;
            if(sum<=0){
                this.goodsInfo.remove(goodsId);
            }else{
                this.goodsInfo.put(goodsId,sum);
            }
        }
    }

    /**
     * 清空所有商品
     */
    public void clear() {
        System.out.println("清空本次订单中的所有信息...");
        this.goodsInfo.clear();
    }

    /**
     * 获得订单编号
     * @return
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 获得订单信息
     * @return
     */
    public Map<String, Integer> getOrderInfo() {
        return this.goodsInfo;
    }
}
