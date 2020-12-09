/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.ProduitManager;

/**
 *
 * @author bsawadog
 */
public class ActionProduit {
    
    public static void getAllProducts(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("produits", ProduitManager.getAllProducts());
    }
    
    public static void getProductById(int id, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("produit", ProduitManager.getProductById(id));
    }
    
    public static void getProductsByCategory(int idCategory, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("produitsCategorie", ProduitManager.getProductsByIdCategorie(idCategory));
    }
    
    public static void getFeaturedProducts(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("produitsVedette", ProduitManager.produitsEnVedette());
    }
     public static void getProductBySearch(String mot, HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("search", ProduitManager.searchProduct(mot));
    }
    
    
}
