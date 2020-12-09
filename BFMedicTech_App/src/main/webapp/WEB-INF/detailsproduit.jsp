
<%@page import="entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Produit"%>
<%
    Produit produit = (Produit) request.getAttribute("produit");
    ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
%>


<%@include file="include/header.jsp" %>

<div class="container">
   <%@include file="include/navCategoriesProduits.jsp" %>
   <%@include file="include/detailsItem.jsp" %>
</div>

<%@include file="include/footer.jsp" %>