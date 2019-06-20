<%--
  Created by IntelliJ IDEA.
  User: ZeDongW
  Date: 2019/6/20 0020
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页查询数据</title>
</head>
<body>
    <center><h3>分页查询数据</h3></center>
    <table align="center" border="1px" width="88%" cellpadding="5" cellspacing="0">
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        <c:choose>
            <c:when test="${not empty requestScope.pb.pageData}">
                <c:forEach var="stu" items="${requestScope.pb.pageData}">
                    <tr>
                        <td>${stu.id}</td>
                        <td>${stu.name}</td>
                        <td>${stu.age}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="3">对不起，没有你要找的数据</td>
                </tr>
            </c:otherwise>
        </c:choose>
        <tr>
            <td colspan="3" align="center">
                每页显示行数<input type="text" style="width: 20px" value="${requestScope.pb.pageCount}" onkeyup="this.value=this.value.replace(/\D/g,'')" onblur='checkPageCount()' id='pageCount'/>&nbsp;&nbsp;
                当前${requestScope.pb.currPage }/${requestScope.pb.totalPage }页&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/index?currPage=1">首页</a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/index?currPage=${requestScope.pb.currPage-1}&pageCount=${requestScope.pb.pageCount}">上一页 </a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/index?currPage=${requestScope.pb.currPage+1}&pageCount=${requestScope.pb.pageCount}">下一页 </a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/index?currPage=${requestScope.pb.totalPage}&pageCount=${requestScope.pb.pageCount}">末页</a>
            </td>
        </tr>
    </table>
</body>
<script type="text/javascript">
    function checkPageCount() {
        var pageCount = document.getElementById("pageCount").value;
        window.location.href="${pageContext.request.contextPath}/index?pageCount="+ pageCount;
    }
</script>
</html>
