/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import entities.User;
import manager.UserManager;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fbibeau
 */
public class ActionUser {

    public static void insertUser(HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        System.out.println(user.getEmail());

        System.out.println(UserManager.addUser(user));

    }

    public static boolean checkifUserExist(HttpServletRequest request) {
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        return UserManager.authenticate(email, password);
    }

    public static void getAllUsers(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", UserManager.getAllUsers());

    }
}
