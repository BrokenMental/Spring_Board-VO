<%--
  Created by IntelliJ IDEA.
  User: Jinuk
  Date: 2017-07-17
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../include/header.jsp" %>
<html>
<head>
    <link href="../../../resources/bootstrap/css/Board.css" rel="stylesheet" type="text/css" />
    <title>List Board</title>
</head>
<body style="text-align: center">
<h2>게시판 리스트</h2>
<table>
    <colgroup>
        <col width="10%"/>
        <col width="35%"/>
        <col width="10%"/>
        <col width="30%"/>
        <col width="15%"/>
    </colgroup>
    <thead>
    <tr>
        <th scope="col">번호</th>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">작성일</th>
        <th scope="col">조회수</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.bno}</td>
            <td style="float: left; border: 0px;"><a href="ReadBoard?bno=${list.bno}">${list.title}</a></td>
            <td>${list.id}</td>
            <td>${list.today}</td>
            <td>${list.hit}</td>
        </tr>
    </c:forEach>
    <c:if test="${fn:length(list) == 0}">
        <tr>
            <td colspan="5">
                데이터가 없습니다.
            </td>
        </tr>
    </c:if>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="5" style="text-align: right">
            <button id="btnNew">New</button>
        </td>
    </tr>
    </tfoot>
</table>
<div style="margin-top: 700px">
    <%@include file="../include/footer.jsp" %>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
