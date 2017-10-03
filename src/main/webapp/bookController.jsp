<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<div style="float:left; width:15%">
    <p> Elementy menu </p>
</div>

<div style="float:right; width:85%">

    <table>
        <%--taglib z imporu pozwalajcy odwolac sie do bibl--%>
        <%--book to jak zmienna tymczasowa po ktorej sie odwolujemy do elemntow listy--%>
        <c:forEach items="${list}" var="book">
            <tr>
                <td>${book.getTitle()}</td>
                <td>${book.getAuthor().toString()}</td>
                <td>${book.getPageCount()}</td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
