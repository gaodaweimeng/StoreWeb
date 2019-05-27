<%@ page import="Bean.User" %><%--
  Created by IntelliJ IDEA.
  User: zhouzhipeng
  Date: 2019-05-27
  Time: 08:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运动达人</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<jsp:useBean id="User" class="Bean.User" scope="session">
</jsp:useBean>
<jsp:setProperty name="User" property="*"/>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <nav class="navbar navbar-transparent navbar-fixed-top" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand">运动达人</a>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="findPlace"><span class="glyphicon glyphicon-user"></span><%=User.getEmail()%></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>购物车</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
