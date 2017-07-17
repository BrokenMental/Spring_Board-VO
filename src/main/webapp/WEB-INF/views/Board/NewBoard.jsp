<%--
  Created by IntelliJ IDEA.
  User: Jinuk
  Date: 2017-07-17
  Time: 오전 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
    <title>New Board</title>
</head>
<body>
<form method="post">
<table width="600" style="margin: auto">
    <colgroup>
        <col width="10%">
        <col width="70%">
    </colgroup>
    <thead>
    <tr>
        <th>제목</th>
        <td><input type="text" name="Title" size="69"></td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th>내용</th>
        <td><textarea name="Contents" cols="70" rows="15" style="resize: none"></textarea></td>
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
            /*self.location = "/";*/
        });
    });
</script>