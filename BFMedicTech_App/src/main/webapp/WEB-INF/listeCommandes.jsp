
<%@page import="entities.Order"%>
<%@page import="entities.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Category"%>

<%
    ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
    ArrayList<Produit> produits = (ArrayList<Produit>) request.getAttribute("produits");
    ArrayList<Produit> categoryProduits = (ArrayList<Produit>) request.getAttribute("produitsCategorie");
    ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");

%>

<%@include file="include/header.jsp" %>

<div class="container">
    <%@include file="include/navCategoriesProduits.jsp" %>
</div>
<section>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">



                    <div class="panel-body">
                        <div class="table-responsive">

                            <table class="table table-condensed">

                                <thead>
                                    <tr>
                                        <td class="text-center"><strong>Nom du client</strong></td>
                                        <td class="text-center"><strong>Date de commande</strong></td>
                                        <td class="text-center"><strong>Actions</strong></td>
                                        <!--<td class="text-right"><strong>Total</strong></td>-->
                                    </tr>
                                </thead>
                                <div class="panel-heading">
                                    <h1 class="display-4"> Liste des commandes clients</h1>
                                </div>
                                <%
                                    if (orders != null) {
                                        for (Order order : orders) {

                                %>
                                <tr>

                                    <td class="text-center"><label><%=order.getFirstName()%></label></td>
                                    <td class="text-center"><label><%=order.getDate()%></label></td>
                                    <td class="text-center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                            Delete</button><button type="button" class="btn btn-primary" data-toggle="modal" style="margin-left: 10px">
                                            isShipped</button></td>						
                                </tr>
                                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Attention <%=order.getFirstName()%></h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                Voulez-vous vraiment supprimer cette commande ?
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary btn btn-danger" data-dismiss="modal">Annuler</button>
                                                <button type="button" class="btn btn-primary btn btn-success"><a href="deleteOrder?idOrder=<%=order.getUserId()%>">Confirmer</a></button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%
                                    }
                                } else {
                                %>
                                <h1 class="display-3" style="color: red; text-align: center; height: 250px">Aucune commande a afficher</h1>
                                <%
                                    }
                                %>
                            </table>


                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <%@include file="include/footer.jsp" %>
