/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Servlets;

import GigForMe.DAO.userDAO;
import GigForMe.DAO.venueDAO;
import GigForMe.Database.DBManager;
import GigForMe.Database.SetupDb;
import GigForMe.Manager.UserManager;
import GigForMe.Model.User;
import GigForMe.Model.UserError;
import GigForMe.Model.Venue;
import GigForMe.Utils.Constants;
import GigForMe.Utils.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.TRUE;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Ben
 */

public class LoginServlet extends HttpServlet implements Constants {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String Username = request.getParameter("username");
        String password = request.getParameter("password");
        UserError er = new UserError();

        if (StringUtils.isStringEmpty(Username) || StringUtils.isStringEmpty(password)) {
            request.setAttribute("error", er.getBlankField());
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {
            System.out.println(Username + password);
            UserManager uMgr = new UserManager();
            
                User user = uMgr.loginUser(Username, password);
            
                if (user == null) {
                    request.setAttribute("error", er.getIncorrectLoginDetail());
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {

                    if (user.getIsAdmin().equals("YES")) {
                        Cookie loginCookie = new Cookie("ADMIN", Username);
                        //setting cookie to expiry in 30 mins
                        loginCookie.setMaxAge(30*60);
                        response.addCookie(loginCookie);
                        
                        
                        request.getSession(true).setAttribute(SESSION_ADMIN, user);
                       

                        
                        response.sendRedirect("index.jsp");



                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                        rd.forward(request, response);
                    }
                }
            
            
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
