<%--
  Created by IntelliJ IDEA.
  User: Jinuk
  Date: 2017-07-18
  Time: 오전 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>
<html>
<head>
    <link href="/resources/bootstrap/css/Board.css" rel="stylesheet" type="text/css"/>
    <title>Modify Board</title>
</head>
<body style="text-align: center">
<h2>게시물 수정</h2>
<form method="post">
    <input type='hidden' name='page' value="${cri.page}">
    <input type='hidden' name='perPageNum' value="${cri.perPageNum}">
    <input type='hidden' name='searchType' value="${cri.searchType}">
    <input type='hidden' name='keyword' value="${cri.keyword}">
    <table>
        <colgroup>
            <col width="10%">
            <col width="50%">
            <col width="10%">
            <col width="20%">
        </colgroup>
        <thead>
        <tr>
            <th>번호</th>
            <td colspan="3" style="text-align: right;"><input type="text" name="bno" readonly="readonly"
                                                              style="border: 0px; text-align: right;"
                                                              value="${settingVO.bno}">
            </td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title" value="${settingVO.title}"></td>
            <th>작성자</th>
            <td><input type="text" name="id" readonly="readonly" value="${id}"
                       style="text-align: right; border: 0px; position: relative; left: 6px;"/></td>
        </tr>
        <tr>
            <th>내용</th>
            <td colspan="3"><textarea name="contents" cols="70" rows="15"
                                      style="resize: none;">${settingVO.contents}</textarea></td>
        </tr>
        </tbody>
        <tfoot>
        <tr style="text-align: right; border: 0px;">
            <td colspan="4">
                <button type="submit" id="btnModify">Update</button>
                <button id="btnCancel">Cancel</button>
                <button id="btnList">List</button>
            </td>
        </tr>
        </tfoot>
    </table>
</form>
<div style="margin-top: 700px">
    <%@include file="../include/footer.jsp" %>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $("#btnCancel").on('click', function () {
            history.back();
        });
        $("#btnList").on("click", function () {
            self.location = "ListBoard";
        });
    });
</script>
</body>
</html>