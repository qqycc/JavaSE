package com.qqy.jdbc.optitemplate;

/**
 * 更新
 * Author:qqy
 */
public class TestUpdate {
    public static void main(String[] args) {
        OptiTemplate optiTemplate = new OptiTemplate();
        String sql = "update memo_group set id=2 where id=5";
        //Lambda表达式
        Integer result= optiTemplate.execute(sql, (Handle<Integer, Integer>) result1 -> result1);
        //函数式编程，匿名内部类
//        Integer result1= optiTemplate.execute(sql, new Handle<Integer, Integer>() {
//            @Override
//            public Integer handle(Integer result) {
//                return result;
//            }
//        });
        System.out.println("更新结果"+result);
    }
}
