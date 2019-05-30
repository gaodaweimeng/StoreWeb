<%--
  Created by IntelliJ IDEA.
  User: zhouzhipeng
  Date: 2019-05-26
  Time: 18:36
  To change this template use File | Settings | File Templates.
  注册界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="static/css/login.css">
    <script>
        function LogIn() {
            alert("注册成功！")
        }

        function PasswordCheck() {
            const InputPassword = document.getElementById("InputPassword").value;
            const CheckPassword = document.getElementById("CheckPassword").value;

            document.getElementById("submit").disabled = InputPassword !== CheckPassword;
        }
    </script>
</head>


<body>
<div class="container">
    <div class="row myCenter">
        <div class="col-xs-6 col-md-4 col-center-block">
            <form class="form-signin" method="post" action="register">
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>

                <h2 class="form-signin-heading" align="center">注  册</h2>


                <label for="email" class="sr-only">邮箱</label>
                <input type="email" id="email" class="form-control" name="email" placeholder="name@domain.com" required autofocus>
                <br/>

                <label for="inputPassword" class="sr-only">密码</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
                <br/>

                <label for="inputPassword" class="sr-only">确认密码</label>
                <input type="password" id="checkPassword" onkeyup="PasswordCheck()" class="form-control" placeholder="确认密码" required>
                <br/>

                <label class="sr-only">电话号码</label>
                <input type="text" id="tel" class="form-control" name="tel" placeholder="电话号码" required>
                <br/>

                <button class="btn btn-lg btn-primary btn-block" onclick="LogIn()" value="ShowDialog" type="submit">注册</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
