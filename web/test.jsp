<%-- 
    Document   : test
    Created on : Jul 16, 2015, 8:47:47 PM
    Author     : linshangzhen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="home.jsp">${sessionScope.account.name}的微博</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="home.jsp">主页</a></li>
                        <li><a href="FollowServlet">关注</a></li>
                        <li><a href="LogOutServlet">退出</a></li>
                        <li class="dropdown"> 
                    </ul>

                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="jumbotron">
            <br/><br/>
            <h1 style="position:relative;left: 100px;display: inline;">${user_name}</h1>
            <div id="div4" style="float: right"></div>
        </div>
    <c:forEach var="m" items="${requestScope.messageList}">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">${user_name}</h3>
            </div>
            <div class="panel-body">
                ${m.content} <br/>
                <a href="MessageDetailServlet?message_id=${m.id}&message_content=${m.content}&message_account=${user_name}">detail</a><br/>
            </div>
        </div>
    </c:forEach>

</body>
</html>
