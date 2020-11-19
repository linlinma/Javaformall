package com.company;

import com.company.domain.Emp;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.*;

/*
* 查询 emp表中数据
* */
public class JDBCDemo5 {
    public static void main(String[] args) throws Exception{
        //1、导入驱动jar包, 建立libs文件夹， 右键 add as library
        //2、 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:mysql:" +
                "//localhost:3306/malinlin","root","root");
        //4、定义sql
        String sql= "select * from emp ";
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
       // System.out.println("empno"+"----"+"ename"+"----"+"job"+"----"+
       //         "mgr"+"----"+"hiredate"+"----"+"sal"+"----"+"comm"+"----"+"deptno");
       /* while(rs.next()){
            int empno =rs.getInt("EMPNO");
            String ename =rs.getString("ENAME");
            String job =rs.getString("JOB");
            int mgr=rs.getInt("MGR");
            int hiredate=rs.getInt("HIREDATE");
            int sal=rs.getInt("SAL");
             String comm=rs.getString("COMM");
            int deptno=rs.getInt("DEPTNO");
            System.out.println(empno+"----"+ename+"----"+job+"----"+mgr+"----"+hiredate
                    +"----"+sal+"----"+comm+"----"+deptno);
        }*/
       rs.next();
        int empno =rs.getInt("EMPNO");
        String ename =rs.getString("ENAME");
        String job =rs.getString("JOB");
        int mgr=rs.getInt("MGR");
        Date hiredate=rs.getDate("HIREDATE");
        int sal=rs.getInt("SAL");
        int comm=rs.getInt("COMM");
        int deptno=rs.getInt("DEPTNO");

        Emp emp=new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
        System.out.println(emp);

        //8、释放资源
        stat.close();
        conn.close();
    }
}
