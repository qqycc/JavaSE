package com.qqy.jdbc.preTemplate;

import java.sql.*;

/**
 * 预编译命令
 * Author:qqy
 */
public class PrecompileTemplate {
    Connection connection = null;
    PreparedStatement statement = null;
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

    //创建预编译命令
    public void createdStatement(String sql) {
        try {
            statement = connection.prepareStatement(sql);
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
    public final <T, R> R execute(String sql,String[] args, Handler<T, R> handle) {
        this.load();
        this.link();
        this.createdStatement(sql);
        for (int i = 0; i < args.length; i++) {
            try {
                // 参数赋值
                // 所有参数类型都是String
                // 参数下标，参数值
                // 预编译命令的占位符从1 ... n
                this.statement.setString(i+1,args[i]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            if (sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")) {
                //预编译命令此处执行时，SQL语句不需要传入
                //创建预编译命令时，已经把编译后的sql语句传进去了
                //下次使用时直接执行，不需要再次解析命令，效率比较高
                resultSet = this.statement.executeQuery();
                return handle.handle((T) resultSet);
            } else {
                Integer result = this.statement.executeUpdate();
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

interface Handler<T, R> {
    R handle(T t);
}
