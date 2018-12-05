package com.qqycc.enums;

/**
 * Author: qqy
 */
public enum Color {
    BLUE("#0000ff"), RED("#ff0000"), GREEN("#00ff00");

    private String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void print() {
        System.out.println("颜色编码" + this.getCode());
    }

    public static void main(String[] args) {
        Color[] colors = Color.values();
        for (Color c : colors) {
            System.out.println(c.name() + ":" + c.getCode());
        }

        Color red = Color.valueOf("Red");
        System.out.println(red);

        //字符、数组、字符串、枚举(每一个枚举对象都有一个下标ordinal，下标是int类型)
        Color c = Color.GREEN;
        switch (c) {
            case RED:
                System.out.println(RED);
                break;
            case BLUE:
                System.out.println(BLUE);
                break;
            case GREEN:
                System.out.println(GREEN);
                break;
            default:
                System.out.println("不存在");
        }
    }
}
