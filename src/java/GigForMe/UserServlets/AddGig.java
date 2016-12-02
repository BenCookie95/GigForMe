/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.UserServlets;

import GigForMe.DAO.gigDAO;
import GigForMe.Model.Gig;
import GigForMe.Model.User;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ben
 */
@WebServlet(name = "AddGig", urlPatterns = {"/AddGig"})
public class AddGig extends HttpServlet {

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
        String band = request.getParameter("band");
        String description = request.getParameter("description");
        String venueName = request.getParameter("venue");       
        String price = request.getParameter("price");
        String gigDate = request.getParameter("gigDate");
        
        HttpSession session = request.getSession();
        User getUser = (User) session.getAttribute("USER");
        gigDAO gd = new gigDAO();
        
        UserError er = new UserError();
        if (StringUtils.isStringEmpty(venueName) || StringUtils.isStringEmpty(band) || StringUtils.isStringEmpty(description) || StringUtils.isStringEmpty(price) || StringUtils.isStringEmpty(gigDate)) {
            request.setAttribute("error", er.getBlankField());
            request.getRequestDispatcher("request_gig.jsp").forward(request, response);
        }else if(StringUtils.isDouble(price)){
            request.setAttribute("error", er.getPriceError());
            request.getRequestDispatcher("request_gig.jsp").forward(request, response);
        }else if(getUser.getUsername() == null){
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            double thePrice = Double.parseDouble(price);
            int venueid = Integer.parseInt(venueName);
            int bandid = Integer.parseInt(band);
            Gig gig = new Gig(venueid, bandid, getUser.getUserID(), description, gigDate, thePrice, "NO");
            gd.insertGig(gig);
            //save message in session
            request.getSession(true).setAttribute("message", "yes");
            response.sendRedirect("Gigs");
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
            Logger.getLogger(AddGig.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddGig.class.getName()).log(Level.SEVERE, null, ex);
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
