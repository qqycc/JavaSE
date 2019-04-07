package com.qqy.jdbc.preTemplate;

import com.qqy.jdbc.optitemplate.MemoGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询
 * Author:qqy
 */
public class TestSelect1 {
    public static PrecompileTemplate precompileTemplate = new PrecompileTemplate();
    //通过name查找
    public static void selectByName(String name){
        //? 表示占位符
        String sql = "select id,name,created_time,modify_time from memo_group where name in(?)";
        List<MemoGroup> datas = precompileTemplate.execute(sql,new String[]{name},new ResultSetHandler());

        if (datas != null) {
            //打印每一条数据
            for (MemoGroup memoGroup : datas) {
                System.out.println(memoGroup);
            }
        }
    }

    public static void main(String[] args) {
        selectByName("'PHP组','C++组'");
    }
}

class ResultSetHandler implements Handler<ResultSet, List<MemoGroup>>{
    @Override
    public List<MemoGroup> handle(ResultSet resultSet) {
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
        return memoGroupList;
    }
}

