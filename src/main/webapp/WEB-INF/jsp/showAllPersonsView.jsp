<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>First JSP App</title>
    </head>
    <body>
        <h2>Все пользователи:</h2>
<c:forEach var="row" items="${persons}">

       ${row.name}
        
    
</c:forEach>
    </body>
</html>
