<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: w'c'f
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
  String pwd=request.getParameter("userpwd");		//获取提交的密码
  boolean validated=false;						//验证成功标识
  //查询userTable表中的记录
  String sql="select * from user";
  ResultSet rs=SqlSrvDB.executeQuery(sql);	//取得结果集
  while(rs.next())
  {
    if((rs.getString("username").trim().compareTo(usr)==0)
            &&(rs.getString("userpwd").compareTo(pwd)==0))
    {
      validated=true;						//标识为true表示验证成功通过
    }
  }
  rs.close();
  SqlSrvDB.closeStmt();					//关闭语句
  SqlSrvDB.closeConn();					//关闭连接
  if(validated)
  {
    //验证成功跳转到main.jsp
%>
<jsp:forward page="main.jsp"/>
<%
}
else
{
  //验证失败跳转到error.jsp
%>
<jsp:forward page="error.jsp"/>
<%
  }
%>
</body>
</html>