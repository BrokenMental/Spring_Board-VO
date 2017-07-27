<%--
  Created by IntelliJ IDEA.
  User: Jinuk
  Date: 2017-07-17
  Time: 오전 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../include/header.jsp"%>
<html>
<head>
    <link href="../../../resources/bootstrap/css/Board.css" rel="stylesheet" type="text/css" />
    <title>New Board</title>
</head>
<body style="text-align: center">
<h2>게시판 생성</h2>
<form method="post">
    <input type='hidden' name='id' value="${id}">
    <table width="600">
        <colgroup>
            <col width="10%">
            <col width="70%">
        </colgroup>
        <thead>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title" size="69"></td>
        </tr>
        <thead>
        </thead>
        <tbody>
        <tr>
            <th>내용</th>
            <td><textarea name="contents" cols="70" rows="15" style="resize: none"></textarea></td>
        </tr>
        </tbody>
        <tfoot>
        <tr style="text-align: right">
            <td colspan="2">
                <button type="submit" id="btnWrite">Write</button>
                <button id="btnCancel">Cancel</button>
            </td>
        </tr>
        </tfoot>
    </table>
</form>
<div style="margin-top: 700px">
    <%@include file="../include/footer.jsp" %>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
<script>
    $(document).ready(function () {
        $("#btnCancel").on('click', function () {
            history.back();
        });
    });
</script>