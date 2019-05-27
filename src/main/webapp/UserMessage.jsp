<%@ page import="Bean.Place" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouzhipeng
  Date: 2019-05-27
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="User" class="Bean.User" scope="session">
</jsp:useBean>
<jsp:setProperty name="User" property="*"/>
<%
    String path=request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>你好 <%=User.getEmail()%></title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row myCenter">
        <div class="col-xs-4">
            个人信息
        </div>
        <div class="col-xs-6">
            <center>
            <table cellspacing="1" cellpadding="0" width="40%" border="0">
                <tbody>
                <tr bgcolor="aqua" height="20">
                    <td><div align="center">编号</div></td>
                    <td><div align="center">地址</div></td>
                </tr>
                <%
                    ArrayList<Place> place = (ArrayList<Place>)request.getAttribute("personal_place");
                    Iterator<Place> it = place.iterator();
                    Place p;
                    while(it.hasNext()) {
                        p = it.next();

                    assert p != null;
                    %>

                <tr bgcolor="" height="25">
                    <td width="10%">
                        <div align="center"><%=p.getId()%></div>
                    </td>
                    <td width="15%">
                        <div align="center"><%=p.getPlace()%></div>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
            </center>
        </div>
    </div>
</div>
</body>
</html>
