/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.ArrayList;
import entities.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bsawadog
 */
import service.ConnexionBD;

public class ProduitManager {

    // Toutes les requetes
    private static String queryGetProductById = "SELECT * FROM product WHERE id = ?";
    private static String queryGetProductsByCategory = "SELECT * FROM product WHERE category=?";
    private static String queryProduitsEnVedette = "SELECT * FROM product where id IN (SELECT product FROM featured_product)";
    private static String queryInsertProduit = "INSERT into product (nom, prix) values(?,?)";
    private static String queryGetAll = "select * from product";

    
    // recuperation de tous les produits de la bd
    public static ArrayList<Produit> getAllProducts() {
        ArrayList<Produit> retour = null;
        PreparedStatement preparedStatement = ConnexionBD.getPs(queryGetAll);
        try {
            ResultSet result = preparedStatement.executeQuery();
            //traitement des resultats
            //verifier si i y a des données dans le resultat
            if (result.isBeforeFirst()) {
                retour = new ArrayList<>();
                while (result.next()) {//pour parcourir le resultset
                    Produit produit = new Produit();
                    produit.setId(result.getInt("id"));
                    produit.setCategory(result.getInt("category"));
                    produit.setName(result.getString("name"));
                    produit.setDescription(result.getString("description"));
                    produit.setPrice(result.getDouble("price"));
                    produit.setSerial(result.getString("serialNumber"));
                    produit.setImage(result.getString("imgName"));
                    produit.setStock(result.getInt("stockQty"));
                    produit.setIsActive(result.getBoolean("isActive"));
                    retour.add(produit);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        //fermer la connection
        ConnexionBD.close();

        return retour;
    }

    
    // recuperation des produits d'une categorie
    public static ArrayList<Produit> getProductsByCategory(int category) {
        ArrayList<Produit> produits = new ArrayList();
        try {
            PreparedStatement ps;
            ResultSet rs;
            String queryGetAllProducts = "SELECT * FROM product";
            if (category == 1) {
                ps = ConnexionBD.getPs(queryGetAllProducts);
            } else {
                ps = ConnexionBD.getPs(queryGetProductsByCategory);
                ps.setInt(1, category);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                produits.add(getProduitFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnexionBD.close();
        }
        return produits;
    }

    
    public static ArrayList<Produit> getProductsByIdCategorie(int idCategory) {
        ArrayList<Produit> produits = null;
        String queryGetByIdCategorie = "select * from product where category = ?";
        try {
            PreparedStatement ps = ConnexionBD.getPs(queryGetByIdCategorie);
            ps.setInt(1, idCategory);
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                produits = new ArrayList<>();
                while (rs.next()) {
                    produits.add(getProduitFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnexionBD.close();
        }
        return produits;
    }

    
    // Recuperation des produits en vedette   
    public static ArrayList<Produit> produitsEnVedette() {
        ArrayList<Produit> produits = null;
        try {
            PreparedStatement ps = ConnexionBD.getPs(queryProduitsEnVedette);
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                produits = new ArrayList<>();
                while (rs.next()) {
                    produits.add(getProduitFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnexionBD.close();
        }
        return produits;
    }

    
    // recuperation d'un produit par son id
    public static Produit getProductById(int id) {
        Produit retour = null;
        try {
            PreparedStatement ps = ConnexionBD.getPs(queryGetProductById);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                retour = new Produit();
                while (rs.next()) {
                    retour = getProduitFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnexionBD.close();
        }
        return retour;
    }

    
    public static ArrayList<Produit> searchProduct(String mot) {
        ArrayList<Produit> retour = null;
        try {
            String queryGetItemsBySearch = "SELECT * FROM product WHERE upper(name) LIKE upper(?)";
            ResultSet rs;
            PreparedStatement ps = ConnexionBD.getPs(queryGetItemsBySearch);
            ps.setString(1, mot);
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                retour = new ArrayList<>();
                while (rs.next()) {
                    retour.add(getProduitFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnexionBD.close();
        }
        return retour;
    }

    
    public static Produit getProduitFromResultSet(ResultSet rs) {
        Produit produit = new Produit();
        try {
            produit.setId(rs.getInt("id"));
            produit.setCategory(rs.getInt("category"));
            produit.setName(rs.getString("name"));
            produit.setDescription(rs.getString("description"));
            produit.setPrice(rs.getDouble("price"));
            produit.setSerial(rs.getString("serialNumber"));
            produit.setImage(rs.getString("imgName"));
            produit.setStock(rs.getInt("stockQty"));
            produit.setIsActive(rs.getBoolean("isActive"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit;
    }

}
