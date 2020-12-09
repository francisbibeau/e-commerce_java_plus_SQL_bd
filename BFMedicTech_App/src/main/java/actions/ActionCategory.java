/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.CategoryManager;

/**
 *
 * @author bsawadog
 */
public class ActionCategory {
    public static void getAllCategories(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("categories", CategoryManager.getAllCategories());
        
    }
    
}
