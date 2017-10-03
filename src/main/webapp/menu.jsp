<ul>
    <c:forEach items="${menu}" var = "elem">
       <a href="${elem.getUrl()}"> <li>${elem.getElementName()}</li></a>
    </c:forEach>

        <%--zamiast tego w Enum Element mamy enum z elementami --%>
<%--</ul>--%>
<%--<ul>--%>
    <%--<li style="font-size: larger; list-style:none "> Menu </li><br/>--%>
    <%--<li> Strona glowna </li>--%>
    <%--<li> Dodawanie ksiazek </li>--%>
    <%--<li> Lista ksiazek </li>--%>
    <%--<li> Wypozyczenie ksiazki </li>--%>
<%--</ul>--%>