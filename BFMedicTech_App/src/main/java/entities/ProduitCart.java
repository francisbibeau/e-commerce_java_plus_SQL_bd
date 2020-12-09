/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author bsawadog
 */
public class ProduitCart extends Produit implements Serializable {
    public int qty;

    public ProduitCart() {
    }

    public ProduitCart(Produit produit) {
        setId(produit.getId());
        setCategory(produit.getCategory());
        setStock(produit.getStock());
        setName(produit.getName());
        setDescription(produit.getDescription());
        setSerial(produit.getSerial());
        setImage(produit.getImage());
        setPrice(produit.getPrice());
        setIsActive(produit.isIsActive());
        
        qty = 0;
    }
    
    // Methode
    public boolean inStock(){
        return super.getStock() >= qty;
    }
    
    // Getter / Setter
    public int getQty(){
        return qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
}
