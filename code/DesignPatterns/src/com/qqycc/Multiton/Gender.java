package com.qqycc.Multiton;

/**
 * 多例实现性别的描述
 * Author: qqy
 */
public class Gender {
    private final String value;

    private static final Gender MALE = new Gender("男");
    private static final Gender FAMALE = new Gender("女");

    private Gender(String value) {
        this.value = value;
    }

    //type = 0  女   type = 1  男
    public static Gender getInstance(int type) {
        switch (type) {
            case 0:
                return FAMALE;
            case 1:
                return MALE;
            default:
                return null;
        }
    }

    public String getValue() {
        return value;
    }
}
