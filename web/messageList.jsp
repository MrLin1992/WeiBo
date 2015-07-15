<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MessageList Page</title>
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>


    </head>
    <body>
        <h1>Message List</h1>
        <c:forEach var="m" items="${requestScope.messageList}">

            ${m.accountName}:
            ${m.content}
            <button id="button_delete_${m.id}" class="delete" value="${m.id}">delete</button>
            <a href="MessageDetailServlet?message_id=${m.id}&message_content=${m.content}&message_account=${m.accountName}">detail</a><br/>
            <script type="text/javascript">
                $(document).ready(function () {
                    $("#button_delete_${m.id}").click(function () {
                        $("#div1").load("DeleteMessage", {message_id:${m.id}});
                    });
                });
            </script>

        </c:forEach>

    </body>
</html>
