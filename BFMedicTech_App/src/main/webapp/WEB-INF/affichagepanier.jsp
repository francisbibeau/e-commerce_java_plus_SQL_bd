<%@page import="entities.ProduitCart"%>
<%@page import="entities.Produit"%>
<%@page import="java.text.DecimalFormat"%>

<%
    DecimalFormat df = new DecimalFormat("###0.00");
    // Recuperation du panier de la session
    Cart cart = (Cart) session.getAttribute("cart");
    String viderPanier = "ok";
%>

<%@include file="include/header.jsp" %>

<div class="container">
   <div class="border border-success">   
      <%if (cart != null && !cart.isEmpty()) { %>
      <h1 class="display-4" style="text-align: center; margin-top: 25px; margin-bottom: 25px"> Produits du Panier</h1>
      <div class="row">
         <div class="col-sm-12 col-md-10 col-md-offset-1" style="margin: auto">
            <form name="cart" action="#" method="post">
               <table class="table table-hover">
                  <thead>
                     <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                     </tr>
                  </thead>
                  <tbody>
                     <%
                         int nombreProduit = 1;
                         for (ProduitCart produitC : cart.getCart().values()) {
                     %>

                     <tr>
                        <td class="col-sm-7 col-md-6">
                           <div class="media">
                              <a class="thumbnail pull-left" href="#"> <img class="media-object" src="images/<%=produitC.getImage()%>" style="width: 72px; height: 72px;"> </a>
                              <div class="media-body">
                                 <h4 class="media-heading"><a href="detailsProduit?id=<%=produitC.getId()%>"><%=produitC.getName()%></a></h4>
                                 <h5 class="media-heading"> En stock: <span id="stock-qty-<%=produitC.getSerial()%>"><%=produitC.getStock()%></span></h5>
                              </div>
                           </div>
                        </td>
                        <td class="col-sm-2 col-md-2" style="text-align: center">
                           <form>
                              <!-- <input type="submit" value="+">-->
                              <input type="number" min="1" max="<%=produitC.getStock()%>" name ="<%="qty-" + produitC.getSerial()%>" class="form-control qty-txt" value="<%=nombreProduit%>" id="<%="pq-" + produitC.getSerial()%>">
                              <!-- <input type="submit" value="-"> -->
                           </form>
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong  id="<%="pp-" + produitC.getSerial()%>"><%=df.format(produitC.getPrice())%>$</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong  id="<%="pt-" + produitC.getSerial()%>"><%=df.format(produitC.getPrice() * nombreProduit)%>$</strong></td>
                        <td class="col-sm-1 col-md-1">                
                           <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">Supprimer</button>
                                 
                                 </td>
                                 </tr>
                                 <!--Modal pour supprimer un produit -->
                                 <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <form action="affichageCart" method="post">    
                                       <div class="modal-dialog" role="document">
                                          <div class="modal-content">
                                             <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Attention </h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                   <span aria-hidden="true">&times;</span>
                                                </button>
                                             </div>
                                             <div class="modal-body">
                                                Voulez-vous vraiment supprimer <%=produitC.getName()%> ?
                                                <input type="hidden" name ="serial" value="<%=produitC.getSerial()%>">
                                             </div>
                                             <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary btn btn-success" data-dismiss="modal"><input type="submit" class="btn btn-success" value="Annuler"></button>
                                                <button type="button" class="btn btn-primary btn btn-danger"><input type="submit" class="btn btn-danger" value="Supprimer"></button>
                                             </div>
                                          </div>
                                       </div>
                                    </form>
                                 </div>
                                 <%
                                     }
                                 %>

                                 <tr>
                                    <td>   </td>
                                    <td>   </td>
                                    <td>   </td>
                                    <td><h5>Sous-total</h5></td>
                                    <td class="text-right"><h5><strong  id="cart-subtotal"><%=df.format(cart.generateSubTotal())%>$</strong></h5></td>
                                 </tr>
                                 <tr>
                                    <td>   </td>
                                    <td>   </td>
                                    <td>   </td>
                                    <td><h5>Livraison estimée</h5></td>
                                    <td class="text-right"><h5><strong  id="cart-shipping"><%=df.format(cart.generateShipCost())%>$</strong></h5></td>
                                 </tr>
                                 <tr>
                                    <td>   </td>
                                    <td>   </td>
                                    <td>   </td>
                                    <td><h3>Total</h3></td>
                                    <td class="text-right"><h3><strong  id="cart-total"><%=df.format(cart.generateTotal())%>$</strong></h3></td>
                                 </tr>
                                 <tr>
                                    <td>   </td>
                                    <td>   </td>

                                    <td>   </td>
                                    <td>

      
                                       <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal2">Vider</button>
                                    </td>
                                    <td>

                                       <form action="commande" method="post">                       
                                          <input type="submit" value="Commander" class="btn btn-success">
                                       </form>
                                    </td>
                                 </tr>



                                 </tbody>
                                 </table>

                                 </form>
                                 </div>
                                 </div>
                                          <!--Modal pour supprimer un produit -->
                                 <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <form action="affichageCart" method="post">    
                                       <div class="modal-dialog" role="document">
                                          <div class="modal-content">
                                             <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Attention </h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                   <span aria-hidden="true">&times;</span>
                                                </button>
                                             </div>
                                             <div class="modal-body">
                                                Voulez-vous vraiment vider le panier ?
                                               <input type="hidden" value="<%=cart%>" name="cartAVider" >
                                             </div>
                                             <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary btn btn-danger" data-dismiss="modal"><input type="button" class="btn btn-danger" value="Annuler"></button>
                                                <button type="button" class="btn btn-primary btn btn-success"><input type="submit" class="btn btn-success" value="Vider"></button>
                                             </div>
                                          </div>
                                       </div>
                                    </form>
                                 </div>
                                 <%
                                 } else {
                                 %>

                                 <h1 class="display-5" style="text-align: center; color: red; height: 300px; padding-top: 50px">
                                    Votre panier est vide
                                 </h1>

                                 <%
                                     }
                                 %>

                                 </div>
                                 </div>





                                 <%@include file="include/footer.jsp" %>