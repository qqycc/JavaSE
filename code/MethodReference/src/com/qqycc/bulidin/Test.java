package com.qqycc.bulidin;

import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * 功能型函数接口
 * Author: qqy
 */
public class Test {
    public static void main(String[] args) {
        Function<Object, String> function = (value) -> {
            return value.toString();
        };
        String str = function.apply("Bonjour");
        System.out.println(str);

        //参数确定，返回值不确定
        IntFunction intFunction=String::valueOf;
        System.out.println(intFunction.apply(100));
    }
}
