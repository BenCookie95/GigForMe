/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Servlets;

import GigForMe.DAO.bandDAO;
import GigForMe.Model.UserError;
import GigForMe.Utils.StringUtils;
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
@WebServlet(name = "UpdateBand", urlPatterns = {"/Admin/UpdateBand"})
public class UpdateBandProfile extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        String bandid = request.getParameter("bandid");
        String bio = request.getParameter("userpost");
        String changePassword = request.getParameter("changePassword");
        String password = request.getParameter("password");
        UserError er = new UserError();
        if (StringUtils.isStringEmpty(bandid) || StringUtils.isStringEmpty(bio)) {
            request.setAttribute("error", er.getBlankField());
            request.getRequestDispatcher("modify_band_profile.jsp").forward(request, response);
        }else if(StringUtils.isStringEmpty(changePassword)){
            int bandID = Integer.parseInt(bandid);
            bandDAO bd = new bandDAO();
            password = bd.getBandPassword(bandID);
            bd.updateTheBand(bandID, bio, password);
            response.sendRedirect("BandManagement");
        }else{
            bandDAO bd = new bandDAO();
            int bandID = Integer.parseInt(bandid);
            bd.updateTheBand(bandID, bio, password);
            response.sendRedirect("BandManagement");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBandProfile.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBandProfile.class.getName()).log(Level.SEVERE, null, ex);
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
