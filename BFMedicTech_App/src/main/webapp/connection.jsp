<%-- 
    Document   : connection
    Created on : 14 mai 2020, 22 h 06 min 35 s
    Author     : fbibeau
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! String badPassConfirmation;%>
<% badPassConfirmation = String.valueOf(request.getAttribute("wp"));%>

<%@page import="entities.Cart"%>
<%@page import="entities.User"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href="css/css.css">
        <link rel="stylesheet" href="css/csslogin.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head>
    <body>
        <%! User user;%>

        <%user = (User) session.getAttribute("user");%>

        <%! Cart cart;%>

        <div class="container">
            <nav class="navbar navbar-light bg-light border border-warning rounded">
                <a href="acceuilA"><img id="logo_img" src='images/img/logo.png' alt='cart'></a>
                <div class="navbar">
                    <div id="searchForm">
                        <form class="form-inline" action="rechercheProduit" method="post">
                            <input id="search" class="form-control mr-sm-2" name="mot" type="search" placeholder="Vous cherchez quoi?" aria-label="Search">
                            <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search">
                        </form>
                    </div>
                    <div id="panier" class="border border-warning rounded">
                        <% if (session.getAttribute("cart") != null) {
                          cart = (Cart) session.getAttribute("cart");%>
                        <span id="qte_panier"><%=cart.getSize()%></span>
                        <% } %>
                        <a href="affichageCart"><img id="cart_img" src='images/img/cart.jpg' alt='cart'></a>
                    </div>
                </div>
            </nav>
            <p id="vide"></p>
            <nav class="navbar navbar-light bg-light border border-warning rounded">
                <div class="nav_container">
                    <a href ="acceuilA" class="navbar-brand">Accueil</a>
                    <a href = "apropos" class="navbar-brand">A propos</a>
                    <a href="contact" class="navbar-brand">Contact</a> 
                    <a class="navbar-brand" href="afficherTousProduits" >Produits</a>    
                    <%if (user != null) {
                       if (user.getPrivilege() == 1) {%>

                    <a href="afficherUsersControler" class="navbar-brand">Afficher users</a> 
                    <a href="afficherListOrders" class="navbar-brand">Voir Commandes</a> 
                    <% }

                        }%>
                </div>

                <div class="inline">
                    <% if (user != null) {
                       user = (User) session.getAttribute("user");%>
                    <p class="navbar-brand">Hello, <%=" " + String.valueOf(user.getName())%></p>
                    <a href ="userConnectionControler?disconnect=disconnection" class="navbar-brand">Deconnexion</a>
                    <% } else {%>
                    <a href="enregistrement.jsp" class="navbar-brand">S'enregistrer</a>
                    <a href ="connection.jsp" class="navbar-brand">Connexion</a>
                    <%}%>
                </div>
            </nav>
        </div>



<%if (badPassConfirmation.equals("badPassword")) {%>
<p> Mauvais Mot de Passe</p>
<%}%>

<!--    <form action ="userConnectionControler" method="post">
        <label> Email <input type="text" name="email" class="form-control mr-sm-2"/></label> <br/>
        <label> Mot de Passe <input type="text" name="password"class="form-control mr-sm-2" /></label> <br/>
        <input type="submit" value="Connection"  class="form-control mr-sm-2"/><br/>

        <a href ="enregistrement.jsp" > <h3>Vous n'etes pas enregistré? Clické ici pour le faire.</h3></a>
    </form> -->
<div class="container border border-success rounded" style="width: 40%">
   <form action="userConnectionControler" method="post">
      <h1>CONNECTEZ-VOUS</h1>

      <div class="container">
         <label for="uname"><b>Email</b></label>
         <input type="email" placeholder="Enter Username" style="border-radius: 0 20px" name="email" required>

         <label for="psw"><b>Mot de Passe</b></label>
         <input type="password" placeholder="Enter Password" name="password" style="border-radius: 0 20px" required>

         <input type="submit" value="Connection"  class="form-control mr-sm-2" style="background-color: greenyellow; width: 180px; color: black; margin-left: 30%"/>
         <label>
            <input type="checkbox" checked="checked" name="remember" > Remember me
         </label>
      </div>

      <div class="container" style="width: 300px">
         <button type="button" class="cancelbtn">Cancel</button>
         <span class="psw"><a href="enregistrement.jsp">Register</a></span>
      </div>
   </form>
</div>

<%@include file="WEB-INF/include/footer.jsp" %>


