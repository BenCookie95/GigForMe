/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.DAO;


import GigForMe.Database.DBManager;
import GigForMe.Model.Vote;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class VoteDAO {
    
    
    public ArrayList<Vote> getAllVotes(){
    
       ArrayList<Vote> voteList = new ArrayList<Vote>();
        
       Statement stmt;

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due to the return statement at the end of the method
        Vote vote = null;
        
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("select * from VOTES");

            while (results.next()) {
                voteList.add(new Vote(results.getInt(1),results.getInt(2),results.getInt(3)));
            }
            results.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null, "error getting AllVotes");
        }
        return voteList;
    }
    
    public String addVote(int gigid, int userid) throws SQLException{

        DBManager dmbgr = new DBManager();
        String checkvote = getVoteTrue(gigid, userid);
        Connection con = dmbgr.getConnection();
        String success = "NO";
        if (checkvote == "NO") {
            try{
            String Query = "INSERT INTO VOTES(USERID, GIGID) VALUES(?,?)";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, userid);
            pstmt.setInt( 2, gigid);
            pstmt.executeUpdate( );
            success = "YES";

            pstmt.close();
            con.close();
            }catch(SQLException sqlExcept){
                success = "NO";
            }
        }
        
        return success;
    }
    
    public void updateVote(){
         try{
        Statement stmt;

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        stmt = con.createStatement();
        String Query = "Select * from Votes";
        
        DatabaseMetaData md = con.getMetaData();
        ResultSet rs = md.getTables(null, null, "%", null);
        while (rs.next()) {
          System.out.println(rs.getString(3));
        }
        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null, "error getting Votes");
        }
    }
    
    public int getGigVotes(int gigid){
        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        int voteCount = 0;
        try {
            String Query = "select Count(*) from Votes WHERE GIGID = ?";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, gigid);
            ResultSet rs = pstmt.executeQuery( );
            
            while (rs.next()) {
                
                voteCount = (rs.getInt(1));
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return voteCount;
        
    }
    
    public String getVoteTrue(int gigid, int userid){
        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        int voteCount = 0;
        String voteCheck = null;
        try {
            String Query = "select Count(*) from Votes WHERE GIGID = ? AND USERID = ?";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, gigid);
            pstmt.setInt( 2, userid);
            ResultSet rs = pstmt.executeQuery( );
            
            while (rs.next()) {
                
                voteCount = (rs.getInt(1));
            }
            if (voteCount >0) {
                voteCheck = "YES";
            }else if(userid == 0){
                voteCheck = "YES";
            }else{
                voteCheck= "NO";
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return voteCheck;
        
    }
    
}
