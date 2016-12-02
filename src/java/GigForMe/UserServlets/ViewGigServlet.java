/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.UserServlets;

import GigForMe.DAO.CommentDAO;
import GigForMe.DAO.gigDAO;
import GigForMe.Model.Comment;
import GigForMe.Model.Gig;
import GigForMe.Model.User;
import GigForMe.Utils.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ViewGigServlet", urlPatterns = {"/ViewGig"})
public class ViewGigServlet extends HttpServlet {

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
        String gigid = request.getParameter("g");
        gigDAO gDAO = new gigDAO();
        CommentDAO cDAO = new CommentDAO();
        int GigID = Integer.parseInt(gigid);
        HttpSession session = request.getSession(false);
        
        try {
            
            if (null == session.getAttribute("USER")) {
            
                Gig thegig = gDAO.getGig(GigID, 0);
                Vector<Comment> gigComments = cDAO.getAllComments(GigID);
                request.getSession(true).setAttribute(Constants.SESSION_KEY_GIG, thegig);
                request.getSession(true).setAttribute(Constants.SESSION_KEY_COMMENT, gigComments);
                thegig = null;
                gigComments = null;
                RequestDispatcher rd = request.getRequestDispatcher("Gig_Page.jsp");
                rd.forward(request, response);
            }else{
                User getUser = (User) session.getAttribute("USER");
                Gig thegig = gDAO.getGig(GigID, getUser.getUserID());
                Vector<Comment> gigComments = cDAO.getAllComments(GigID);
                request.getSession(true).setAttribute(Constants.SESSION_KEY_GIG, thegig);
                request.getSession(true).setAttribute(Constants.SESSION_KEY_COMMENT, gigComments);
                thegig = null;
                gigComments = null;
                RequestDispatcher rd = request.getRequestDispatcher("Gig_Page.jsp");
                rd.forward(request, response);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewGigServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
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
