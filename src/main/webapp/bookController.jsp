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
    <table style="border:2px solid black; width:80%">
        <%--taglib z imporu pozwalajcy odwolac sie do bibl--%>
        <%--book to jak zmienna tymczasowa po ktorej sie odwolujemy do elemntow listy--%>
            <tr style="border:1px solid black">
                <td style="border:1px solid black"> TYTUL </td>
                <td style="border:1px solid black"> AUTOR </td>
                <td style="border:1px solid black"> LICZBA STRON </td>
            </tr><br/>
        <c:forEach items="${list}" var="book">

            <tr style="border:1px solid black">
                <td style="border:1px solid black">${book.getTitle()}</td>
                <td style="border:1px solid black">${book.getAuthor().toString()}</td>
                <td style="border:1px solid black">${book.getPageCount()}</td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
