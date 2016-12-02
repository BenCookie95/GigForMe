/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Servlets;

import GigForMe.DAO.bandDAO;
import GigForMe.Model.Band;
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
@WebServlet(name = "AddBandServlet", urlPatterns = {"/Admin/AddBand"})
public class AddBandServlet extends HttpServlet {

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
        String bandName = request.getParameter("fname");
        String email = request.getParameter("bandemail");
        String username = request.getParameter("bandusername");
        String password = request.getParameter("password");
        String picDir = "img/profile.jpg";
        UserError er = new UserError();
        
        if (StringUtils.isStringEmpty(bandName) || StringUtils.isStringEmpty(email) || StringUtils.isStringEmpty(username) || StringUtils.isStringEmpty(password)) {
            request.setAttribute("error", er.getBlankField());
            request.getRequestDispatcher("add_band.jsp").forward(request, response);
        }else{
            Band band = new Band(bandName, email, username, picDir, password);
            bandDAO bDAO = new bandDAO();
            try {
            bDAO.insertBand(band);
            //save message in session
            request.getSession(true).setAttribute("message", "yes");
            response.sendRedirect("BandManagement");
            } catch(SQLException ex) {
                Logger.getLogger(AddVenueServlet.class.getName()).log(Level.SEVERE, null, ex);
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
