<%-- 
    Document   : home
    Created on : Jul 14, 2015, 2:06:29 PM
    Author     : linshangzhen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
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
            <div id="div1" class="col-md-6 col-md-offset-1">
            </div>
            <div class="col-md-2 col-md-offset-0">
                <br/><br/>
                <textarea id="textarea1" class="form-control" rows="5" name="messageContent"></textarea><br/>
                <button id="button1" class="btn btn-sm btn-primary" style="float: right;"> 发布</button>  
            </div>
        </div>
        <!--home page jmeter -->

    </body>
</html>
