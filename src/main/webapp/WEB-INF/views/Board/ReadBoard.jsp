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
    <link href="/resources/bootstrap/css/Board.css" rel="stylesheet" type="text/css"/>
    <title>Read Board</title>
</head>
<body style="text-align: center">
<h2>게시물 상세보기</h2>
<%-- title,contents를 넣을때 중복된 값이 포함되는 이유는 form의 input-name과 아래 table의 input-name이 동일했기 때문이다. --%>
<form id="Form" action="ModifyBoard" method="get">
	<input type='hidden' name='bno' value="${settingVO.bno}">
    <input type='hidden' name='page' value="${cri.page}">
    <input type='hidden' name='perPageNum' value="${cri.perPageNum}">
    <input type='hidden' name='searchType' value="${cri.searchType}">
    <input type='hidden' name='keyword' value="${cri.keyword}">
</form>
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
                <c:if test="${id == settingVO.id}">
                    <button type="button" id="btnModify">Modify</button>
                    <button type="submit" id="btnRemove">Remove</button>
                </c:if>
                <button type="button" id="btnCancel">List</button>
            </td>
        </tr>
        </tfoot>
    </table>
    <div class="box box-success box-reply">
        <div class="box-header">
            <h3 class="box-title">ADD NEW REPLY</h3>
        </div>
        <div class="box-body">
            <label for="newReplyWriter">Writer</label>
            <input class="form-control" type="text" placeholder="USER ID" id="newReplyWriter">
            <label for="newReplyText">ReplyText</label>
            <input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
        </div>
        <div class="box-footer">
            <button type="submit" class="btn btn-info" id="replyAddBtn">ADD REPLY</button>
        </div>
    </div>

    <!-- The time line -->
    <ul class="timeline box-timeline">
        <!-- timeline time label -->
        <li class="time-label" id="repliesDiv">
            <span class="bg-green">Replies List</span>
        </li>
    </ul>
    <div class="text-center">
        <ul id="pagination" class="pagination pagination-sm no-margin">
        </ul>
    </div>
</div>
<!-- /.col (left) -->
</div>
<div id="modifyModal" class="modal modal-primary fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body" data-rno>
                <p><input type="text" id="replytext" class="form-control"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
                <button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<div>
    <%@include file="../include/footer.jsp" %>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template" type="text/x-handlebars-template">
    {{#each .}}
    <li class="replyLi" data-rno={{rno}}>
        <i class="fa fa-comments bg-blue"></i>
        <div class="timeline-item">
			<span class="time">
				<i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
			</span>
            <h3 class="timeline-header"><strong>{{rno}}</strong> - {{replyer}}</h3>
            <div class="timeline-body">{{replytext}}</div>
            <div class="timeline-footer">
                <a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#modifyModal">Modify</a>
            </div>
        </div>
    </li>
    {{/each}}
</script>
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

    Handlebars.registerHelper("prettifyDate", function (timeValue) {
        var dateObj = new Date(timeValue);
        var year = dateObj.getFullYear();
        var month = dateObj.getMonth() + 1;
        var date = dateObj.getDate();
        return year + "/" + month + "/" + date;
    });

    var printData = function (replyArr, target, templateObject) {
        var template = Handlebars.compile(templateObject.html());

        var html = template(replyArr);
        $(".replyLi").remove();
        target.after(html);
    }
    var bno = ${settingVO.bno};
    var replyPage = 1;

    function getPage(pageInfo) {

        $.getJSON(pageInfo, function (data) {
            printData(data.list, $("#repliesDiv"), $("#template"));
            printPaging(data.pageMaker, $(".pagination"));

            $("#modifyModal").modal("hide");
        });
    }

    var printPaging = function (pageMaker, target) {
        var str = "";

        if (pageMaker.prev) {
            str += "<li><a href='" + (pageMaker.startPage - 1) + "'> << </a></li>";
        }

        for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
            var strClass = pageMaker.cri.page == i ? 'class=active' : '';
            str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
        }

        if (pageMaker.next) {
            str += "<li><a href='" + (pageMaker.endPage + 1) + "'> >> </a></li>";
        }

        target.html(str);
    }

    $("#repliesDiv").on("click", function () {

        if ($(".timeline li").size() > 1) {
            return;
        }
        getPage("/replies/" + bno + "/1");
    });

    $(".pagination").on("click", "li a", function (event) {
        event.preventDefault();
        replyPage = $(this).attr("href");
        getPage("/replies/" + bno + "/" + replyPage);
    });

    $("#replyAddBtn").on("click", function () {
        var replyerObj = $("#newReplyWriter");
        var replytextObj = $("#newReplyText");
        var replyer = replyerObj.val();
        var replytext = replytextObj.val();

        $.ajax({
            type: 'post',
            url: '/replies/',
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "POST"
            },
            dataType: 'text',
            data: JSON.stringify({bno: bno, replyer: replyer, replytext: replytext}),
            success: function (result) {
                console.log("result: " + result);
                if (result == 'SUCCESS') {
                    alert("등록 되었습니다.");
                    replyPage = 1;
                    getPage("/replies/" + bno + "/" + replyPage);
                    replyerObj.val("");
                    replytextObj.val("");
                }
            }
        });
    });

    $(".timeline").on("click", ".replyLi", function (event) {
        var reply = $(this);

        $("#replytext").val(reply.find('.timeline-body').text());
        $(".modal-title").html(reply.attr("data-rno"));
    });

    $("#replyModBtn").on("click", function () {
        var rno = $(".modal-title").html();
        var replytext = $("#replytext").val();

        $.ajax({
            type: 'put',
            url: '/replies/' + rno,
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "PUT"
            },
            data: JSON.stringify({replytext: replytext}),
            dataType: 'text',
            success: function (result) {
                console.log("result: " + result);
                if (result == "SUCCESS") {
                    alert("수정 되었습니다.");
                    getPage("/replies/" + bno + "/" + replyPage);
                }
            }
        });
    });

    $("#replyDelBtn").on("click", function () {
        var rno = $(".modal-title").html();
        var replytext = $("#replytext").val();

        $.ajax({
            type: 'delete',
            url: '/replies/' + rno,
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "DELETE"
            },
            dataType: 'text',
            success: function (result) {
                console.log("result: " + result);
                if (result == 'SUCCESS') {
                    alert("삭제 되었습니다.");
                    getPage("/replies/" + bno + "/" + replyPage);
                }
            }
        });
    });
</script>
</body>
</html>