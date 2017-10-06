<%@ page import="sdaLibrary.BookGenre" %>
<%@ page import="UserRepository.UserRepository" %>
<%@ page import="sdaLibrary.User" %>
<%@ page import="sdaLibrary.Nationality" %>
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


    <form action="/rentBookByLoggedUser" method="post">
        <input type="hidden" name ="bookId" value="${book.getId()}">
    <%
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
            if((cookie.getName()).equals("userId")){
                User user = UserRepository.getUserById(cookie.getValue());
               if(user != null){
                   out.println("Czy chcesz wypozyczyc ksiazke jako user: " +
                   user.getName()+" "+
                   user.getSurname());
                   if(user.getNationality().equals(Nationality.PL)){
                       out.println("numer PESEL:" + user.getPesel());
                       out.println("<input type=\"hidden\" name=\"userId\" value=\"" + user.getId()+"\"/>");
                       out.println("<input type=\"submit\"> Wypozycz </input>" );
                   }else
                       out.println("numer paszportu: " + user.getPassportNumber());
               }
            }
        }
    %>
    </form>


    <form name="userForm" action="/rentBook" method="post">
        <input name ="bookId" type="hidden" value="${book.getId()}"/>

        <label> Imie: </label> <input type="text" name="name">
        <label> Nazwisko: </label> <input type="text" name="surname">
        <p> Dane adresowe:</p>
        <label> Nazwa i numer ulicy: </label> <input type="text" name="street">
        <label> Miasto: </label> <input type="text" name="city">
        <label> Kraj: </label> <input type="text" name="country">
        <label> Kod pocztowy: </label> <input type="text" name="postalCode">
        <label> Numer telefonu: </label> <input type="text" name="telephoneNumber">
        <label> Narodowosc: </label>
        <select name="nationality">
            <c:forEach items="${nationalityList}" var="nation">
                <option value="${nation}"> ${nation.getUserNationality()} </option>
            </c:forEach>
        </select>

        <label> PESEL: </label>
        <input type="text" name="pesel">
        <label> Numer paszportu: </label>
        <input type="text" name="passportNumber">

        <input type="submit" name="Zatwierdz dane">
    </form>

</div>

</body>
</html>
