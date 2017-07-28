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
<%@include file="../include/header.jsp" %>
<html>
<head>
    <link href="../../../resources/bootstrap/css/Board.css" rel="stylesheet" type="text/css"/>
    <title>Read Board</title>
</head>
<body style="text-align: center">
<h2>게시물 상세보기</h2>
<%-- title,contents를 넣을때 중복된 값이 포함되는 이유는 form의 input-name과 아래 table의 input-name이 동일했기 때문이다. --%>
<form id="Form" action="ModifyBoard" method="get">
    <input type='hidden' name='page' value="${cri.page}">
    <input type='hidden' name='perPageNum' value="${cri.perPageNum}">
    <input type='hidden' name='searchType' value="${cri.searchType}">
    <input type='hidden' name='keyword' value="${cri.keyword}">
    <div>
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
            <tr>
                <th>조회수</th>
                <td colspan="3" style="text-align: right;">${settingVO.hit}</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>제목</th>
                <td><input type="text" readonly="readonly" style="border:0px;" value="${settingVO.title}"></td>
                <th>작성자</th>
                <td><input type="text" name="id" readonly="readonly" value="${settingVO.id}"
                           style="text-align: right; border: 0px; position: relative; left: 6px;"/></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3"><textarea cols="70" rows="15" readonly="readonly"
                                          style="resize: none; border:0px;">${settingVO.contents}</textarea></td>
            </tr>
            </tbody>
            <tfoot>
            <tr style="text-align:right">
                <td></td>
                <td colspan="3">
                    <button type="button" id="btnRe" style="float: left">ReBoard</button>
                    <c:if test="${login.id == settingVO.id}">
                        <button type="button" id="btnModify">Modify</button>
                        <button type="submit" id="btnRemove">Remove</button>
                    </c:if>
                    <button type="button" id="btnCancel">List</button>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</form>
<div style="margin-top: 700px">
    <%@include file="../include/footer.jsp" %>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
<script>
    $(document).ready(function () {
        var form = $("#Form");

        $("#btnRe").on("click", function () {
            form.attr("action", "ReBoard");
            form.submit();
        })
        $("#btnCancel").on("click", function () {
            form.attr("action", "ListBoard");
            form.submit();
            //self.location = "/Board/ListBoard";
            /*history.back();*/
        });
        $("#btnRemove").on("click", function () {
            form.attr("action", "RemoveBoard");
            form.attr("method", "post"); // delete는 post로 보내줘야 한다.
            form.submit();
        });
        $("#btnModify").on("click", function () {
            form.submit();
        });
    });
</script>