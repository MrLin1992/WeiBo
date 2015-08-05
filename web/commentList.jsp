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
        <link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="m" items="${requestScope.commentList}">
            <div  class="well">
                <thead><tr><th>
                            ${m.accountName} :

                            ${m.content}
                            <c:if test="${m.accountId == account.id}">
                                <button id="button_delete_comment_${m.id}" value="${m.id}" class="btn btn-sm btn-primary"  style="float: right">删除</button>
                            </c:if>
                            <br/>
                        </th>
                    </tr>
                </thead>

                <script type="text/javascript">
                    $(document).ready(function () {
                        $("#button_delete_comment_${m.id}").click(function () {
                            $("#div2").load("DeleteComment", {comment_id:${m.id}, message_id:${m.messageId}});
                        });
                    });
                </script>
            </div>
        </c:forEach>
        <!--commentList page jmeter -->
    </body>
</html>
