<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouzhipeng
  Date: 2019-05-27
  Time: 08:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="User" class="Bean.User" scope="session">
</jsp:useBean>
<jsp:setProperty name="User" property="*"/>
<%
    String path=request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>运动达人</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="static/css/index_login.css">
</head>

<body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand">运动达人</a>
            </div>
            <div>
                <form class="navbar-form navbar-left" method="post" action="search">
                    <div class="form-group">
                        <input type="text" class="form-control" name="search_product" placeholder="Search"/>
                    </div>
                    <button type="submit">搜索</button>
                </form>
            </div>
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown">排序</a>
                    <ul class="dropdown-menu">
                        <li><a href="price_sort">价格</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="findPlace"><span class="glyphicon glyphicon-user"></span><%=User.getEmail()%></a></li>
                <li><a href="product_handler"><span class="glyphicon glyphicon-shopping-cart"></span>购物车</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr bgcolor="f3f3f3" height="20">
                <th>
                    <div align="center">商品号</div>
                </th>
                <th>
                    <div align="center">商品名字</div>
                </th>
                <th>
                    <div align="center">商品价格</div>
                </th>
                <th>
                    <div align="center">商品大小</div>
                </th>
                <th>
                    <div align="center">商品颜色</div>
                </th>
                <th>
                    <div align="center">商品照片</div>
                </th>
                <th>
                    <div align="center">添加商品</div>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${Product}">
                <tr bgcolor="f3f3f3" height="25">
                    <td width="10%">
                        <div align="center">${p.id}</div>
                    </td>
                    <td width="13%">
                        <div align="center">${p.name}</div>
                    </td>
                    <td width="10%">
                        <div align="center">${p.price}</div>
                    </td>
                    <td width="10%">
                        <div align="center">${p.size}</div>
                    </td>
                    <td width="10%">
                        <div align="center">${p.color}</div>
                    </td>
                    <td width="10%">
                        <div align="center">${p.photo}</div>
                    </td>
                    <td width="10%">
                        <div align="center">
                            <a href="buy_product?pid=${p.id}">加入购物车</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
