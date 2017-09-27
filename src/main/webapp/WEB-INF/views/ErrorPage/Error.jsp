<%--
  Created by IntelliJ IDEA.
  User: Jinuk
  Date: 2017-09-26
  Time: 오후 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Page Error</title>
</head>
<body>
<div id="wrapper">
    <div id="page-wrapper">
        <div align="center">
            <c:out value="${msg}"/>
        </div>
    </div>
</div>
</body>
</html>
