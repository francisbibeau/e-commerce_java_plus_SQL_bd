<%-- 
    Document   : usersInfo
    Created on : 21 mai 2020, 18 h 41 min 48 s
    Author     : fbibeau
--%>

<%@page import="entities.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");

%>

<%@include file="include/header.jsp" %>
<body>
    <section>    
        <%for (User user : users) {%>
        <div class =" produits">
            <h2>Noms du user</h2>
            <%= user.getName()%>
            <h2>Nom de famille</h2>
            <%=user.getLastName()%>
            <h2>Email</h2>
            <%=user.getEmail()%>
        </div>
        <%   }%>








    </section>
</body>
</html>
