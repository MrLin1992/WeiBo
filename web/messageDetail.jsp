<%-- 
    Document   : messageDetail
    Created on : Jul 15, 2015, 12:12:55 PM
    Author     : linshangzhen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MessageDetail Page</title>
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#div2").load("ListCommentServlet", {message_id:${message_id}});
            });
        </script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#button2").click(function () {
                    comment = $("#textarea2").val();
                    $("#div2").load("AddCommentServlet", {message_id:${message_id}, commentContent: comment});
                });
            });

        </script>
    </head>
    <body>
        ${message_account}+++++++++++++++++++++${message_content}
        <h1>Message Detail</h1>
        
        ----------------------------------------------------<br>
        <textarea id="textarea2" rows="5" cols="60" name="commentContent"></textarea><br/><br/>
        <button id="button2" style="position: relative;left:220px"> 评论</button> ${message_id}<br/>
        +++++++++++++++++++++++++++++++++++++++++
        <div id="div2"> </div>
    </body>
</html>
