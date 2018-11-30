package com.qqycc.Multiton;

/**
 * 枚举类：
 *
 * Author: qqy
 */
public enum Gender1 {
    //在构造方法之前，指定实例化对象
    FEMALE("女"),MALE("男");  //两个实例化对象

    private String type;

    //自带私有的构造方法
    Gender1(String type){
        this.type=type;
    };

    public String getType() {
        return type;
    }
}
