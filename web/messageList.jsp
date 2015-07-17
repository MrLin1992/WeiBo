<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MessageList Page</title>
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>


    </head>
    <body>
        <c:forEach var="m" items="${requestScope.messageList}">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <c:if test="${m.accountId != account.id}">
                            <strong> <a href="AccountDetailServlet?user_id=${m.accountId}&user_name=${m.accountName}"> ${m.accountName}</a></strong><br/>
                        </c:if>   
                        <c:if test="${m.accountId == account.id}">
                            <strong> <a href="home.jsp">${m.accountName}</a></strong><br/>
                            </c:if> 

                    </h3>
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
                    </c:forEach>  <br/><br/>


                    <div class="row">
                        <div class="col-md-2 col-md-offset-8">
                            <c:if test="${m.accountId == account.id}">
                                <button class="btn btn-sm btn-primary" id="button_delete_${m.id}" class="delete" value="${m.id}">删除</button>
                            </c:if> 

                        </div>
                        <div class="col-md-2 col-md-offset-0">
                            <a class="btn btn-sm btn-primary" href="MessageDetailServlet?message_id=${m.id}&message_content=${m.content}&message_account=${m.accountName}">详情</a>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                $(document).ready(function () {
                    $("#button_delete_${m.id}").click(function () {
                        $("#div1").load("DeleteMessage", {message_id:${m.id}});
                    });
                });
            </script>


        </c:forEach>

    </body>
</html>
