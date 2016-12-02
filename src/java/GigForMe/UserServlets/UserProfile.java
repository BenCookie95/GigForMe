/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.UserServlets;

import GigForMe.DAO.bandDAO;
import GigForMe.DAO.gigDAO;
import GigForMe.DAO.userDAO;
import GigForMe.Model.Band;
import GigForMe.Model.Gig;
import GigForMe.Model.User;
import GigForMe.Utils.Constants;
import GigForMe.Utils.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ben
 */
@WebServlet(name = "UserProfile", urlPatterns = {"/UserProfile"})
public class UserProfile extends HttpServlet {

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
        String userID = request.getParameter("u");
        String bandID = request.getParameter("b");
        
        if(StringUtils.isStringEmpty(userID)){
            int bID = Integer.parseInt(bandID);
            bandDAO bDAO = new bandDAO();
            Band theBand = bDAO.getBand(bID);
            request.getSession(true).setAttribute(Constants.SESSION_KEY_VIEWUSER, theBand);
            theBand = null;
            gigDAO gDAO = new gigDAO();
            Vector<Gig> allUserGigs = gDAO.getAllBandGigs(bID);

            request.getSession(true).setAttribute("GIGSUSER", allUserGigs);
            request.getRequestDispatcher("BandProfile.jsp").forward(request, response);
        }else if(StringUtils.isStringEmpty(bandID)){
            int uID = Integer.parseInt(userID);
            userDAO uDAO = new userDAO();
            User theUser = uDAO.getUser(uID);
            request.getSession(true).setAttribute(Constants.SESSION_KEY_VIEWUSER, theUser);
            theUser = null;
            gigDAO gDAO = new gigDAO();
            Vector<Gig> allUserGigs = gDAO.getAllUserGigs(uID);

            request.getSession(true).setAttribute("GIGSUSER", allUserGigs);
            request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
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
