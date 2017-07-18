<%--
  Created by IntelliJ IDEA.
  User: Jinuk
  Date: 2017-07-18
  Time: 오전 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
    <title>Read Board</title>
</head>
<body>
<form id="Form" action="ModifyBoard" method="get">
    <input type="hidden" name="idx" value="${settingVO.idx}">
</form>
<div>
    <table width="600" style="margin: auto">
        <colgroup>
            <col width="10%">
            <col width="70%">
        </colgroup>
        <thead>
        <tr>
            <th>번호</th>
            <td>${settingVO.idx}</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>제목</th>
            <td><input type="text" name="Title" size="69" readonly="readonly" value="${settingVO.title}"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="Contents" cols="70" rows="15" readonly="readonly"
                          style="resize: none">${settingVO.contents}</textarea></td>
        </tr>
        </tbody>
        <tfoot>
        <tr style="text-align: right">
            <td colspan="2">
                <button type="submit" id="btnModify">Modify</button>
                <button id="btnCancel">List</button>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>
<script>
    $(document).ready(function () {
        var form = $("#Form");

        $("#btnCancel").on("click", function() {
            history.back();
        });
        $("#btnModify").on("click", function() {
            form.submit();
        });
    });
</script>