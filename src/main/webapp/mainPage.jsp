<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Biblioteka </title>
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
    <p> Zalogowany uzytkownik - ${loggedUser}</p>
    <img src ="http://www.piszanin.pl/imgfiles2/ksizaka3(1).jpg"></a>
<h3>Witaj ${loggedUser}, czy chcesz sie wylogowac?</h3>

<form action = "/logout.jsp" method="post">
    <input type="submit"  value="Wyloguj z systemu"/>
</form>
</div>

</body>
</html>
