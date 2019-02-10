package com.qqy.tfdp;

/**
 * 简单工厂模式（反射）
 * Author: qqy
 */
public class NewIFruitFactory {

    private NewIFruitFactory() {

    }

    //较传统工厂模式，将参数变为类名
    public static IFruit getIFruit(String className) {
        try {
            //取得任一子类反射对象
            Class c = Class.forName(className);
            //通过反射实例化对象
            //c.newInstance()是Object类
            return (IFruit) c.newInstance();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(className + " not found.");
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("Instance " + className + " failed");
        }
    }
}
