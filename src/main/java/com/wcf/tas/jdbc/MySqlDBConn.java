package com.wcf.tas.jdbc;

import java.sql.*;
public class MySqlDBConn {
    private Statement stmt;// Statement对象（语句）
    private Connection conn;		// Connection对象（连接）
    ResultSet rs;				// ResultSet对象（结果集）
    //在构造方法中创建数据库连接
    public MySqlDBConn(){
        stmt=null;
        try{
            /**加载并注册 SQLServer的JDBC驱动*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            /**编写连接字符串，获取创建连接*/
            conn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tas?useSSL=false&serverTimezone=UTC","root","123456");
        }catch(Exception e){
            e.printStackTrace();
        }
        rs=null;
    }
    //执行查询类的SQL语句，有返回集
    public ResultSet executeQuery(String sql)
    {

        try
        {
            stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
                    ,ResultSet.CONCUR_UPDATABLE);
            rs=stmt.executeQuery(sql);	//执行查询语句
        }catch(SQLException e){
            System.err.println("Data.executeQuery: " + e.getMessage());
        }
        return rs;					//返回结果集
    }

    //执行插入操作
public int executeInsert(String sql)
    {
        int num=0;
        try
        {
            //创建一个可滚动的，可更新的结果集
            stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
                    ,ResultSet.CONCUR_UPDATABLE);
            //执行插入操作
            num=stmt.executeUpdate(sql);
        }catch(SQLException e){
            System.err.println("Data.executeQuery: " + e.getMessage());
        }
        return num;
    }

    //关闭对象
    public void closeStmt()
    {
        try
        {
            stmt.close();				//关闭Statement对象
        }catch(SQLException e){
            System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
    public void closeConn()
    {
        try
        {
            conn.close();				//关闭连接
        }catch(SQLException e){
            System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
}