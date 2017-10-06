
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blad</title>
</head>
<body>
<h3> Wystapil blad, wroc na strone glowna. Mozesz sie tez zalogowac:</h3>

<form action="/login" method = "post">
    <label> Nazwa uzytkownika </label> <input type="text" name="login"/>
    <label> Haslo </label> <input type="text" name="password"/>
    <input type="submit" value = "Zaloguj"/>


</form>
</body>
</html>
