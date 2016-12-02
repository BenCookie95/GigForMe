/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Servlets;

import GigForMe.DAO.userDAO;
import GigForMe.Model.User;
import GigForMe.Utils.Constants;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

/**
 *
 * @author Ben
 */

public class UpdateProfileServlet extends HttpServlet {

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
        
        
        String upDir = Constants.userfilepath + "web//img";
        userDAO uDAO = new userDAO();
        String userid = null;
        String Email = null;
        String BIO = null;
        String admin = null;
        String ban = null;
        String password = null;
        String password1 = null;
        int i = 0;
        //int UserID = 2;
        
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    
                    if(item.isFormField()){
//                        String userid = item.getString();
//                        String Email = item.getString();
//                        String BIO = item.getString();
//                        String admin = item.getString();
//                        String ban = item.getString();
//                        String password = item.getString();
                        
                        
                        if (i ==0) {
                            userid = item.getString();
                            System.out.println(userid);
                        }else if( i== 1){
                            Email = item.getString();
                            System.out.println(Email);
                        }else if(i == 2){
                            BIO = item.getString();
                            System.out.println(BIO);
                        }else if(i == 3){
                            admin = item.getString();
                            System.out.println(admin);
                        }else if(i == 4){
                            ban = item.getString();
                            System.out.println(ban);
                        }else if(i == 5){
                            
                            password = item.getString();
                            System.out.println(password); 
                            if(password.isEmpty()){
                                int UserID = Integer.parseInt(userid);
                                String userPassword = uDAO.getUserPassword(UserID);
                                uDAO.updateUser(UserID, Email, BIO, admin, ban, userPassword);
                            }else if( password.equals("checkboxPassword")){
                                
                            }
                                
                            
                            
                        }else if(i==6){
                            int UserID = Integer.parseInt(userid);
                            password1 = item.getString();
                            System.out.println(password1);
                            if (password.equals("checkboxPassword")) {
                                uDAO.updateUser(UserID, Email, BIO, admin, ban, password1);
                            }
                        }
                        
                        
                        //uDAO.updateUser(UserID, Email, BIO, admin, ban, userPassword);
                        i++;    
                                             
                    }else if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        Random rn = new Random();
                        int answer = rn.nextInt(1000000000);
                        if (name.length() == 0) {
                            
                            
                        }else{
                            String rename = answer + name;
                            String rename1 = rename.replace(" ","");
                            int UserID = Integer.parseInt(userid);
                            
                            item.write( new File(upDir+ File.separator + rename1));
                            uDAO.updateDirectory(UserID, rename1);
                            //File uploaded successfully
                            request.setAttribute("message", "File Uploaded Successfully");
                        }   
                    }
                }
           
               
                System.out.println("File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
        //response.setHeader("Cache-Control","no-cache, no-store");
        //RequestDispatcher rd = request.getRequestDispatcher("UserManagement");
        //rd.forward(request, response);
        Random rn = new Random();
        int uid = rn.nextInt(1000000000);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
          //Handle exception
        }
        response.sendRedirect("UserManagement?id="+uid);
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
            Logger.getLogger(UpdateProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
