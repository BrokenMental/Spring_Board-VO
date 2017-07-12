<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>== Setting ==</title>
</head>
<body>
<h2>게시판 조회</h2>
<table style="border:1px solid #ccc">
    <colgroup>
        <col width="10%"/>
        <col width="*"/>
        <col width="15%"/>
        <col width="20%"/>
    </colgroup>
    <thead>
    <tr>
        <th scope="col">글번호</th>
        <th scope="col">제목</th>
        <th scope="col">조회수</th>
        <th scope="col">작성일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="row">
        <tr>
            <td>${row.idx}</td>
            <td>${row.title}</td>
            <td>${row.hit_cnt}</td>
            <td>${row.crea_dtm}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>