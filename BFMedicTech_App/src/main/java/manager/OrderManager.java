/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entities.User;
import entities.Cart;
import entities.Order;
import entities.Produit;
import entities.ProduitCart;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ConnexionBD;

/**
 *
 * @author bsawadog
 */
public class OrderManager {

    public static int add(User user, Cart cart) throws ClassNotFoundException {
        int orderId = 0;
        try {

            // Partie 1
            // Creer une commande et récupere le ID
            String query = "INSERT INTO `order` (user_id, date) VALUES (?, now())";
            PreparedStatement ps = ConnexionBD.getPs(query, 1);
            ps.setInt(1, user.getId());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
                System.out.println(orderId);
            }

            // Partie 2
            // Ajoute tout les items de la commande dans la table order_info
            for (ProduitCart produit : cart.getCart().values()) {

                query = "INSERT INTO order_info (order_id, product_id, qty, price) VALUES (?, ?, ?, ?)";
                ps = ConnexionBD.getPs(query);

                ps.setInt(1, orderId);
                ps.setInt(2, produit.getId());
                ps.setInt(3, produit.getStock());
                ps.setDouble(4, produit.getPrice());

                ps.executeUpdate();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnexionBD.close();
        }

        return orderId;

    }
    //String queryGetAllOrders = "select  `order`.date, `order`.id from `order` INNER JOIN user ON `order`.user_id = user.id;";

    public static ArrayList<Order> getAllOrders() throws ClassNotFoundException {
        ArrayList<Order> retour = null;
        try {
            String queryGetAllOrders = "select  user.id, `order`.date, user.firstName, user.lastName, `order`.id from `order` INNER JOIN user ON `order`.user_id = user.id";
            PreparedStatement preparedStatement = ConnexionBD.getPs(queryGetAllOrders);
            ResultSet result = preparedStatement.executeQuery();
            //traitement des resultats
            //verifier si i y a des données dans le resultat
            if (result.isBeforeFirst()) {
                retour = new ArrayList<>();
                while (result.next()) {
                    Order order = new Order();
                     order.setId(result.getInt("user.id"));
                     order.setDate(result.getString("order.date"));
                     order.setFirstName(result.getString("user.firstName"));
                     order.setLastName(result.getString("user.lastName"));
                     order.setUserId(result.getInt("order.id"));
                     retour.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //fermer la connection
        ConnexionBD.close();

        return retour;
    }

    public static void deleteOrder(int id) {

        try {
            String queryDeleteOrder = "delete from `order` where id=?";
            PreparedStatement ps = ConnexionBD.getPs(queryDeleteOrder);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConnexionBD.close();
    }

}
