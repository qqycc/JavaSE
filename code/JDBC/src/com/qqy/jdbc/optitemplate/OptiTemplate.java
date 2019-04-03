package com.qqy.jdbc.optitemplate;

import java.sql.*;

/**
 * 优化：只有一个handle()
 * Author:qqy
 */
public class OptiTemplate {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public void load() {
        try {
            Class.forName("java.sql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void link() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memo", "root", "157321");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createdStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //将sql语句和handle()当做参数
    public final <T, R> R execute(String sql, Handle<T, R> handle) {
        this.load();
        this.link();
        this.createdStatement();
        try {
            if (sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")) {
                resultSet = this.statement.executeQuery(sql);
                return handle.handle((T) resultSet);
            } else {
                Integer result = this.statement.executeUpdate(sql);
                return handle.handle((T) result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return null;
    }
}

//去掉抽象方法，将handle抽象为一个接口
interface Handle<T, R> {
    R handle(T t);
}
