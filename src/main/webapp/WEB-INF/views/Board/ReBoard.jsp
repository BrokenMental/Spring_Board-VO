<%--
  Created by IntelliJ IDEA.
  User: Jinuk
  Date: 2017-07-19
  Time: 오후 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
    <title>Re Board</title>
</head>
<body style="text-align: center">
<h2>게시판 답글</h2>
<form id="Form" method="post">
    <table width="600" style="margin: auto">
        <colgroup>
            <col width="10%">
            <col width="70%">
        </colgroup>
        <thead>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title" value="(RE)${settingVO.title}" size="69"></td>
        </tr>
        <thead>
        </thead>
        <tbody>
        <tr>
            <th>내용</th>
            <td><textarea name="contents" cols="70" rows="15" style="resize: none">${settingVO.contents}</textarea></td>
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
</body>
</html>
<script>
    $(document).ready(function () {
        $("#btnCancel").on('click', function () {
            history.back();
        });
    });
</script>