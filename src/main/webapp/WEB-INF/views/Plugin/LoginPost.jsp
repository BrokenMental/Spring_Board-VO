<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 2017-10-09-009
  Time: 오전 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<script>
    var id = "${id}";
    var flag = "${flag}";
    if(flag == "no"){
        alert("아이디가 틀렸습니다."+id);
        self.location = "/";
    }else if(id != "" && flag == "yes"){
        self.location = "/Board/ListBoard";
    }
</script>
</body>
</html>
