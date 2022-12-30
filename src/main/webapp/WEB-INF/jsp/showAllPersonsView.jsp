<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>First JSP App</title>
            <style>
        table {
            width: 50%;
     border: none;
	margin-bottom: 20px;
	border-collapse: separate;
}
 th {
	font-weight: bold;
	text-align: left;
	border: none;
	padding: 10px 15px;
	background: #EDEDED;
	font-size: 14px;
	border-top: 1px solid #ddd;
}
th:first-child, .table tr td:first-child {
	border-left: 1px solid #ddd;
}
th:last-child, .table tr td:last-child {
	border-right: 1px solid #ddd;
}
 tr th:first-child {
	border-radius: 20px 0 0 0;
}
tr th:last-child {
	border-radius: 0 20px 0 0;
}
td {
	text-align: left;
	border: none;
	padding: 10px 15px;
	font-size: 14px;
	vertical-align: top;
}
tr:nth-child(even) {
	background: #F8F8F8;
}
tr:last-child td{
	border-bottom: 1px solid #ddd;
}
tr:last-child td:first-child {
	border-radius: 0 0 0 20px;
}
 tr:last-child td:last-child {
	border-radius: 0 0 20px 0;
}
       


    </style>
    </head>
    <body>
        <h2>Телефонная книга:</h2>
        <br>
        <table>
            
           
            <tr>
                <th>Город</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th>Телефон</th>
                <th>Почта</th>
            </tr>
            <c:forEach var="row" items="${persons}">
                <tr>
                    <td>${row.city}</td>
                    <td>${row.surname}</td>
                    <td>${row.name}</td>
                    <td>${row.patronymic}</td>
                    <td>${row.phone}</td>
                    <td>${row.email}</td>         
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
