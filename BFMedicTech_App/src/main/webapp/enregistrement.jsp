<%-- 
    Document   : enregistrement
    Created on : 14 mai 2020, 14 h 52 min 40 s
    Author     : fbibeau
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="manager.UserManager"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!String messageRetourEnregistrement;%>
<%messageRetourEnregistrement = String.valueOf(request.getAttribute("messageRetourEnregistrement"));%>

<%@include file="WEB-INF/include/header.jsp" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Formulaire d'inscription</h1>
    <%if (!messageRetourEnregistrement.equals("null") ) {%>
    <p><%=messageRetourEnregistrement%></p>
    <%}%>
    <form action="userEnregistrementControler" method="post">
        <!-- <input type="hidden" name="action" value="add" />-->
        <label>Nom <input type="text" name="firstName" class="form-control mr-sm-2"/></label> <br/>
        <label>Nom de Famille <input type="text" name="lastName"  class="form-control mr-sm-2"/></label> <br/>
        <label> Email <input type="text" name="email"  class="form-control mr-sm-2"/></label> <br/>
        <label> Mot de Passe <input type="password" name="password" class="form-control mr-sm-2" /></label> <br/>
        <label> Confirmer Mot de passe <input type="password" name="passwordConfirmation"  class="form-control mr-sm-2"/></label> <br/>
        <input type="submit" value="Soummettre l'inscription" />
    </form>

</body>
<%@include file="WEB-INF/include/footer.jsp" %>
</html>
