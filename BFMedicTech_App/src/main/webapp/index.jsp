<%-- 
    Document   : index
    Created on : May 12, 2020, 10:37:33 AM
    Author     : bsawadog
--%>
<%@page import="entities.Produit"%>
<%@page import="entities.Category"%>
<%@page import="java.util.ArrayList"%>


<%
    ArrayList<Produit> produitsEnVedette = (ArrayList<Produit>) request.getAttribute("produitsVedette");
    ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
%>

<%@include file="WEB-INF/include/header.jsp" %>
<div class="carouselCategorie">
   <%@include file="WEB-INF/include/carroussel.jsp" %>
</div>

<div>
   <h1 class="display-4">Produits en vedette</h1>
</div>
<section>
   <div class="produits">
      <%
          for (Produit produit : produitsEnVedette) {
      %>
      <figure class="figConteneur">
         <a href="detailsProduit?id=<%=produit.getId()%>"><img src="images/<%=produit.getImage()%>" alt="<%=produit.getImage()%>"></a>
         <figcaption>
            <span style="color:gray;font-size: 15px">$<%=produit.getPrice()%></span>
            <span><%=produit.getName()%></span>
            <form method="post" action="cartControler">
               <input type="hidden" value="<%=produit.getId()%>" name="idProductVedette">
               <input type="hidden" value="<%=produit.getStock()%>" name="qtyProductVedette">
               <input type="submit" id="addCartButton" value="+">
            </form>
      </figure>
      <%}%>
   </div>
</section>

<%@include file="WEB-INF/include/footer.jsp" %>
