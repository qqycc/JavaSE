package com.qqy.jdbc.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询
 * Author:qqy
 */
public class TemplateSelect extends JdbcTemplate {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new TemplateSelect();
        //利用列表存放获得的数据
        List<MemoGroup> datas = jdbcTemplate.execute();
        //防止空指针异常
        if (datas != null) {
            //打印每一条数据
            for (MemoGroup memoGroup : datas) {
                System.out.println(memoGroup);
            }
        }
    }

    @Override
    public String createSql() {
        return "select id,name,created_time,modify_time from memo_group";
    }

    //不直接打印返回的数据，而是按将数据存储到List，返回List
    public <T> T handle(ResultSet resultSet) {
        //ORM  对象关系映射 将对象和关系联系起来
        //Java面向对象编程  => Object
        //关系型数据库      => Relationship
        //阻抗不匹配
        List<MemoGroup> memoGroupList = new ArrayList<>();

        try {
            //根据每行的列名取得对应的数据
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createdtime = resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modifytime = resultSet.getTimestamp("modify_time").toLocalDateTime();

                //把每一行数据转换为memoGroup对象
                MemoGroup memoGroup = new MemoGroup();
                memoGroup.setId(id);
                memoGroup.setName(name);
                memoGroup.setCreatedTime(createdtime);
                memoGroup.setModifyTime(modifytime);

                //再把对象放入集合中去
                memoGroupList.add(memoGroup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (T) memoGroupList;
    }
}
