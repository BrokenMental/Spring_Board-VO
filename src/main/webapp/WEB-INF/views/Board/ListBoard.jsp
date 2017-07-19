<%--
  Created by IntelliJ IDEA.
  User: Jinuk
  Date: 2017-07-17
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
    <title>List Board</title>
</head>
<body style="text-align: center">
<h2>게시판 조회</h2>
<table style="margin: auto">
    <colgroup>
        <col width="10%"/>
        <col width="*"/>
        <col width="25%"/>
        <col width="10%"/>
    </colgroup>
    <thead>
    <tr>
        <th scope="col">글번호</th>
        <th scope="col">제목</th>
        <th scope="col">작성일</th>
        <th scope="col">조회수</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.bno}</td>
            <td><a href="ReadBoard?bno=${list.bno}">${list.title}</a></td>
            <td>${list.today}</td>
            <td>${list.hit}</td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="4" style="text-align: right">
            <button id="btnNew">New</button>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>
<script>
    $(document).ready(
        function () {
            $("#btnNew").on("click", function () {
                self.location = "NewBoard";
            });
        });
</script>
