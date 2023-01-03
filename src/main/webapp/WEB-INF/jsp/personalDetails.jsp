
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>Детальная информация</h2>
        <br>
    ${person.city}
    ${person.surname}
    ${person.name}
    ${person.patronymic}
    ${person.phone}
    ${person.email}
    ${person.photo}
    ${person.comments}
    <br>
</body>
</html>