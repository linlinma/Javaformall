package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
* 查询操作
* */
public class JDBCDemo4 {
    public static void main(String[] args) throws Exception{
        //1、导入驱动jar包, 建立libs文件夹， 右键 add as library
        //2、 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/malinlin","root","root");
        //4、定义sql
        String sql= "select * from account ";
        //5、获取数据库连接对象statement
        Statement stat=conn.createStatement();
        //6、执行sql
        ResultSet rs= stat.executeQuery(sql);

        //7、处理结果  columnlndex 列的索引
        //rs.next();; 查询有无值
       /* while(rs.next()){
        int id=rs.getInt(1);
        String name=rs.getString(2);
        double balance=rs.getDouble(3);
        System.out.println(id+"----"+name+"----"+balance);
        }*/
        //columnLable 字符串
        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            double balance=rs.getDouble("balance");
            System.out.println(id+"----"+name+"----"+balance);
        }

        //8、释放资源
        stat.close();
        conn.close();
    }
}
