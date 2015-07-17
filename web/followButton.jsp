<%-- 
    Document   : followButton
    Created on : Jul 16, 2015, 10:28:39 AM
    Author     : linshangzhen
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>
         <script type="text/javascript">
            $(document).ready(function () {
                $("#delete_follow").click(function () {
                    $("#div4").load("DeleteFollowServlet", {user_id: ${user_id}});
                });
            });
        </script>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#add_follow").click(function () {
                    $("#div4").load("AddFollowServlet", {user_id: ${user_id}});
                });
            });
        </script>

        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${is_followed}">
            <button class="btn btn-danger btn-lg" id="delete_follow">取关</button>
             
        </c:if>
        <c:if test="${!is_followed}">
            <button class="btn btn-success btn-lg" id="add_follow">关注</button>
            
        </c:if>
        
       
    </body>
</html>
