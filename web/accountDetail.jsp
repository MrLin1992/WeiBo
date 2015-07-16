<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#div4").load("IsFollowServlet", {user_id: ${user_id}});
            });
        </script>
       

        <title>account detail</title>
    </head>
    <body>
        <h1>${user_name}</h1>
        <div id="div4"></div>
        <br/><br/>

        <c:forEach var="m" items="${requestScope.messageList}">
            ${user_name}:${m.content} 
            <a href="MessageDetailServlet?message_id=${m.id}&message_content=${m.content}&message_account=${user_name}">detail</a><br/>
        </c:forEach>
    </body>
</html>
