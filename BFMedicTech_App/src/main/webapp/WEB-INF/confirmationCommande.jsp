<%-- 
    Document   : confirmationCommande
    Created on : May 21, 2020, 12:25:59 AM
    Author     : bsawadog
--%>

<%@page import="entities.Cart"%>
<%
        Cart cart = (Cart) session.getAttribute("cart");   
        if(cart!=null){
         cart.removeCartProducts();
        }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>JSP Page</title>
   </head>
   <body>
            <h1>Felicitation, Votre commande a ete enregistree !</h1>
            <a href="http://localhost:8080/BFMedicTech_App/acceuilA"><button>Continuer a magasiner</button></a>
         </div>
      </div>
   </body>
</html>
