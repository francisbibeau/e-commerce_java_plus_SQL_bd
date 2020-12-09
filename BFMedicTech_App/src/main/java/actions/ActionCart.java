/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import entities.Cart;
import entities.Produit;
import entities.ProduitCart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manager.ProduitManager;

/**
 *
 * @author bsawadog
 */
public class ActionCart {
    
    public static Cart getCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        return cart;
    }
    
    public static void addProduitCart(HttpServletRequest request, HttpServletResponse response, String strId, String strQty){     
        
        int qty = 1;
        if(strQty != "")
            qty = Integer.parseInt(strQty);
        
        if(qty>0) {
            int id = Integer.parseInt(strId);
            // Recuperer le panier dans la session
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            
            Produit produit = ProduitManager.getProductById(id);
          
            
            if(produit!=null){
                ProduitCart produitCart = null;
                // Si le produit existe incrementer la quantite
                if(cart.getCart().get(produit.getSerial()) != null){
                    produitCart = cart.getCart().get(produit.getSerial());
                    produitCart.setQty(produitCart.getQty()+qty);
                } else{
                    // si le produit n'existe pas l'ajouter avec qty=1
                    produitCart = new ProduitCart(produit);
                    produitCart.setQty(qty);
                }
                // Ajouter le produit au panier
                cart.addProduit(produitCart.getSerial(), produitCart);
            }
            session.setAttribute("cart", cart);
            
        } else {
            // Message d'erreur pour les quantite invalides
        }       
}
    
public static void removeProduit (String serial, HttpServletRequest request){
    Cart cart = getCart(request);
    cart.removeProduit(serial);
}
public static void clearCart (HttpServletRequest request){
    Cart cart = getCart(request);
    cart.removeCartProducts();
}
    
 public static void updateCart(HttpServletRequest request){
     HttpSession session = request.getSession();
     // Recuperer le panier dans la session
     Cart cart = (Cart) session.getAttribute("cart");
     
     for(ProduitCart produitC : cart.getCart().values()){
         int qty = Integer.parseInt(request.getParameter("qty-" + produitC.getSerial()));
         produitC.setQty(qty);
     }
 }   
    
    
    
}