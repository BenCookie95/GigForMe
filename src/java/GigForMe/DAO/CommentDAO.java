/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.DAO;

import GigForMe.Model.Comment;
import GigForMe.Database.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;


public class CommentDAO {
    public Comment getComment(int CommentID){
        //initialise and instantite databse set up connectivity 
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        
        //We have to instatiate user here due 
        //to the return statement at the end of the method
        Comment Comment = null;
        
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery
        ("select * from COMMENT WHERE CommentID=" + CommentID);

            while (results.next()) {
                //We get our results and insert them into a new user object. 
                Comment = new Comment(results.getInt(1),results.getInt(2),results.getInt(3),results.getInt(4),results.getString(5));
            }
            
           //close various elements
            results.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null, "error getting User");
        }
        return Comment;
    }
    
    public Vector<Comment> getAllComments(int gigid){
    
        Vector<Comment> CommentList = new Vector<Comment>();

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due to the return statement at the end of the method
        String picDir = null;
        String username = null;
        String userComment = null;
        String Name = null;
        int id = 0;
        try {
           
            String Query = ("SELECT "
                    + "CASE WHEN COMMENT.USERID = 0 THEN "
                    + "BAND.PICDIR ELSE"
                    + " USERS.PICDIR END, "
                    + " CASE WHEN COMMENT.USERID = 0 THEN "
                    + "BAND.USERNAME ELSE"
                    + " USERS.USERNAME END, "
                    + " CASE WHEN COMMENT.USERID = 0 THEN "
                    + "BAND.BAND_NAME ELSE"
                    + " USERS.UNAME END,"
                    + " CASE WHEN COMMENT.USERID = 0 THEN "
                    + "COMMENT.BANDID ELSE"
                    + " COMMENT.USERID END,"
                    + " COMMENT.USERCOMMENT "
                    + "FROM COMMENT " 
                    + "LEFT OUTER JOIN USERS "
                    + "ON COMMENT.USERID = USERS.USERID "
                    + "LEFT OUTER JOIN BAND "
                    + "ON COMMENT.BANDID = BAND.BANDID "
                    + "WHERE COMMENT.GIGID = ? ORDER BY COMMENT.COMMENTID DESC");
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt(1, gigid);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                System.out.println("running query");
                Comment comment = new Comment();
                picDir = (rs.getString(1));
                username = (rs.getString(2));
                Name = (rs.getString(3));
                id = (rs.getInt(4));
                userComment = (rs.getString(5));
                System.out.println(picDir + " " + username);
                comment.setPicdir(picDir);
                comment.setUsername(username);
                comment.setName(Name);
                comment.setUserID(id);
                comment.setComment(userComment);
                CommentList.add(comment);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            System.out.println(sqlExcept);
        }
        return CommentList;
    }
    
    public String addComment(int userid, int bandid, int gigid, String comment) throws SQLException{
        String success = "NO";
        try{
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();

            String Query = "INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT) VALUES(?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, userid);
            pstmt.setInt( 2, bandid);
            pstmt.setInt( 3, gigid);
            pstmt.setString( 4, comment);
            
            pstmt.executeUpdate();
            success = "YES";
            pstmt.close();
            con.close();
            
        }catch(SQLException sqlExcept){
            success = "NO";
        }
        return success;
    }
    
    public void updateComment(Comment Comment){
        
    }
    
    public void deleteComment(Comment Comment) throws SQLException{
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        
        stmt = con.createStatement();
        String Query = "DELETE FROM COMMENT WHERE CommentID =" + Comment.getCommentID() + ";" ;
        
        stmt.executeQuery(Query);
    }
    
}
