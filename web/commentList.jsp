<%-- 
    Document   : commentList
    Created on : Jul 15, 2015, 2:05:45 PM
    Author     : linshangzhen
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>comment list</h1>
        <c:forEach var="m" items="${requestScope.commentList}">
            ${m.accountName}:
            ${m.content}
            <c:if test="${m.accountId == account.id}">
                <button id="button_delete_comment_${m.id}" value="${m.id}">delete</button>
            </c:if>
            <br/>
            <script type="text/javascript">
                $(document).ready(function () {
                    $("#button_delete_comment_${m.id}").click(function () {
                        $("#div2").load("DeleteComment", {comment_id:${m.id}, message_id:${m.messageId}});
                    });
                });
            </script>

        </c:forEach>
    </body>
</html>
