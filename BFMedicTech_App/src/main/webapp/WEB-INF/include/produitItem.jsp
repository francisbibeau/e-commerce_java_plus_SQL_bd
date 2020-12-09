<figure class="figConteneur">
   <a href="detailsProduit?id=<%=produit.getId()%>"><img src="images/<%=produit.getImage()%>" alt="<%=produit.getImage()%>"></a>
   <figcaption>
      <span style="color:gray;font-size: 15px">$<%=produit.getPrice()%></span>
      <span><%=produit.getName()%></span>
      <form method="post" action="cartControler">
         <input type="hidden" value="<%=produit.getId()%>" name="idProductList">
         <input type="hidden" value="<%=produit.getStock()%>" name="qtyProductList">
         <input type="submit" id="addCartButton" value="+">
    </form>
</figure>