<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>serach result</h1><br/>
        <c:forEach var="m" items="${requestScope.searchResult}">
            ${m.name} <br/>
        </c:forEach>
    </body>
</html>
