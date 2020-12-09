/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author bsawadog
 */
public class Cart implements Serializable{
    
    // Attribute
    public HashMap<String, ProduitCart> cart;
    
    // Constructor

    public Cart() {
        cart = new HashMap<String, ProduitCart>();
    }

    public Cart(HashMap<String, ProduitCart> cart) {
        this.cart = cart;
    }
    
    // Methods
    
    public void addProduit(String key, ProduitCart produitC){
        cart.put(key, produitC);
    }
    
    public void removeProduit(String Key){
        cart.remove(Key);
    }
     public void removeCartProducts(){
        cart.clear();
    }
    
    public boolean isEmpty(){
        return cart.size() == 0;
    }
    
    public double generateSubTotal(){
        double subTotal = 0;
        for (ProduitCart produitC : cart.values())
            subTotal += produitC.getPrice() *produitC.getQty();
        return subTotal;
    }
    public double generateShipCost(){
        double shipCost =0;
        for(ProduitCart produitC: cart.values())
            shipCost += 5 * produitC.getQty();
        return shipCost;
    }
    public double generateTotal(){
        return generateSubTotal() + generateShipCost();
    }
    
    // Getter / Setter

    public HashMap<String, ProduitCart> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, ProduitCart> cart) {
        this.cart = cart;
    }
     public int getSize(){
         return cart.size();
     }
}
