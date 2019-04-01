package com.qqy.jdbc;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * 事务管理
 * 一组语句，同生共死
 * 既要插入成功，也要删除成功
 * Author:qqy
 */
public class JdbcTransaction {
    public static void main(String[] args) throws SQLException {
        //1.加载驱动程序
        try {
            Class.forName("java.sql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection=null;
        Statement statement=null;

        //2.获取连接-DriverManager
        String url = "jdbc:mysql://127.0.0.1:3306/memo";
        try {
            connection=DriverManager.getConnection(url,"root","157321");

            //事务控制——自动提交，默认true
            connection.setAutoCommit(false);
            //3. 创建命令
            statement=connection.createStatement();

            //4. 准备SQL语句，执行
            //插入
            String insertSQL = "insert into memo_group (id ,name,created_time) values (5,'Python组', '2019-03-28 10:15:00')";
            int insertEffect = statement.executeUpdate(insertSQL);
            System.out.println("插入数据：" + insertEffect);
            //更新
            String updateSQL = "update memo_group set name='Python3组'  where id = 5";
            int updateEffect = statement.executeUpdate(updateSQL);
            System.out.println("更新数据：" + updateEffect);

            //更新与插入都成功了，提交
            if (insertEffect == 1 && updateEffect == 1) {
                //提交
                connection.commit();
            } else {
                //失败，回滚
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                //SQL执行出现异常，回滚
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
