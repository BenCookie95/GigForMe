/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.UserServlets;

import GigForMe.DAO.gigDAO;
import GigForMe.Model.Gig;
import GigForMe.Model.User;
import GigForMe.Utils.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ben
 */
@WebServlet(name = "ConfirmedGigsServlet", urlPatterns = {"/ConfirmedGigs"})
public class ConfirmedGigsServlet extends HttpServlet {

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
        gigDAO gDAO = new gigDAO();
        HttpSession session = request.getSession(false);
        
        if (session.getAttribute("USER") == null) {
            Vector<Gig> allGigsVect = gDAO.getAllConfGigs(0);

            request.getSession(true).setAttribute(Constants.SESSION_KEY_ALL_CONFIRMEDGIGS, allGigsVect);
            
        }else{
            User getUser = (User) session.getAttribute("USER");
            Vector<Gig> allGigsVect = gDAO.getAllConfGigs(getUser.getUserID());

            request.getSession(true).setAttribute(Constants.SESSION_KEY_ALL_CONFIRMEDGIGS, allGigsVect);
        }
        //response.sendRedirect("modify_users.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("confirmed_gigs.jsp");
            rd.forward(request, response);
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
