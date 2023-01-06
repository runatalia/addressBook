<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>


    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
        <title>Страница входа</title>


    </head>

    <body class="text-center">
        <form class="form-signin" action = "authorizationChek" modelAttribute = "auth" method="post">
            <img class="mb-4" src="/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">Регистрация/вход</h1>
            <label for="inputEmail" class="sr-only">Почта</label>
            <br>
            <input type="email" id="inputEmail" class="form-control" placeholder="Введите почту" required="" autofocus="" >
            <br>
            <label for="inputPassword" class="sr-only">Пароль</label>
            <br>
            <input type="password" id="inputPassword" class="form-control" placeholder="Введите пароль" required=""  >
            <br>
            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> Запомнить меня
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
        </form>


    </body></html>