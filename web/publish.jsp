<%-- 
    Document   : publish
    Created on : Jul 15, 2015, 9:40:31 AM
    Author     : linshangzhen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>publish</h1>
        <textarea id="textarea1" rows="5" cols="60" name="messageContent"></textarea><br/><br/>
        <button id="button1" style="position: relative;left:220px"> 发布</button>
        <span>${publishErrors.content }</span></br>
    </body>
</html>
