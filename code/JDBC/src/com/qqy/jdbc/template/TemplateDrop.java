package com.qqy.jdbc.template;

/**
 * 删除
 * Author:qqy
 */
public class TemplateDrop extends JdbcTemplate{

    @Override
    public String createSql() {
        return "delete from memo_group where id = 2 ";
    }

    public Integer handle(Integer result){
        return result;
    }

    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate=new TemplateDrop();
        System.out.println("删除结果："+jdbcTemplate.execute());
    }
}
