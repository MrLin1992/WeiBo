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
        <title>Register Page</title>
    </head>
    <body>
        <form action="RegisterServlet" method="post"> 
            邮箱：<input style="width:160px" type="text" name="name">
            <span>${registerErrors.email }</span></br>
            姓名：<input style="width:160px" type="text" name="email">
            <span>${registerErrors.name }</span></br>
            密码：<input style="width:160px" type="password" name="password">
            <span>${registerErrors.password }</span></br>
            确认密码：<input style="width:160px" type="password" name="password1">
            <span>${registerErrors.password1 }</span></br>
            
        <input style="position: relative;left:80px" type="submit" value="注册"> 
        
        </form>
    </body>
</html>
