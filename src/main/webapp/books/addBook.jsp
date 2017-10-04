<%@ page import="sdaLibrary.BookGenre" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Dodaj ksiazke </title>
</head>
<body>
<div style = "width:100%; height:20%;border:black;margin:auto">
    <%@include file="../header.jsp"%>
</div>

<div style="float:left; width:20%">
    <%--dyrektywa--%>
    <%@include file="../menu.jsp"%>
</div>

<div style="float:right; width:80%">
 <%--action---> sciezka do metody w Controllerze;
 nazwy inputa musza byc takie same jak pola w klasie book;
 nazwa form: pojawia sie --%>
  <form name="bookForm" action="/addBook" method="post">
      <label> Tytul ksiazki: </label> <input type="text" name="title"/>
      <label> ISBN: </label> <input type="text" name="isbn"/>
      <label> Liczba stron: </label> <input type="text" name="pageCount"/>
      <label> Imie i nazwisko autora: </label>
      <input type="text" name="Author.name"/>
      <input type="text" name="Author.surname"/>
      <label> Rodzaj: </label>
      <select name="genre">
        <c:forEach items="${genreList}" var = "elem">
            <%--var oznacza deklaracje zmiennej, opakowuje ponizej za pomoca dolara i klamerek--%>
            <option value="${elem}"> ${elem.getFriendlyName()} </option>
            </c:forEach>
      </select>
      <input type ="submit" value="Zapisz"/>
  </form>

</div>

</body>
</html>
