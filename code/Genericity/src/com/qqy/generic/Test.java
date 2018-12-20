package com.qqy.generic;

/**
 * 引入泛型
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        //将10装箱为Integer，再向上转型为Object
        Point intPoint=new Point(10,20);
        System.out.println(intPoint);
        //强制类型装换——向下转型 Object->int
        int intX = (int) intPoint.getX();
        int intY = (int) intPoint.getY();
        System.out.println("(" + intX + ", " + intY + ")");

        Point doublePoint = new Point(10.2D, 20.2D);
        double doubleX = (double) doublePoint.getX();
        double doubleY = (double) doublePoint.getY();
        System.out.println("(" + doubleX + ", " + doubleY + ")");

        Point stringPoint = new Point("东经80度", "北纬30度");
        String stringX = (String) stringPoint.getX();
        String stringY = (String) stringPoint.getY();
        System.out.println("(" + stringX + ", " + stringY + ")");
    }
}
