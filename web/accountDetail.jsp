<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#div4").load("IsFollowServlet", {user_id: ${user_id}});
            });
        </script>


        <title>account detail</title>
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
            <div class="row">
                <div class="col-md-3 col-md-offset-1">
                    <h1 style="position:relative;left: 100px;display: inline;">${user_name}</h1>
                </div>
                <div class="col-md-3 col-md-offset-1">
                    <div id="div4"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-1">
                <c:forEach var="m" items="${requestScope.messageList}">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">${user_name}</h3>
                        </div>
                        <div class="panel-body">
                            ${m.content} 
                            <c:forEach var="n" items="${m.forwardMessageList}">
                                <c:if test="${n.accountId != account.id}">
                                    //<a href="AccountDetailServlet?user_id=${n.accountId}&user_name=${n.accountName}">@${n.accountName}</a> : ${n.content}
                                </c:if>   
                                <c:if test="${n.accountId == account.id}">
                                    //<a href="home.jsp">@${n.accountName}</a> : ${n.content}
                                </c:if>     
                            </c:forEach> <br/><br/>
                            <a class="btn btn-sm btn-primary" style="float: right" href="MessageDetailServlet?message_id=${m.id}&message_content=${m.content}&message_account=${user_name}">详情</a><br/>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
