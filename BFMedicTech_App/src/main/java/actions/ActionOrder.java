/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.OrderManager;

/**
 *
 * @author bsawadog
 */
public class ActionOrder {
    
     public static void getAllOrder(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException{
        request.setAttribute("orders", OrderManager.getAllOrders());   
    }
     public static void deleteOrder(int id, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException{
        OrderManager.deleteOrder(id);
    }
    
}
