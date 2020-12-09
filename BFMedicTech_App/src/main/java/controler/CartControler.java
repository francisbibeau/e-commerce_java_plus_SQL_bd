/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;
import entities.Cart;
import actions.ActionCart;
import actions.ActionCategory;
import actions.ActionProduit;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bsawadog
 */
public class CartControler extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ActionCategory.getAllCategories(request, response);
        ActionProduit.getAllProducts(request, response);
        ActionProduit.getFeaturedProducts(request, response);
       
      
        // Si la requette provient de la page details produit
        String idDetails = request.getParameter("id");
        String qtyDetails = request.getParameter("qty");
        if(idDetails!=null && qtyDetails!=null){
        ActionCart.addProduitCart(request, response, idDetails, qtyDetails);
        ActionProduit.getProductById(Integer.parseInt(idDetails), request, response);
        request.getRequestDispatcher("WEB-INF/detailsproduit.jsp").forward(request, response);
        }
        
        // Si la requette provient de l'acceuil produit en vedette
        String idVedette = request.getParameter("idProductVedette");
        String qtyVedette = request.getParameter("qtyProductVedette");
        if(idVedette!=null && qtyVedette!=null){
        ActionCart.addProduitCart(request, response, idVedette, qtyVedette);
         request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        // Si la requette provient de la page liste des produits
        String idProductList = request.getParameter("idProductList");
        String qtyProductList = request.getParameter("qtyProductList");
        if(idProductList!=null && qtyProductList!=null){
        ActionCart.addProduitCart(request, response, idProductList, qtyProductList);
        request.getRequestDispatcher("WEB-INF/produits.jsp").forward(request, response);
        }
        
 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
