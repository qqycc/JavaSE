package com.qqy.jdbc.template;

import java.sql.*;

/**
 * 简单的模板设计模式实现JDBC
 * Author:qqy
 */
public abstract class JdbcTemplate {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    //加载驱动
    public void load() {
        try {
            Class.forName("java.sql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //连接
    public void link() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memo", "root", "157321");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //创建命令
    public void createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //子类提供sql语句
    public abstract String createSql();

    //获得结果并处理
    /*
     * 如果使用抽象方法实现，会有两个Handle方法需要覆写：
     * public abstract ResultSet Handle();
     * public abstract int Handle1();
     * 因此，采用非抽象空实现的方法
     * 通过方法重载，让子类选择性的去覆写（查询 or 更新)
     */
    public <T> T handle(ResultSet resultSet) {
        return null;
    }

    public <T> T handle(Integer result) {
        return null;
    }

    //关闭资源
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
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //流程
    public final <T> T execute() {
        this.load();
        this.link();
        this.createStatement();
        String sql = this.createSql();
        try {
            //查询
            if (sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")) {
                resultSet = statement.executeQuery(sql);
                return this.handle(resultSet);
                //更新
            } else {
                Integer result = statement.executeUpdate(sql);
                return this.handle(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return null;
    }
}



