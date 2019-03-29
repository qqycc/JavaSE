package com.qqy.jdbc;

import java.sql.*;

/**
 * 简单的JDBC编程 —— 更新
 * Author:qqy
 */
public class Jdbc1 {
    public static void main(String[] args) {
        try {
            Class.forName("java.sql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memo", "root", "157321");
            statement = connection.createStatement();
            String sql = "insert into memo_group (id ,name,created_time) values (5,'Go组', '2019-03-7 21:54:00')";
            int result = statement.executeUpdate(sql);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
