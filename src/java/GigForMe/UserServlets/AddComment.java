/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.UserServlets;

import GigForMe.DAO.CommentDAO;
import GigForMe.Model.Band;
import GigForMe.Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
@WebServlet(name = "AddComment", urlPatterns = {"/AddComment"})
public class AddComment extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        User getUser = (User) session.getAttribute("USER");
        Band getBand = (Band) session.getAttribute("BAND");
        
        String gigid = request.getParameter("field");
        String Comment = request.getParameter("post");
        
        int gigID = Integer.parseInt(gigid);
        
        
        CommentDAO cDAO = new CommentDAO();
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        Gson gson = new Gson();
        JsonObject myObj = new JsonObject();
            
            
           
        if (null == session.getAttribute("USER")) {
            if(null == session.getAttribute("BAND")){
                
            }else{
                try {
                String success = cDAO.addComment( 0, getBand.getBandID(), gigID, Comment);
                JsonElement Success = gson.toJsonTree(success);
                String username = getBand.getUsername();
                String picdir = getBand.getPicDir();
                //JsonElement username = gson.toJsonTree(getUser.getUsername());
                if (success=="YES") {
                    myObj.addProperty("success", true);
                }else{
                    myObj.addProperty("success", false);
                }
                myObj.addProperty("username", username);
                myObj.addProperty("picdir", picdir);
                myObj.add("info", Success);
                out.println(myObj.toString());
                out.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddComment.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }else{
            
            try {
                String success = cDAO.addComment(getUser.getUserID(), 0, gigID, Comment);
                JsonElement Success = gson.toJsonTree(success);
                
                //JsonElement username = gson.toJsonTree(getUser.getUsername());
                if (success=="YES") {
                    myObj.addProperty("success", true);
                }else{
                    myObj.addProperty("success", false);
                }
                String username = getUser.getUsername();
                String picdir = getUser.getPicDir();
                myObj.addProperty("username", username);
                myObj.addProperty("picdir", picdir);
                myObj.add("info", Success);
                out.println(myObj.toString());
                out.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddComment.class.getName()).log(Level.SEVERE, null, ex);
            }
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
