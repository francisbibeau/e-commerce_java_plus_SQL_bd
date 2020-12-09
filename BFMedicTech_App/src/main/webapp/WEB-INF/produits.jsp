
<%@page import="entities.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Category"%>

<%
    ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
    ArrayList<Produit> produits = (ArrayList<Produit>) request.getAttribute("produits");
    ArrayList<Produit> categoryProduits = (ArrayList<Produit>) request.getAttribute("produitsCategorie");
    ArrayList<Produit> produitsTrouve = (ArrayList<Produit>) request.getAttribute("search");

%>

<%@include file="include/header.jsp" %>

<div class="container">
   <%@include file="include/navCategoriesProduits.jsp" %>
</div>
<section>



   <div class="produits">
      <% if (produits != null && categoryProduits == null) {

              for (Produit produit : produits) {
                  %>
      <%@include file="include/produitItem.jsp" %>
      <%}
      } else if (produits == null && categoryProduits != null) {

          for (Produit produit : categoryProduits) {
              %>
      <%@include file="include/produitItem.jsp" %>
      <%}
      } else if (produitsTrouve != null) {

          for (Produit produit : produitsTrouve) {
      %>
     <%@include file="include/detailsProduitBySearch.jsp" %>
      <%}
          } %>
   </div>
   <%if (produitsTrouve == null && categoryProduits == null && produits == null) { %>
   <br><br><br>
   <h1 class="display-3" style="text-align: center; color:red"> Aucun produit a afficher </h1>
   <br><br><br>
   <%}%>



</section>

<%@include file="include/footer.jsp" %>
