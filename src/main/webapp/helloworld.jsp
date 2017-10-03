<%@ page import="java.time.LocalDate" %>
<%@ page import="sdaRandom.RandomNumberGenerator" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.stream.Stream" %>
<html>
<head>
</head>
<body>
    <h1> Hello world <%= LocalDate.now() %>
    </h1>
    <a href="helloworld.jsp"> Link do nowej strony </a>
    <p>Zawartosc zadania: </p>

        Host:  <%= request.getHeader("Host")%>
        Host z malych liter wolany:  <%= request.getHeader("host")%>
        Typ metody:  <%= request.getMethod()%><br/>
        Parametry uzytkownika: <%= request.getQueryString()%><br/>
        Dzisiejsze numery totka:<%= RandomNumberGenerator.drawLottoNumbers() %><br/>

        Dzisiejsze typy dla EuroJackot:
        <%
            Random random = new Random();
            StringBuilder piecZ45 = new StringBuilder();
            StringBuilder dwaZ10 =  new StringBuilder();

            for (int i = 0; i <5 ; i++) {
                if(i!=0){
                    piecZ45.append(",");
                    dwaZ10.append(", ");
                }
                if(i>2){
                    piecZ45.append(random.nextInt(10)+1);
                }
                dwaZ10.append(random.nextInt(45)+1);
            }
            out.println(piecZ45.toString());
            out.println("<br/> oraz dwie z 10:");
            out.println(dwaZ10.toString());

            String userParams = request.getQueryString();

            if(userParams == null){
                response.sendRedirect("http://www.google.pl");
            }
            else{
                String[] params = userParams.split("&");
                String idParam = null;
               for(String param: params){
                   String[] keyValuePair = param.split("=");
                   if(keyValuePair.length==2 && keyValuePair[0].contains("id")) {
                     idParam=keyValuePair[1];
                       break;
                   }
               }
               if(idParam ==null){
                   response.sendError(404);
               }
               else{
                   out.println("Wartosc parametru id: "+ idParam);
               }
            }
        %>
</body>
</html>