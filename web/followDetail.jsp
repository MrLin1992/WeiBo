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
                $("#button3").click(function () {
                    message = $("#input1").val();
                    $("#div3").load("SearchServlet", {search: message});
                });
            });
        </script>
        <title>Follow Detail</title>
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
            <div class="col-md-3 col-md-offset-1">
                <h3 style="text-align: center">我的关注</h3>
                <c:forEach var="m" items="${requestScope.followee_list}">
                    <a href="AccountDetailServlet?user_id=${m.id}&user_name=${m.name}">
                        <h3 style="text-align: center"><span class="label label-warning">${m.name}</span></h3>
                    </a>
                </c:forEach>
            </div>
            <div class="col-md-3 col-md-offset-0">
                <h3 style="text-align: center">我的粉丝</h3>
                <c:forEach var="n" items="${requestScope.follower_list}">
                    <a href="AccountDetailServlet?user_id=${n.id}&user_name=${n.name}">
                        <h3 style="text-align: center"><span class="label label-success">${n.name}</span></h3>
                    </a>
                </c:forEach>
            </div>
            <div class="col-md-2 col-md-offset-0">
                <br/><br/><br/><br/>
                <input id="input1" class="form-control" type="text"><br/>
                <button id="button3" class="btn btn-primary" style="float: right">搜索</button>
                <br/><br/><br/>
                <div id="div3" ></div>
            </div>


        </div>

    </body>
</html>
