/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Servlets;

import GigForMe.DAO.gigDAO;
import GigForMe.Model.Gig;
import GigForMe.Utils.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ben
 */
@WebServlet(name = "EditGig", urlPatterns = {"/Admin/EditGig"})
public class EditGig extends HttpServlet {

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
        String gigID = request.getParameter("g");
        int gID = Integer.parseInt(gigID);
        gigDAO gDAO = new gigDAO();
        Gig theGig;
        try {
            theGig = gDAO.getTheGig(gID);
            request.getSession(true).setAttribute(Constants.SESSION_KEY_GIGEDIT, theGig);
            theGig = null;
            request.getRequestDispatcher("edit_gig.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditGig.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("This is a test " + theUser.getIsAdmin());
        
        //response.sendRedirect("modify_profile.jsp?u="+uID);
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
