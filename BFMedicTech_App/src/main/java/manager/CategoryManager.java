/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;
import entities.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import service.ConnexionBD;

/**
 *
 * @author bsawadog
 */
public class CategoryManager {
     
    
    public static ArrayList<Category> getAllCategories () {
        ArrayList<Category> categories = new ArrayList<Category>();
        String query = "select * from category";
         try {
            PreparedStatement ps = ConnexionBD.getPs(query);
	    ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                categories.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));   
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnexionBD.close();
        }  
        return categories;
    }
    
     
    
}
