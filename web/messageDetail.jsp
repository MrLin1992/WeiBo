<%-- 
    Document   : messageDetail
    Created on : Jul 15, 2015, 12:12:55 PM
    Author     : linshangzhen
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
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

        <br/><br/><br/><br/>


        <div class="row">
            <div class="col-md-6 col-md-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">${message_account}</h3>
                    </div>
                    <div class="panel-body">
                        ${message_content}
                        <c:forEach var="n" items="${message_for_detail.forwardMessageList}">
                            <c:if test="${n.accountId != account.id}">
                                //<a href="AccountDetailServlet?user_id=${n.accountId}&user_name=${n.accountName}">@${n.accountName}</a> : ${n.content}
                            </c:if>   
                            <c:if test="${n.accountId == account.id}">
                                //<a href="home.jsp">@${n.accountName}</a> : ${n.content}
                            </c:if>     
                        </c:forEach> 
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div id="div2" class="col-md-6 col-md-offset-2">
            </div>
            <div class="col-md-2 col-md-offset-0">

                <form action="ForwardServlet?message_id=${message_id}" method="post" style="display: inline; ">
                    <textarea id="textarea2" class="form-control" rows="5" name="message_content"></textarea>  <br/><br/>     
                    <input type="submit" value="转发" class="btn btn-sm btn-primary" style="position:relative;left: 80px;"> </input>

                </form>
                <button id="button2" class="btn btn-sm btn-primary" style="float: right;"> 评论</button>
            </div>
        </div>
    </body>
</html>
