/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.DAO;

import GigForMe.Model.User;
import GigForMe.Database.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.http.Cookie;
import javax.swing.JOptionPane;

public class userDAO {
    
    
    
    
    
    public User getUser(int userID){
           
       

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
       
        
        String Username = null;
        String Email = null;
        String UName = null;
        String BIO = null;
        String PicDir = null;
        String isAdmin = null;
        String password = null;
        String banned = null;
        User tempUser = new User();
        try {
            String Query = "select * from USERS WHERE USERID = ?";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, userID);
            ResultSet rs = pstmt.executeQuery( );

            while (rs.next()) {
                
                Username = (rs.getString(2));
                UName = (rs.getString(3));
                BIO = (rs.getString(4));
                Email = (rs.getString(5));
                PicDir = (rs.getString(6));
                isAdmin = (rs.getString(7));
                password = (rs.getString(8));
                banned = (rs.getString(9));
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tempUser.setEmail(Email);
        tempUser.setUserID(userID);
        tempUser.setName(UName);
        tempUser.setUsername(Username);
        tempUser.setPassword(password);
        tempUser.setIsAdmin(isAdmin);
        tempUser.setPicDir(PicDir);
        tempUser.setBio(BIO);
        tempUser.setIsBanned(banned);
        
        return tempUser;
    }
    
    public User getTheUser(String Username){
           
        Statement stmt;

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due 
        //to the return statement at the end of the method
        User user = null;
        
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery
        ("select * from USERS WHERE USERNAME= '" + Username + "'");

            while (results.next()) {
                //We get our results and insert them into a new user object. 
                user = new User(results.getInt(1), results.getString(2), results.getString(3),results.getString(4),results.getString(5),results.getString(6),results.getString(7), results.getString(8));
            }
            results.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            System.out.println(sqlExcept);
        }
        return user;
    }
    public User getUserByUsername(String Username){
           
        Statement stmt;

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due 
        //to the return statement at the end of the method
        
        int userId = 0;
        String Email = null;
        
        String UName = null;
        String BIO = null;
        
        String PicDir = null;
        
        String password = null;
        User tempUser = new User();
        
        
        try {
           // stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery
             // ("select * from USERS WHERE USERNAME= ?" + Username);
            String query = "select * from USERS WHERE USERNAME= ?";
            PreparedStatement pstmt = con.prepareStatement( query );
            pstmt.setString( 1, Username); 
            ResultSet rs = pstmt.executeQuery( );
            while (rs.next()) {
                //We get our results and insert them into a new user object. 
                //user = new User(results.getInt(1), results.getString(2), results.getString(3),results.getString(4),results.getString(5),results.getString(6));
                userId = (rs.getInt(1));
                UName = (rs.getString(3));
                BIO = (rs.getString(4));
                Email = (rs.getString(5));
                PicDir = (rs.getString(6));
                
                password = (rs.getString(8));
                
                
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tempUser.setEmail(Email);
        tempUser.setUserID(userId);
        tempUser.setName(UName);
        tempUser.setUsername(Username);
        tempUser.setPassword(password);
        
        tempUser.setPicDir(PicDir);
        tempUser.setBio(BIO);
        
        return tempUser;
    }
    public String getUsername(String Username){
           
       

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due 
        //to the return statement at the end of the method
        
        String username = null;
       
        String success = "NO";
        
        try {
           // stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery
             // ("select * from USERS WHERE USERNAME= ?" + Username);
            String query = "select * from USERS WHERE USERNAME= ?";
            PreparedStatement pstmt = con.prepareStatement( query );
            pstmt.setString( 1, Username); 
            ResultSet rs = pstmt.executeQuery( );
            while (rs.next()) {
                //We get our results and insert them into a new user object. 
                //user = new User(results.getInt(1), results.getString(2), results.getString(3),results.getString(4),results.getString(5),results.getString(6));
                username = (rs.getString(1));
                
                
            }
            
            if (username == null) {
                success  ="YES";
            }else{
                success="NO";
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            success = null;
        }
        
        
        
        
        return success;
    }
    public User getGenUser(String Username){

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due 
        //to the return statement at the end of the method
        
        int userId = 0;
        String Email = null;
        String username = null;
        String UName = null;
        String BIO = null;
        String isBanned = null;
        String PicDir = null;
        
        String password = null;
        User tempUser = new User();
        
        
        try {
           // stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery
             // ("select * from USERS WHERE USERNAME= ?" + Username);
            String query = "select * from USERS WHERE USERNAME  = ? or EMAIL = ?";
            PreparedStatement pstmt = con.prepareStatement( query );
            pstmt.setString( 1, Username);
            pstmt.setString( 2, Username); 
            ResultSet rs = pstmt.executeQuery( );
            while (rs.next()) {
                //We get our results and insert them into a new user object. 
                //user = new User(results.getInt(1), results.getString(2), results.getString(3),results.getString(4),results.getString(5),results.getString(6));
                userId = (rs.getInt(1));
                username = (rs.getString(2));
                UName = (rs.getString(3));
                BIO = (rs.getString(4));
                Email = (rs.getString(5));
                PicDir = (rs.getString(6));
                
                password = (rs.getString(8));
                isBanned = (rs.getString(9));
                
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tempUser.setEmail(Email);
        tempUser.setUserID(userId);
        tempUser.setName(UName);
        tempUser.setUsername(username);
        tempUser.setPassword(password);
        tempUser.setIsBanned(isBanned);
        tempUser.setPicDir(PicDir);
        tempUser.setBio(BIO);
        
        return tempUser;
    }
    
    public Vector<User> getAllUsers(){
    
       Vector<User> userList = new Vector<User>();
        
       Statement stmt;

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        
        int userId = 0;
        String Username = null;
        String Email = null;
        String UName = null;
        String BIO = null;
        String PicDir = null;
        String isAdmin = null;
        String password = null;
        String banned = null;
        //We have to instatiate user here due to the return statement at the end of the method
        
        
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from USERS");

            while (rs.next()) {
                User tempUser = new User();
                //We get our results and insert them into a new user object. 
                //user = new User(results.getInt(1), results.getString(2), results.getString(3),results.getString(4),results.getString(5),results.getString(6));
                userId = (rs.getInt(1));
                Username = (rs.getString(2));
                UName = (rs.getString(3));
                BIO = (rs.getString(4));
                Email = (rs.getString(5));
                PicDir = (rs.getString(6));
                isAdmin = (rs.getString(7));
                password = (rs.getString(8));
                banned = (rs.getString(9));
                
                
                tempUser.setEmail(Email);
                tempUser.setUserID(userId);
                tempUser.setName(UName);
                tempUser.setUsername(Username);
                tempUser.setPassword(password);
                tempUser.setIsAdmin(isAdmin);
                tempUser.setPicDir(PicDir);
                tempUser.setBio(BIO);
                tempUser.setIsBanned(banned);
                userList.add(tempUser);
            }
            rs.close();
            stmt.close();
            con.close();
                
                
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        return userList;
    }
    
    public Vector<String> getAllTheUsers(String search){
    
       
       Vector<String> resultList = new Vector<String>();
       

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        
        int userId = 0;
        String Username = null;
        String Email = null;
        String UName = null;
        String BIO = null;
        String PicDir = null;
        String isAdmin = null;
        String password = null;
        
        
        
        try {
            
            String Query = "select * from USERS where upper(username) Like upper(?)";
            
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setString(1, search + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                
                //We get our results and insert them into a new user object. 
                //user = new User(results.getInt(1), results.getString(2), results.getString(3),results.getString(4),results.getString(5),results.getString(6));
                userId = (rs.getInt(1));
                Username = (rs.getString(2));
                UName = (rs.getString(3));
                BIO = (rs.getString(4));
                Email = (rs.getString(5));
                PicDir = (rs.getString(6));
                isAdmin = (rs.getString(7));
                password = (rs.getString(8));
                
               
                
                String searchResult = "<li><a href=\"EditProfile?u="+ userId + "\">" + "<img src=\"../" + PicDir + "\" class=\"dropPic\">&nbsp;" + UName + "</a></li>";
                resultList.add(searchResult);
            }
            rs.close();
            pstmt.close();
            con.close();
                
                
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        return resultList;
    }
    
    public void insertUser(String username, String name, String email, String bio, String picdir, String isAdmin, String password, String isBanned) throws SQLException{
       

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        
        try{
            
            String Query = "INSERT INTO USERS(USERNAME,UNAME,EMAIL,BIO,PICDIR, ISADMIN, PASSWORD,ISBANNED) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, bio);
            pstmt.setString(5, picdir);
            pstmt.setString(6, isAdmin);
            pstmt.setString(7, password);
            pstmt.setString(8, isBanned);
            
            
            
            
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
           
            
        }catch(SQLException sqlExcept){
            System.out.println("SQL Error code:" + sqlExcept);
        }
        
  
    }
    
   
    
    public String banUser(int UserID) throws SQLException{
        
        String success=null;
        
         try {
            Statement stmt;
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
            stmt = con.createStatement();
            String setBan = "YES";
            //Query to be executed.
            String Query = "UPDATE USERS SET ISBANNED = " + "'" + setBan + "'"
                    + " WHERE USERID = " + UserID;
            //Sys out to validate our Query
            
            //Executing Query by calling stmt.execute, 'Statement stmt' declared above.
            stmt.executeUpdate(Query);
            stmt.close();
            con.close();
            success="yes";
            //Cathcing SQL exception that may be thrown from stmt.execute().    
        } catch (SQLException Ex) {
            //Sys out to print message + Ex--> Exception
            success="no";
        }
        return success;
        //String Query = "UPDATE USERS SET USERNAME =" + currentUser.getUsername() + ", UNAME =" + currentUser.getName()  + ", BIO =" + currentUser.getBio() + ", PICDIR = " + currentUser.getPicDir() + ", EMAIL =" + currentUser.getEmail() + ", PASSWORD=" + currentUser.getPassword();
        
    }
    public String unbanUser(int UserID) throws SQLException{
        
        String success=null;
        
         try {
            Statement stmt;
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
            
            String setBan = "NO";
            //Query to be executed.
            String Query = "UPDATE USERS SET ISBANNED = " + "'" + setBan + "'"
                    + " WHERE USERID = ?";
            //Sys out to validate our Query
            PreparedStatement pstmt = con.prepareStatement(Query);
            //Executing Query by calling stmt.execute, 'Statement stmt' declared above.
            pstmt.setInt(1, UserID); 
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            success="yes";
            //Cathcing SQL exception that may be thrown from stmt.execute().    
        } catch (SQLException Ex) {
            //Sys out to print message + Ex--> Exception
            success="no";
        }
        return success;
        
        
    }
    
    public String deleteUser(int UserID) throws SQLException{
        String success=null;
        try {
            
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
            
            String Query = "DELETE FROM USERS WHERE USERID = ?";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt(1, UserID);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            success="yes";
        }catch(SQLException Ex){
            success="no";
        }
        
        
        return success;
    }
    


//Ajax method to check if email already exists
public String checkEmail(int userid, String email){

        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        String theEmail = null;
        String success=null;
        try {
           // stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery
             // ("select * from USERS WHERE USERNAME= ?" + Username);
            String query = "select email from USERS WHERE USERID != ? and upper(email) = upper(?)";
            PreparedStatement pstmt = con.prepareStatement( query );
            pstmt.setInt( 1, userid);
            pstmt.setString(2, email);
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

//Ajax method to check if email already exists fro registration
public String checkTheEmail(String email){

        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        String theEmail = null;
        String success=null;
        try {
           // stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery
             // ("select * from USERS WHERE USERNAME= ?" + Username);
            String query = "select email from USERS WHERE upper(email) = upper(?)";
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
public void updateDirectory(int userid, String upDir) throws SQLException{
        
        
        
         try {
            Statement stmt;
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
            
            String picDir = "img/" + upDir;
            //Query to be executed.
            String Query = "UPDATE USERS SET PICDIR = ?"
                    + " WHERE USERID = ?";
            //Sys out to validate our Query
            PreparedStatement pstmt = con.prepareStatement(Query);
            //Executing Query by calling stmt.execute, 'Statement stmt' declared above.
            pstmt.setString(1, picDir);
            pstmt.setInt(2, userid); 
             
            
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
                
        } catch (SQLException Ex) {
            
        }
        
        
        
    }

public void updateUser(int userid, String email, String bio, String admin, String ban, String password) throws SQLException{
        
        
        
         try {
            Statement stmt;
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
             System.out.println("running " + password);
            
            //Query to be executed.
            String Query = "UPDATE USERS SET EMAIL = ?, BIO = ?, ISADMIN = ?, PASSWORD = ?,ISBANNED = ?"
                    + " WHERE USERID = ?";
            //Sys out to validate our Query
            PreparedStatement pstmt = con.prepareStatement(Query);
            //Executing Query by calling stmt.execute, 'Statement stmt' declared above.
            pstmt.setString(1, email);
            pstmt.setString(2, bio); 
            pstmt.setString(3, admin); 
            pstmt.setString(4, password); 
            pstmt.setString(5, ban); 
            pstmt.setInt(6, userid); 
            
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
                
        } catch (SQLException Ex) {
            
        }
        
        
        
    }

public String getUserPassword(int userid){

        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        String thePassword = null;
        
        try {
           // stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery
             // ("select * from USERS WHERE USERNAME= ?" + Username);
            String query = "select password from USERS WHERE USERID != ?";
            PreparedStatement pstmt = con.prepareStatement( query );
            pstmt.setInt( 1, userid);
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


public void updateTheUser(int userid, String email, String bio, String password) throws SQLException{
        
        
        
         try {
            
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
             System.out.println("running " + password);
            System.out.println(userid + " " + email + " " +  bio + " " + password);
            //Query to be executed.
            String Query = "UPDATE USERS SET EMAIL = ?, BIO = ?, PASSWORD = ?"
                    + " WHERE USERID = ?";
            //Sys out to validate our Query
            PreparedStatement pstmt = con.prepareStatement(Query);
            //Executing Query by calling stmt.execute, 'Statement stmt' declared above.
            pstmt.setString(1, email);
            pstmt.setString(2, bio); 
            pstmt.setString(3, password);  
            pstmt.setInt(4, userid); 
            
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
                
        } catch (SQLException Ex) {
            
        }
        
        
        
    }

}