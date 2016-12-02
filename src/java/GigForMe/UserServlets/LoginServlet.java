/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.UserServlets;

import GigForMe.Manager.GenUserManager;
import GigForMe.Manager.UserManager;
import GigForMe.Model.User;
import GigForMe.Model.UserError;
import static GigForMe.Utils.Constants.SESSION_ADMIN;
import static GigForMe.Utils.Constants.SESSION_GENUSER;
import GigForMe.Utils.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UserLoginServlet", urlPatterns = {"/UserLogin"})
public class LoginServlet extends HttpServlet {

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        
        UserError er = new UserError();
        if (StringUtils.isStringEmpty(username) || StringUtils.isStringEmpty(password)) {
            request.setAttribute("error", er.getBlankField());
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }else{
             
            GenUserManager uMgr = new GenUserManager();
            User user = uMgr.loginUser(username, password);
            
            if (user == null) {
                    request.setAttribute("error", er.getIncorrectLoginDetail());
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {

                    if (user.getIsBanned().equals("NO")) {
                        //Cookie loginCookie = new Cookie("GENUSER", user.getUsername());
//                        if (rememberMe == null) {
//                            loginCookie.setMaxAge(30*60);
//                            response.addCookie(loginCookie);
//                        }else{
//                            loginCookie.setMaxAge(30*60*3600);
//                            response.addCookie(loginCookie);
//                        }
                        request.getSession(true).setAttribute(SESSION_GENUSER, user);
                       

                        
                        response.sendRedirect("Gigs");



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
