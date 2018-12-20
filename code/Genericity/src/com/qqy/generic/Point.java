package com.qqy.generic;

/**
 * Author: qqy
 */
public class Point {

    private Object x;

    private Object y;

    public Point(Object x, Object y) {
        this.x = x;
        this.y = y;
    }

    public Object getX() {
        return x;
    }

    public Object getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
