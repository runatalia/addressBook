<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
        <style>
            a {
                text-decoration: none;
                color: black;
            }
        </style>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {
                font-family: Arial;
                color: black;
            }

            .split {
                height: 100%;
                width: 50%;
                position: fixed;
                z-index: 1;
                top: 10%;
                overflow-x: hidden;
                padding-top: 20px;
            }

            .left {
                left: 0;
                background-color: white;
            }

            .right {
                right: 0;
                background-color: white;
            }
            .centered img {
                width: 150px;
                border-radius: 50%;
            }
        </style>
    </head>
    <body>
        <div class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
            <a href="/" class="d-flex align-items-center text-dark text-decoration-none">
                <svg xmlns="http://www.w3.org/2000/svg" width="40" height="32" class="me-2" viewBox="0 0 118 94" role="img"><title>Phone book</title><path fill-rule="evenodd" clip-rule="evenodd" d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z" fill="currentColor"></path></svg>
                <span class="fs-4">Pricing example</span>
            </a>

            <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
                <a class="me-3 py-2 text-dark text-decoration-none" href="#">Вход/Авторизация</a>
            </nav>
        </div>
        <h2>Телефонная книга:</h2>
        <br>
        <div class="split left">
            <div class="centered">

                <table class="table table-hover">

                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Город</th>
                            <th scope="col">Фамилия</th>
                            <th scope="col">Имя</th>
                            <th scope="col">Отчество</th>
                            <th scope="col">Телефон</th>
                            <th scope="col">Почта</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="row" var="i" step="1" items="${persons}">

                            <tr>
                               <th scope="row"> <c:out value="${i}"/></th>
                                
                                <td><a  href="personalDetails/${row.id}">${row.city}</a></td>
                                <td><a  href="personalDetails/${row.id}">${row.surname}</a></td>
                                <td><a href="personalDetails/${row.id}">${row.name}</a></td>
                                <td><a href="personalDetails/${row.id}">${row.patronymic}</a></td>
                                <td><a href="personalDetails/${row.id}">${row.phone}</a></td>
                                <td><a href="personalDetails/${row.id}">${row.email}</a></td>         

                            </tr>


                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
        <div class="split right">
            <div class="centered">
                <img src="img_avatar.png" alt="Avatar man">
                <h2>Имя:  ${person.name}</h2>
            </div>
        </div>
    </body>
</html>
