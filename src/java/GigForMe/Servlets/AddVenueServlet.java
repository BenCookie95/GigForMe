/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Servlets;

import GigForMe.DAO.venueDAO;
import GigForMe.Manager.UserManager;
import GigForMe.Manager.VenueManager;
import GigForMe.Model.User;
import GigForMe.Model.UserError;
import GigForMe.Model.Venue;
import static GigForMe.Utils.Constants.SESSION_ADMIN;
import GigForMe.Utils.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.TRUE;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.util.NumberUtils;


/**
 *
 * @author Ben
 */

public class AddVenueServlet extends HttpServlet {

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
        String venueName = request.getParameter("venuename");
        String capacity = request.getParameter("capacity");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        UserError er = new UserError();
        
        if (StringUtils.isStringEmpty(venueName) || StringUtils.isStringEmpty(capacity) || StringUtils.isStringEmpty(latitude) || StringUtils.isStringEmpty(longitude)) {

            request.setAttribute("error", er.getBlankField());
            request.getRequestDispatcher("add_venue.jsp").forward(request, response);

        } else {
            if (StringUtils.isNumeric(capacity)) {
                int cap = Integer.parseInt(capacity);
                venueDAO vm = new venueDAO();
                try {
                    Venue venue = new Venue(venueName, cap, latitude, longitude);
                    vm.insertVenue(venue);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AddVenueServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                //save message in session
                request.getSession(true).setAttribute("message", "yes");
                response.sendRedirect("VenueManagement");
                
                
                
            }
            else{
                request.setAttribute("error", er.getCapError());
                request.getRequestDispatcher("modify_venue.jsp").forward(request, response);
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
