<%--
  Created by IntelliJ IDEA.
  User: Wangchenfei
  Date: 2023/10/17
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板信息</title>
</head>
<body>
<%out.print(request.getParameter("username"));%>，您好！欢迎登录留言板。
</body>
</html>
