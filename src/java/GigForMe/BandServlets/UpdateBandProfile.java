/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.BandServlets;

import GigForMe.DAO.bandDAO;
import GigForMe.Model.Band;
import static GigForMe.Utils.Constants.SESSION_BAND;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Ben
 */
@WebServlet(name = "UpdateBandProfile", urlPatterns = {"/UpdateBandProfile"})
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
            throws ServletException, IOException {
        String upDir = "C://Users//Ben//Documents//NetBeansProjects//GigForMe//web//img";
        
        HttpSession session = request.getSession();
        Band getBand = (Band) session.getAttribute("BAND");
        
        bandDAO bDAO = new bandDAO();
        int bandid = getBand.getBandID();
        String directory = getBand.getPicDir();
        
        String BIO = null;
        String password = null;
        String password1 = null;
        int i = 0;
        
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    
                    if(item.isFormField()){
                        
                        
                        if(i == 0){
                            System.out.println(i);
                            BIO = item.getString();
                            System.out.println(BIO);
                        }else if(i == 1){
                            
                            password = item.getString();
                            System.out.println(password); 
                            if(password.isEmpty()){   
                                String userPassword = bDAO.getBandPassword(bandid);
                                
                                bDAO.updateTheBand(bandid, BIO, userPassword);
                            }else if( password.equals("checkedPassword")){
                                
                            }
                                
                            
                            
                        }else if(i==2){
                            
                            password1 = item.getString();
                            System.out.println(password1);
                            if (password.equals("checkboxPassword")) {
                                bDAO.updateTheBand(bandid, BIO, password1);
                            }
                        }
                        
                        
                        //uDAO.updateUser(UserID, Email, BIO, admin, ban, userPassword);
                        i++;    
                        System.out.println(i);                     
                    }else if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        Random rn = new Random();
                        int answer = rn.nextInt(1000000000);
                        if (name.length() == 0) {
                            
                            
                        }else{
                            String rename = answer + name;
                            String rename1 = rename.replace(" ","");
                            
                            
                            item.write( new File(upDir+ File.separator + rename1));
                            bDAO.updateDirectory(bandid, rename1);
                            directory = "img/" + rename1;
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
        //RequestDispatcher rd = request.getRequestDispatcher("about_us.jsp");
        //rd.forward(request, response);
        Random rn = new Random();
        int uid = rn.nextInt(1000000000);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
          //Handle exception
        }
        Band band = new Band(bandid, getBand.getUsername(), getBand.getBandName(), BIO, getBand.getEmail(), directory,  password);
        request.getSession(true).setAttribute(SESSION_BAND, band);
        response.sendRedirect("ViewBand");
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
