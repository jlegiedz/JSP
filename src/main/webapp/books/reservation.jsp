<%@ page import="sdaLibrary.BookGenre" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Dodaj ksiazke </title>
</head>
<body>
<div style="width:100%; height:20%;border:black;margin:auto">
    <%@include file="../header.jsp" %>
</div>

<div style="float:left; width:20%">
    <%--dyrektywa--%>
    <%@include file="../menu.jsp" %>
</div>

<div style="float:right; width:80%">
    <c:if test="${book eq null}">
        <jsp:forward page="../error.jsp"/>
    </c:if>
    <p> Wypozycz ksiazke - ${book.getTitle()}</p>
    <p>Podaj dane osobowe: </p>
    <form name="userForm" action="/rentBook" method="post">
        <input type="hidden" value="${book.getId()}"/>

        <label> Imie: </label> <input type="text" name="name">
        <label> Nazwisko: </label> <input type="text" name="surname">
        <p> Dane adresowe:</p>
        <label> Nazwa i numer ulicy: </label> <input type ="text" name="street">
        <label> Miasto: </label> <input type ="text" name="city">
        <label> Kraj: </label> <input type ="text" name="country">
        <label> Kod pocztowy: </label> <input type ="text" name="postalCode">
        <label> Numer telefonu: </label> <input type ="text" name="telephoneNumber">

        <label> Narodowosc: </label>
        <select name="nationality">
            <c:forEach items="${nationalityList}" var = "nation">
                <option value="${nation}"> ${nation.getUserNationality()} </option>
            </c:forEach>
        </select>

        <label> PESEL: </label>
        <input type ="text" name="pesel">
        <label> Numer paszportu: </label>
        <input type ="text" name="passportNumber">

        <input type="submit" name="Zatwierdz dane">
    </form>

</div>

</body>
</html>
