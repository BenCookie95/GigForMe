/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.DAO;

import GigForMe.Database.DBManager;
import GigForMe.Model.Band;
import GigForMe.Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;


public class bandDAO {
    public Band getBand(int bandID){
           
        String email = null;
        String Name = null;
        String Username = null;
        String password = null;
        String bio = null;
        String picdir = null;
        DBManager dmbgr = new DBManager();
        
        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due 
        //to the return statement at the end of the method
        Band band = new Band();
        
        try {
            
            String Query = "select * from BAND WHERE BANDID= ?";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, bandID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //We get our results and insert them into a new user object.
                System.out.println(rs.getString(2));
                email = (rs.getString(5));
                Name = (rs.getString(3));
                Username = (rs.getString(2));
                password = (rs.getString(7));
                picdir = (rs.getString(6));
                bio = (rs.getString(4));
            }
            band.setBandID(bandID);
            band.setEmail(email);
            band.setBandName(Name);
            band.setUsername(Username);
            band.setPassword(password);
            band.setPicDir(picdir);
            band.setBio(bio);
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            
        }
        return band;
    }
    
    public Band getBandUsername(String Username){

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due 
        //to the return statement at the end of the method
        
        int bandId = 0;
        
        String username = null;
        String bandName = null;
        String BIO = null;
        String Email = null;
        String PicDir = null;
        String password = null;
        Band tempUser = new Band();
        
        
        try {
           // stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery
             // ("select * from USERS WHERE USERNAME= ?" + Username);
            String query = "select * from BAND WHERE USERNAME  = ? or EMAIL = ?";
            PreparedStatement pstmt = con.prepareStatement( query );
            pstmt.setString( 1, Username);
            pstmt.setString( 2, Username); 
            ResultSet rs = pstmt.executeQuery( );
            while (rs.next()) {
                //We get our results and insert them into a new user object. 
                //user = new User(results.getInt(1), results.getString(2), results.getString(3),results.getString(4),results.getString(5),results.getString(6));
                bandId = (rs.getInt(1));
                username = (rs.getString(2));
                bandName = (rs.getString(3));
                BIO = (rs.getString(4));
                Email = (rs.getString(5));
                PicDir = (rs.getString(6));
                
                password = (rs.getString(7));
                
                
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tempUser.setEmail(Email);
        tempUser.setBandID(bandId);
        tempUser.setBandName(bandName);
        tempUser.setUsername(username);
        tempUser.setPassword(password);
        tempUser.setPicDir(PicDir);
        tempUser.setBio(BIO);
        
        return tempUser;
    }
    
    public Vector<Band> getAllBands(){
        Vector<Band> bandList = new Vector<Band>();
        
       Statement stmt;

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due to the return statement at the end of the method
        Band band = null;
        int bandID = 0;
        String bandName = null;
        String bio = null;
        String picDir = null;
        String email = null;
        String password = null;
        
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from BAND");

            while (rs.next()) {
               Band band1 = new Band();
               bandID = (rs.getInt(1));
               bandName = (rs.getString(3));
               bio = (rs.getString(4));
               picDir = (rs.getString(6));
               email =(rs.getString(5));
               password =(rs.getString(7));
               
               band1.setBandID(bandID);
               band1.setBandName(bandName);
               band1.setBio(bio);
               band1.setPicDir(picDir);
               band1.setEmail(email);
               band1.setPassword(password);
               bandList.add(band1);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bandList;
    }
    
    public Vector<String> getAllTheBands(String search){
    
       Vector<Band> BandList = new Vector<Band>();
       Vector<String> resultList = new Vector<String>();
       Statement stmt;

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        search.replaceAll("'","''");
        int bandId = 0;
        String username = null;
        String bandName = null;
        String bio = null;
        String picDir = null;
        String email = null;
        String password = null;
    
        //We have to instatiate user here due to the return statement at the end of the method
        
        
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from BAND where upper(username) Like upper('%" + search + "%')");

            while (rs.next()) {
               
                //We get our results and insert them into a new user object. 
                //user = new User(results.getInt(1), results.getString(2), results.getString(3),results.getString(4),results.getString(5),results.getString(6));
                bandId = (rs.getInt(1));
                username = (rs.getString(2));
                bandName = (rs.getString(3));
                bio = (rs.getString(4));
                email = (rs.getString(5));
                picDir = (rs.getString(6));
                password = (rs.getString(7));
                
                
                
                String searchResult = "<li><a href=\"EditProfile?u="+ bandId + "\">" + "<img src=\"../" + picDir + "\" class=\"dropPic\">&nbsp;" + username + "</a></li>";
                resultList.add(searchResult);
            }
            rs.close();
            stmt.close();
            con.close();
                
                
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        return resultList;
    }
    
    public void insertBand(Band band) throws SQLException{
       

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        String bandname = band.getBandName() + " <i class=\"fa fa-check-square-o\"></i>";
        try{
            
        String Query = "INSERT INTO Band(Username, Band_Name, email, picdir, password)"
                + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(Query);
        //String vars = "'" + venue.getVenueName() + "'," +  venue.getCapacity()  + ")";
        //Query = Query + vars;
        //stmt.executeUpdate(Query);
        pstmt.setString( 1, band.getUsername()); 
        pstmt.setString( 2, bandname);
        pstmt.setString( 3, band.getEmail()); 
        pstmt.setString( 4, band.getPicDir()); 
        pstmt.setString( 5, band.getPassword()); 
        pstmt.executeUpdate();
        }catch (SQLException sqlExcept){   
        System.out.println("SQL Error code:" + sqlExcept);
        
        }
        
    }
    
    public String deleteBand(int UserID) throws SQLException{
        String success=null;
        try {
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
            
            String Query = "DELETE FROM BAND WHERE BANDID = ?";
            String Query1 = "Delete From GIG Where BANDID = ?";
            PreparedStatement pstmt = con.prepareStatement(Query);
            PreparedStatement pstmt1 = con.prepareStatement(Query1);
            pstmt.setInt(1, UserID);
            pstmt1.setInt(1, UserID);
            pstmt.executeUpdate();
            pstmt1.executeUpdate();
            pstmt.close();
            pstmt1.close();
            con.close();
            success="yes";
        }catch(SQLException Ex){
            success="no";
        }
        
        
        return success;
    }

//Ajax method to check if email already exists
public String checkEmail(String email){

        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        String theEmail = null;
        String success=null;
        try {
           // stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery
             // ("select * from USERS WHERE USERNAME= ?" + Username);
            String query = "select email from BAND WHERE upper(email) = upper(?)";
            PreparedStatement pstmt = con.prepareStatement( query );
            
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery( );
            while (rs.next()) {
                
                theEmail = (rs.getString(1));
 
            }
            if (theEmail != null) {
                success = "no";
            }else{
                success = "yes";
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            success = "no";
        }
        
        
        return success;
}
    
public String checkUsername(String username){

        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        String theUsername = null;
        String success=null;
        try {
           // stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery
             // ("select * from USERS WHERE USERNAME= ?" + Username);
            String query = "select username from BAND WHERE upper(username) = upper(?)";
            PreparedStatement pstmt = con.prepareStatement( query );
            
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery( );
            while (rs.next()) {
                
                theUsername = (rs.getString(1));
 
            }
            if (theUsername != null) {
                success = "no";
            }else{
                success = "yes";
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            success = "no";
        }
        
        
        return success;
}    

public String getBandPassword(int bandid){

        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        String thePassword = null;
        
        try {
           // stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery
             // ("select * from USERS WHERE USERNAME= ?" + Username);
            String query = "select password from BAND WHERE BANDID != ?";
            PreparedStatement pstmt = con.prepareStatement( query );
            pstmt.setInt( 1, bandid);
            ResultSet rs = pstmt.executeQuery( );
            while (rs.next()) {
                
                thePassword = (rs.getString(1));
 
            }
            
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            
        }
        
        
        return thePassword;
}

public void updateTheBand(int bandid, String bio, String password) throws SQLException{
        
        
        
         try {
            
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
             System.out.println("running" + bio);
            
            //Query to be executed.
            String Query = "UPDATE BAND SET BIO = ?, PASSWORD = ?"
                    + " WHERE BANDID = ?";
            //Sys out to validate our Query
            PreparedStatement pstmt = con.prepareStatement(Query);
            //Executing Query by calling stmt.execute, 'Statement stmt' declared above.
            
            pstmt.setString(1, bio); 
            pstmt.setString(2, password);  
            pstmt.setInt(3, bandid); 
            
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
                
        } catch (SQLException Ex) {
            
        }
        
        
        
    }

public void updateDirectory(int bandid, String upDir) throws SQLException{
        
        
        
         try {
            Statement stmt;
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
            
            String picDir = "img/" + upDir;
            //Query to be executed.
            String Query = "UPDATE BAND SET PICDIR = ?"
                    + " WHERE BANDID = ?";
            //Sys out to validate our Query
            PreparedStatement pstmt = con.prepareStatement(Query);
            //Executing Query by calling stmt.execute, 'Statement stmt' declared above.
            pstmt.setString(1, picDir);
            pstmt.setInt(2, bandid); 
             
            
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
                
        } catch (SQLException Ex) {
            
        }
        
        
        
    }

}
