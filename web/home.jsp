<%-- 
    Document   : home
    Created on : Jul 14, 2015, 2:06:29 PM
    Author     : linshangzhen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#div1").load("ListMessageServlet");

            });
        </script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#button1").click(function () {
                    message = $("#textarea1").val();
                    $("#div1").load("PublishServlet", {messageContent: message});
                });
            });
        </script>



        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>

    </head>
    <body>
        ${sessionScope.account.name}+++++++++++++++++==<br/>
        <a href="FollowServlet">follow</a><br/>
        <textarea id="textarea1" rows="5" cols="60" name="messageContent"></textarea><br/><br/>
        <button id="button1" style="position: relative;left:220px"> 发布</button>  

        <p>--------------------------------</p>
        <div id="div1"></div>
        <p>--------------------------------</p>

        <a href="LogOutServlet">退出</a>
    </body>
</html>
