/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import entities.User;
import actions.ActionUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manager.UserManager;

/**
 *
 * @author fbibeau
 */
@WebServlet(name = "UserConnectionControler", urlPatterns = {"/userConnectionControler"})
public class UserConnectionControler extends HttpServlet {

    public static HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }
    boolean reponse = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String deconnection = request.getParameter("disconnect");
        if (deconnection.equals("disconnection")) {

            HttpSession session = getSession(request);
            request.removeAttribute("user");
            session.removeAttribute("user");
            session.invalidate();
            request.getRequestDispatcher("acceuil").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        request.setAttribute("email", email);
        request.setAttribute("password", password);
        reponse = ActionUser.checkifUserExist(request);
        if (reponse == true) {
            User user = UserManager.getUserByPassAndEmail(email, password);
           if (request.getSession(true) == null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.getRequestDispatcher("acceuil").forward(request, response);
           } else {
               HttpSession session = request.getSession(true);
               session = request.getSession(true);
               session.setAttribute("user", user);
               request.getRequestDispatcher("acceuil").forward(request, response);
            }
        } else {
            String errorWrongPass = "badPassword";
            request.setAttribute("wp", errorWrongPass);
            request.getRequestDispatcher("connection.jsp").forward(request, response);

        }
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
