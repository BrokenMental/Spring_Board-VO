<%--
  Created by IntelliJ IDEA.
  User: Jinuk
  Date: 2017-09-26
  Time: 오후 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <title>Login</title>
</head>
<body>
<h1 id="loginheader">Spring Board</h1>
<h5 id="loginsubheader">Make By Jinuk HA</h5>
<form name="Login" action="LoginPost" method="post">
    <div class="loginframe">
        <div class="form-group has-feedback">
            <input type="text" name="id" class="form-control" placeholder="USER ID">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="password" name="pw" class="form-control" placeholder="Password">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="row">
            <div class="col-xs-8">
                <div class="checkbox icheck">
                    <label>
                        <input type="checkbox" name="useCookie">Remember Me
                    </label>
                </div>
            </div>
            <div class="col-xs-4">
                <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
            </div>
        </div>
    </div>
</form>
<script>
    //입력이 아에 안되었을때 스크립트 작성하기
</script>
</body>
</html>
