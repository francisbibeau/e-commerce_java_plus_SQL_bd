package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fbibeau
 */
public class ConnexionBD {

    private static String urlConnection = "jdbc:mariadb://localhost:3310/bfmedictechdb";
    private static String login = "root";
    private static String pwd = "abc123...";
    private static Connection connection;

    public static PreparedStatement getPs(String query) {
        PreparedStatement retour = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(urlConnection, login, pwd);
            retour = connection.prepareStatement(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }

    public static PreparedStatement getPs(String query, int id) throws ClassNotFoundException {
        PreparedStatement retour = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(urlConnection, login, pwd);
            if (id == 1) {
                retour = connection.prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retour;
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
