package com.qqy.jdbc.optitemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询
 * Author:qqy
 */
public class TestSelect {
    public static OptiTemplate optiTemplate = new OptiTemplate();

    //查找全部
    public static void selectAll() {
        String sql = "select id,name,created_time,modify_time from memo_group";
        List<MemoGroup> datas = optiTemplate.execute(sql, new ResultSetHandle());

        if (datas != null) {
            //打印每一条数据
            for (MemoGroup memoGroup : datas) {
                System.out.println(memoGroup);
            }
        }
    }

    //通过name查找
    public static void selectByName(String name){
        //注意：name要用''引起来，若不加''则认为是列名
        String sql = "select id,name,created_time,modify_time from memo_group where name='"+name+"'";
        List<MemoGroup> datas = optiTemplate.execute(sql, new ResultSetHandle());

        if (datas != null) {
            //打印每一条数据
            for (MemoGroup memoGroup : datas) {
                System.out.println(memoGroup);
            }
        }
    }

    public static void main(String[] args) {
        selectAll();
        selectByName("Go组");
//        //SQL注入攻击，本来只打印Java新组的这一条，结果全部打印
//        selectByName("PHP组 'or 1=1 or 1='");
    }
}

class ResultSetHandle implements Handle<ResultSet, List<MemoGroup>>{
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

