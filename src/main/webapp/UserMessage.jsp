<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouzhipeng
  Date: 2019-05-27
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="User" class="Bean.User" scope="session">
</jsp:useBean>
<jsp:setProperty name="User" property="*"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>你好 <%=User.getEmail()%>
    </title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="static/css/place.css">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">运动达人</a>
        </div>
        <div>
            <form class="navbar-form navbar-left" method="post" action="add_place">
                <div class="form-group">
                    <input type="text" class="form-control" name="addPlace" placeholder="Place"/>
                </div>
                <button type="submit">添加地址</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr bgcolor="f3f3f3" height="20">
            <th>
                <div align="center">地址</div>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${personal_place}">
            <tr bgcolor="f3f3f3" height="25">
                <td width="30%">
                    <div align="center">${p.place}</div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
