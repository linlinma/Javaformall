package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
* 删除操作
* */
public class JDBCDemo3 {
    public static void main(String[] args) throws Exception{
        //1、导入驱动jar包, 建立libs文件夹， 右键 add as library
        //2、 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/malinlin","root","root");
        //4、定义sql
        String sql= "delete from account where id=4";
        //5、获取数据库连接对象statement
        Statement stat=conn.createStatement();
        //6、执行sql
        int i =stat.executeUpdate(sql);
        //7、处理结果 返回影响结果行数
        if (i==1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        //8、释放资源
        stat.close();
        conn.close();
    }
}
