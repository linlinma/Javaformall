package com.company;

import com.company.utils.JDBCUtiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
* 模拟用户登录程序
* */
public class JDBCDemo7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("欢迎来到王者峡谷");
        System.out.println("请输入用户名");
        String name=sc.next();
        System.out.println("请输入密码");
        String password=sc.next();
        boolean flag=login(name,password);
        if (flag){
            System.out.println("欢迎回来");
        }else {
            System.out.println("用户名或密码错误，请重新登录");
        }

    }
    //登陆方法
    public static  boolean login(String name,String password){
        //参数校验
        if (name==null||password==null){
            return false;
        }
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
             conn= JDBCUtiles.getConnection();
            String sql="select * from user where name='"+name+"'and password='"+password+"'";
            System.out.println(sql);
            stmt =conn.createStatement();
            rs=stmt.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  false;
    }
}
