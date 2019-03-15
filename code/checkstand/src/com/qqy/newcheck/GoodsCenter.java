package com.qqy.newcheck;

/**
 * 商品管理
 * Author:qqy
 */
public interface GoodsCenter {
    /**
     * 添加商品
     * @param good 商品
     */
    void addGoods(Goods good);

    /**
     * 删除商品（通过商品编号）
     * @param goodId
     */
    void removeGoods(String goodId);

    /**
     * 更新商品（修改当前商品编号对应商品的名称）
     * @param good
     */
    void updateGoods(Goods good);

    /**
     * 商品是否存在（通过商品编号）
     * @param goodId
     * @return
     */
    boolean isExistGoods(String goodId);

    /**
     * 获取商品（通过商品编号）
     * @param goodId
     * @return
     */
    Goods getGoods(String goodId);

    /**
     * 列出商品信息
     * @return
     */
    String listGoods();

    /**
     * 存储商品信息
     */
    void store();

    /**
     * 加载商品信息
     */
    void load();

}
