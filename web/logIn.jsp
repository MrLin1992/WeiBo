<%-- 
    Document   : logIn
    Created on : Jul 14, 2015, 10:17:44 AM
    Author     : linshangzhen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn Page</title>
    </head>
    <body>
        <form action="LogInServlet" method="post"> 
            姓名:<input style="width:160px" type="text" name="name">
            <span>${logInErrors.name }</span></br>
            密码:<input style="width:160px" type="password" name="password">
            <span>${logInErrors.password }</span></br>
            
        <input style="position: relative;left:80px" type="submit" value="登录"> 
        
        </form>
    </body>
</html>
