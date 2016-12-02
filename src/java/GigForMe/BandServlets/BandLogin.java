/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.BandServlets;

import GigForMe.Manager.BandManager;
import GigForMe.Manager.GenUserManager;
import GigForMe.Model.Band;
import GigForMe.Model.User;
import GigForMe.Model.UserError;
import static GigForMe.Utils.Constants.SESSION_BAND;
import GigForMe.Utils.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ben
 */
@WebServlet(name = "BandLogin", urlPatterns = {"/BandLogin"})
public class BandLogin extends HttpServlet {

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
            request.getRequestDispatcher("BandLogin.jsp").forward(request, response);

        }else{
             
            BandManager bMgr = new BandManager();
            Band band = bMgr.loginBand(username, password);
            
            if (band == null) {
                    request.setAttribute("error", er.getIncorrectLoginDetail());
                    request.getRequestDispatcher("BandLogin.jsp").forward(request, response);
                } else {


                        request.getSession(true).setAttribute(SESSION_BAND, band);
                       

                        
                        response.sendRedirect("Gigs");

 
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
