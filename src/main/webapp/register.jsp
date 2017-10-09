<%@ page import="sdaLibrary.BookGenre" %>
<%@ page import="UserRepository.UserRepository" %>
<%@ page import="sdaLibrary.User" %>
<%@ page import="sdaLibrary.Nationality" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Rejestracja</title>
</head>
<body>
<div style="width:100%; height:20%;border:black;margin:auto">
    <%@include file="/header.jsp" %>
</div>

<div style="float:left; width:20%">
    <%--dyrektywa--%>
    <%@include file="/menu.jsp" %>
</div>

<div style="float:right; width:80%">

    <p>Podaj dane osobowe: </p>


 <%--to co jest w action = request value w mapping w kontrolerze--%>

    <form name="userForm" action="/registerUser" method="post">
        <input name ="bookId" type="hidden" value="${book.getId()}"/>

        <label> Imie: </label> <input type="text" name="name">
        <label> Nazwisko: </label> <input type="text" name="surname">
        <p> Dane adresowe:</p><br/>
        <label> Nazwa i numer ulicy: </label> <input type="text" name="street">
        <label> Miasto: </label> <input type="text" name="city"><br/>
        <label> Kod pocztowy: </label> <input type="text" name="postalCode">
        <label> Kraj: </label> <input type="text" name="country"><br/>
        <label> Narodowosc: </label>
        <select name="nationality">
            <c:forEach items="${nationalityList}" var="nation">
                <option value="${nation}"> ${nation.getUserNationality()} </option>
            </c:forEach>
        </select><br/>
        <label> PESEL: </label>
        <input type="text" name="pesel">
        <label> Numer paszportu: </label>
        <input type="text" name="passportNumber"><br/>

        <p> Podaj login i haslo: </p>
        <label> Nazwa uzytkownika </label> <input type="text" name="login"/>
        <label> Haslo </label> <input type="text" name="password"/>
        <input type="submit" name="Zatwierdz dane">
    </form>

</div>

</body>
</html>
