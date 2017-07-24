<%--
  Created by IntelliJ IDEA.
  User: Jinuk
  Date: 2017-07-18
  Time: 오전 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@include file="../include/header.jsp"%>
<html>
<head>
    <title>Read Board</title>
</head>
<body style="text-align: center">
<h2>게시물 상세보기</h2>
<form id="Form" action="ModifyBoard" method="get">
    <%-- title,contents를 넣을때 중복된 값이 포함되는 이유는 form의 input-name과 아래 table의 input-name이 동일했기 때문이다. --%>
    <input type="hidden" name="bno" value="${settingVO.bno}">
    <input type="hidden" name="root" value="${settingVO.root}">
    <input type="hidden" name="pno" value="${settingVO.pno}">
    <input type="hidden" name="cno" value="${settingVO.cno}">
    <input type="hidden" name="depth" value="${settingVO.depth}">
    <input type="hidden" name="lvl" value="${settingVO.lvl}">
</form>
<div>
    <table width="600" style="margin: auto; border: 1px;">
        <colgroup>
            <col width="10%">
            <col width="70%">
        </colgroup>
        <thead>
        <tr>
            <th>번호</th>
            <td style="text-align: right;">${settingVO.bno}</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td style="text-align: right;">${settingVO.hit}</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>제목</th>
            <td><input type="text" size="69" readonly="readonly" style="border:0px;" value="${settingVO.title}"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea cols="70" rows="15" readonly="readonly"
                          style="resize: none; border:0px;">${settingVO.contents}</textarea></td>
        </tr>
        </tbody>
        <tfoot>
        <tr style="text-align:right">
            <td></td>
            <td>
                <button type="button" id="btnRe" style="float: left">ReBoard</button>
                <button type="button" id="btnModify">Modify</button>
                <button type="submit" id="btnRemove">Remove</button>
                <button id="btnCancel">List</button>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<div style="margin-top: 700px">
    <%@include file="../include/footer.jsp" %>
</div>
</body>
</html>
<script>
    $(document).ready(function () {
        var form = $("#Form");

        $("#btnRe").on("click", function () {
            form.attr("action","ReBoard");
            form.submit();
        })
        $("#btnCancel").on("click", function() {
            self.location = "/";
            /*history.back();*/
        });
        $("#btnRemove").on("click", function() {
            form.attr("action", "RemoveBoard");
            form.attr("method", "post"); // delete는 post로 보내줘야 한다.
            form.submit();
        });
        $("#btnModify").on("click", function() {
            form.submit();
        });
    });
</script>