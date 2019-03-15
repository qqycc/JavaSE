package com.qqy.newcheck;

/**
 * 订单管理
 * Author:qqy
 */
public interface OrderCenter {
    /**
     * 添加订单
     * @param order 订单
     */
    void addOrder(Order order);

    /**
     * 删除订单
     * @param orderId
     */
    void removeOrder(String orderId);

    /**
     * 列出所有订单信息
     * @return
     */
    String ordersTable();

    /**
     * 列出当前订单信息（通过订单编号）
     * @param orderId
     * @return
     */
    String orderTable(String orderId);

    /**
     * 存储订单信息
     */
    void storeOrders();


    /**
     * 加载订单信息
     */
    String loadOrders();

    /**
     * 清空所有订单信息
     */
    void cleanOrders();

}


