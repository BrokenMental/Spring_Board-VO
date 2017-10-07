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
    <link href="/resources/bootstrap/css/Board.css" rel="stylesheet" type="text/css" />
    <title>List Board</title>
</head>
<body style="text-align: center">
<%--<form id="trans_id" action="/Board/NewBoard">
    <input type="hidden" name="id" value="${userVO.id}"/>
</form>--%>
<h2>게시판 리스트</h2>
<table>
    <colgroup>
        <col width="10%"/>
        <col width="45%"/>
        <col width="10%"/>
        <col width="25%"/>
        <col width="10%"/>
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
            <td><a href="ReadBoard${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${list.bno}&id=${list.id}">${list.title}</a></td>
            <td>${list.id}</td>
            <td>${list.today}</td>
            <td>${list.hit}</td>
        </tr>
    </c:forEach>
    <c:if test="${fn:length(list) == 0}">
        <tr>
            <td colspan="5" style="text-align: center;">
                데이터가 없습니다.
            </td>
        </tr>
    </c:if>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="5" style="text-align: right; border: 0px;">
            <button id="btnNew" style="border: 0px;">New</button>
        </td>
    </tr>
    </tfoot>
</table>
<div>
    <ul class="pagination">
        <c:if test="${pageMaker.prev}">
            <li><a href="ListBoard${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
        </c:if>
        <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
            <li <c:out value="${pageMaker.cri.page == idx?'class = active':''}"/>>
                <a href="ListBoard${pageMaker.makeSearch(idx)}&id=${userVO.id}">${idx}</a>
            </li>
        </c:forEach>
        <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
            <li><a href="ListBoard${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
        </c:if>
    </ul>
</div>
<div>
    <select name="searchType">
        <option value="n"
                <c:out value="${cri.searchType == null?'selected':''}"/>>
            ---</option>
        <option value="t"
                <c:out value="${cri.searchType eq 't'?'selected':''}"/>>
            Title</option>
        <option value="c"
                <c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
            Content</option>
        <option value="i"
                <c:out value="${cri.searchType eq 'i'?'selected':''}"/>>
            ID</option>
        <option value="tc"
                <c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
            Title OR Content</option>
        <option value="ci"
                <c:out value="${cri.searchType eq 'ci'?'selected':''}"/>>
            Content OR ID</option>
        <option value="tci"
                <c:out value="${cri.searchType eq 'tci'?'selected':''}"/>>
            Title OR Content OR ID</option>
    </select> <input type="text" name='keyword' id="keywordInput" value='${cri.keyword }'>
    <button id='btnSearch'>Search</button>
</div>
<div style="margin-top: 700px">
    <%@include file="../include/footer.jsp" %>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    $(document).ready(
        function () {
            //var tid = $("form[id='trans_id']");
            $("#btnNew").on("click", function () {
                //tid.attr("action", "NewBoard");
                //tid.submit();
                self.location = "/NewBoard";
            });
            $('#btnSearch').on("click", function () {
                self.location = "ListBoard"
                    + '${pageMaker.makeQuery(1)}'
                    + "&searchType="
                    + $("select option:selected").val()
                    + "&keyword=" + $('#keywordInput').val();
            });
        });
</script>
</body>
</html>
