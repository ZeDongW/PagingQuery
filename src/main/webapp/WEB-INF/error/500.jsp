<%--
  Created by IntelliJ IDEA.
  User: ZeDongW
  Date: 2019/6/20 0020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>系统错误</title>
</head>
<body>
    <center>亲，服务器崩溃了，正在紧急修复中，错误原因：${pageContext.exception.message}</center>
</body>
</html>
