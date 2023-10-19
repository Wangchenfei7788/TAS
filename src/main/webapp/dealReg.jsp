<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.wcf.tas.MD5" %>
<%--
  Created by IntelliJ IDEA.
  User: Wangchenfei
  Date: 2023/10/17
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="SqlSrvDB" scope="page" class="com.wcf.tas.jdbc.MySqlDBConn" />
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>
<body>
<%
  request.setCharacterEncoding("utf-8");			//设置请求编码
  String usr=request.getParameter("username");			//获取提交的用户名
  String pwd=request.getParameter("userpwd");//获取提交的密码
  String tp=request.getParameter("usertype");
  //查询userTable表中的记录
  String sql="insert user(username,userpwd,usertype) values('"+usr+"','"+MD5.MD5Encode(pwd)+"','"+tp+"')";
  int num=SqlSrvDB.executeInsert(sql);	//取得结果集


  SqlSrvDB.closeStmt();					//关闭语句
  SqlSrvDB.closeConn();					//关闭连接
  if(num>0)
  {

%>
注册成功，点击这里进入<a href="login.html">登录</a>页面
<%
}
else
{

%>
注册失败，点击这里重新<a href="reg.html">注册</a>
<%
  }
%>
</body>
</html>