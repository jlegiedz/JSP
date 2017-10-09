<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Logowanie </title>
</head>
<body>

<div style = "width:100%; height:20%;border:black;margin:auto">
    <%@include file="header.jsp"%>
</div>

<div style="float:left; width:20%">
    <%--dyrektywa--%>
    <%@include file="menu.jsp"%>
</div>

<div style="float:right; width:80%">
    <img src ="http://www.piszanin.pl/imgfiles2/ksizaka3(1).jpg"></a

    <p> Podaj login i haslo: </p>

    <form name="login" action="/loginUser" method="post">
    <label> Nazwa uzytkownika </label> <input type="text" name="login"/>
    <label> Haslo </label> <input type="text" name="password"/>
    <input type="submit" name="Zatwierdz dane">
    </form>
</div>

</body>
</html>
