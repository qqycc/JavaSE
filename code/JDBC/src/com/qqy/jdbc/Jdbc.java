package com.qqy.jdbc;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * 简单的JDBC编程 —— 查询
 * Author:qqy
 */
public class Jdbc {
    public static void main(String[] args) throws SQLException {
        //1.加载驱动程序
        try {
            //获取到驱动，和具体实现类耦合了
            //java.sql.Driver driver=new com.mysql.jdbc.Driver();
            //传入的是一个字符串，与具体的实现类完全解耦（没有关系）
            Class.forName("java.sql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //将下列三者置于try块外，便于最后通过finally块进行关闭操作
        //连接
        Connection connection=null;
        //命令
        Statement statement=null;
        //结果集
        ResultSet resultSet=null;

        //2.获取连接-DriverManager
        //数据库产品名称——mysql小写
        String url = "jdbc:mysql://127.0.0.1:3306/memo";
        try {
            connection=DriverManager.getConnection(url,"root","157321");

            //3. 创建命令
            statement=connection.createStatement();

            //4. 准备SQL语句，执行
            String sql="select id,name,created_time,modify_time from memo_group";
            resultSet =statement.executeQuery(sql);

            //5.返回结果，处理结果
            //按行读取
            while(resultSet.next()){
                //根据每行的列名取得对应的数据
                int id=resultSet.getInt("id");
                String name =resultSet.getString("name");
                LocalDateTime createdtime=resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modifytime=resultSet.getTimestamp("modify_time").toLocalDateTime();
                System.out.println(String.format("id=%d\tname=%s\t\tcreated_time=%s\t\tmodify_time=%s",id,name,createdtime,modifytime));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //6.关闭资源
            //将关闭放在finally块中，是为了防止程序抛出异常后不会向下继续执行，而导致关闭操作没有执行

            //先创建的后关闭
            //结果集 -> 命令 -> 连接

            //避免空指针异常，关闭前进行检验
            //关闭结果集
            if(resultSet!=null){
                resultSet.close();
            }
            //关闭命令
            if(statement!=null){
                statement.close();
            }
            //关闭连接
            if(connection!=null){
                connection.close();
            }
        }
    }
}
