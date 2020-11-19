package com.company;

import com.company.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.company.utils.JDBCUtiles;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;


/*
* 查询emp中所有数据
* */
public class JDBCDemo6 {
    public static void main(String[] args) throws Exception{
       // List<Emp> empList= findAll();
        List<Emp> empList= findAll2();
        for (Emp e:empList){
            System.out.println(e);
        }

    }
    //List<emp> <>泛型，对存储数据的类型做限制，只能存emp类型
    public static List<Emp> findAll() throws Exception{
       List<Emp> list =new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql:" +
                "//localhost:3306/malinlin","root","root");
        String sql= "select * from emp ";
        Statement stat=conn.createStatement();
        ResultSet rs= stat.executeQuery(sql);
       while(rs.next()){
        int empno =rs.getInt("EMPNO");
        String ename =rs.getString("ENAME");
        String job =rs.getString("JOB");
        int mgr=rs.getInt("MGR");
        Date hiredate=rs.getDate("HIREDATE");
        int sal=rs.getInt("SAL");
        int comm=rs.getInt("COMM");
        int deptno=rs.getInt("DEPTNO");

        Emp emp=new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
           list.add(emp);
       }
        //8、释放资源
        stat.close();
        conn.close();

        System.out.println(list);
        return list;
    }
    public static List<Emp> findAll2() throws Exception{
        List<Emp> list =new ArrayList<>();
        Connection conn= JDBCUtiles.getConnection();
        String sql= "select * from emp ";
        Statement stat=conn.createStatement();
        ResultSet rs= stat.executeQuery(sql);
        while(rs.next()){
            int empno =rs.getInt("EMPNO");
            String ename =rs.getString("ENAME");
            String job =rs.getString("JOB");
            int mgr=rs.getInt("MGR");
            Date hiredate=rs.getDate("HIREDATE");
            int sal=rs.getInt("SAL");
            int comm=rs.getInt("COMM");
            int deptno=rs.getInt("DEPTNO");

            Emp emp=new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
            list.add(emp);
        }
        JDBCUtiles.close(rs,stat,conn);
        return list;
    }
}
