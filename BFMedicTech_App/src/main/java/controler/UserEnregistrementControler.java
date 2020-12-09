/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import actions.ActionUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.UserManager;
import entities.User;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fbibeau
 */
@WebServlet(name = "UserEnregistrementControler", urlPatterns = {"/userEnregistrementControler"})
public class UserEnregistrementControler extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("firstName");
        String email = request.getParameter("email");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");
        boolean userExist = UserManager.authenticateByMail(email);
        User user;
        String messageRetourEnregistrement = "nomessage";
        if (userExist == true) {
            messageRetourEnregistrement = "Il exist déjas un utilisateur avec ce mail";
            request.setAttribute("messageRetourEnregistrement", messageRetourEnregistrement);
            request.getRequestDispatcher("enregistrement.jsp").forward(request, response);
        } else {
            if (name == null || lastName == null || password == null || passwordConfirmation == null) {
                messageRetourEnregistrement = "Veuillez Remplir tout les champs s.v.p.";
                request.setAttribute("messageRetourEnregistrement", messageRetourEnregistrement);
                request.getRequestDispatcher("enregistrement.jsp").forward(request, response);
            } else if (password.equals(passwordConfirmation) == false) {
                messageRetourEnregistrement = "Veuillez entrer le meme mot de passe s.v.p.";
                request.setAttribute("messageRetourEnregistrement", messageRetourEnregistrement);
                request.getRequestDispatcher("enregistrement.jsp").forward(request, response);
            } else {
                messageRetourEnregistrement = "Inscription reussi . Bienvenue " + name + " !";
                //2- usermanager enregistrement 1-creation de session 
                request.setAttribute("messageRetourEnregistrement", messageRetourEnregistrement);
                user = new User(name, lastName, email, password, 1, 0);
                request.setAttribute("user", user);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                ActionUser.insertUser(request);
                request.getRequestDispatcher("enregistrement.jsp").forward(request, response);
            }
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
