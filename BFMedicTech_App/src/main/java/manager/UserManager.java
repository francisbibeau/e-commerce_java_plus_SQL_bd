package manager;

import entities.Produit;
import service.ConnexionBD;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fbibeau
 */
public class UserManager {

    private static String getUserByEmailAndPassword = "SELECT * FROM user WHERE email = ? and password= ?";
    private static String queryGetAllUsers = "SELECT * FROM user";

    public static User getUserByPassAndEmail(String email, String password) {
        User user = null;
        try {
            PreparedStatement prePreparedStatement = ConnexionBD.getPs(getUserByEmailAndPassword);
            prePreparedStatement.setString(1, email);
            prePreparedStatement.setString(2, password);

            ResultSet result = prePreparedStatement.executeQuery();

            while (result.next()) {//pour parcourir le resultset
                user = new User();
                user.setId(result.getInt("id"));
                user.setLastName(result.getString("lastName"));
                user.setName(result.getString("firstName"));
                user.setEmail(result.getString("email"));
                user.setPassWord(result.getString("password"));
                user.setShipAddressId(result.getInt("ship_address_id"));
                user.setPrivilege(result.getInt("privilege"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnexionBD.close();
        }

        return user;
    }

    public static ArrayList<User> getAllUsers() {
        ArrayList<User> retour = null;
        PreparedStatement preparedStatement = ConnexionBD.getPs(queryGetAllUsers);

        try {
            ResultSet result = preparedStatement.executeQuery();
            //traitement des resultats
            //verifier si i y a des données dans le resultat
            if (result.isBeforeFirst()) {
                retour = new ArrayList<>();
                while (result.next()) {//pour parcourir le resultset
                    User user = new User();
                    user.setId(result.getInt("id"));
                    user.setName(result.getString("firstName"));
                    user.setLastName(result.getString("lastName"));
                    user.setPassWord(result.getString("password"));
                    user.setHotmail(result.getString("email"));

                    retour.add(user);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        //fermer la connection
        ConnexionBD.close();

        return retour;
    }
//autehentification , si retourne tru le user existe

    public static boolean authenticate(String email, String password) {
        ArrayList<User> users = getAllUsers();
        boolean enregistre = false;
        for (User u : users) {

            if (u.getEmail().equals(email) && u.getPassWord().equals(password)) {
                enregistre = true;

            }
        }
        return enregistre;
    }

    public static boolean authenticateByMail(String email) {
        ArrayList<User> users = getAllUsers();
        boolean enregistre = false;
        for (User u : users) {

            if (u.getEmail().equals(email)) {
                enregistre = true;

            }
        }
        return enregistre;
    }
    private static String queryAddUser = "insert into user (lastName,firstName,email,password,ship_address_id,privilege) values (?,?,?,?,?,?)";

    public static boolean addUser(User user) {
        int nbModDansBd = 0;
        try {
    
            PreparedStatement preparedStatement = ConnexionBD.getPs(queryAddUser);
            preparedStatement.setString(1, user.getLastName());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());

            preparedStatement.setString(4, user.getPassWord());
            preparedStatement.setInt(5, user.getShipAddressId());
            preparedStatement.setInt(6,0);
            nbModDansBd = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.close();
        return nbModDansBd > 0;
    }



}
