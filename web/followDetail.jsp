<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#button3").click(function () {
                    message = $("#input1").val();
                    $("#div3").load("SearchServlet", {search: message});
                });
            });
        </script>
        <title>Follow Detail</title>
    </head>
    <body>
        <h1>Follow Detail</h1>
    <h>我的关注</h><br/>
        <c:forEach var="m" items="${requestScope.followee_list}">
        <a href="AccountDetailServlet?user_id=${m.id}&user_name=${m.name}">
            ${m.name}<br/>
        </a>
    </c:forEach>
    ++++++++++++++++++++++++++++++++++++++<br/>
    <h>我的粉丝</h><br/>
        <c:forEach var="n" items="${requestScope.follower_list}">
        <a href="AccountDetailServlet?user_id=${n.id}&user_name=${n.name}">
            ${n.name}<br/>
        </a>
    </c:forEach>
    <br/><br/><br/>
    <input id="input1" type="text">
    <button id="button3">搜索</button>

    <div id="div3"></div>




</body>
</html>
