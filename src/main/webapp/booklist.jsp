<%@ page import="java.util.List" %>
<%@ page import="java.util.List" %>
<%@ page import="sdaLibrary.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="sdaRandom.BookGenerator" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! int requestCount = 0;%>

<div><p>Tytul strony</p></div>

<div style="float:left; width:15%"><p> Elementy menu </p></div>
<div style="float:right; width:85%">

    Content strony<br/>
    <br/>
    <%


        List<Book> list = BookGenerator.listGenerator(4);

        out.println("<table>");
        for (Book book : list) {
            out.println("<tr>");
            out.println(String.format("<td>%s</td>%s<td></td><td>%d</td>",
                    book.getTitle(), book.getAuthor().toString(), book.getPageCount()));
            out.println("</tr>");
        }
        out.println("</table>");
    %>
 <%--zmienne zadeklarowane <%! sa zainicjalizowane na poczatku a dalsze operacje ja modyfikuja--%>
    <p>Ilosc wywolan strony: <%= ++requestCount%></p>
    <p> Ilosc wywolan ${requestCount eq 1} </p>


    <div style="clear:both"></div>
</div>

</body>
</html>
