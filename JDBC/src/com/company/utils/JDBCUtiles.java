package com.company.utils;
/*
*JDBC 连接数据库工具类
static 静态方法，只能通过类.调用
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtiles {
    //定义成员变量
    private  static DataSource ds;
    //初始化成员变量
    //使用静态代码块初始化静态成员变量
    static {
        try {
            //加载properties文件
            Properties pro= new Properties();
            InputStream in = JDBCUtiles.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(in);
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    * 获取数据库连接，返回链接对象
    * */
    public static Connection getConnection() throws Exception{
        return ds.getConnection();
    }
    public  static  void close( Statement stmt,Connection conn){
        close(null,stmt,conn);
    }
/*
* 关闭链接
* */
    public static void close(ResultSet rs, Statement stmt,Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt !=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
