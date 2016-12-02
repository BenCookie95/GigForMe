/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.DAO;

import GigForMe.Database.DBManager;
import GigForMe.Model.Gig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class gigDAO {
   public Gig getGig(int gigID, int userid) throws SQLException{

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due 
        //to the return statement at the end of the method
        String gigDesc = null;
        String venueName = null;
        String latitude = null;
        String longitude = null;
        String bandName = null;
        Double price = 0.0;
        String gigDate = null;
        String isConfirmed = null;
        Gig gig = new Gig(); 
        VoteDAO vDAO = new VoteDAO();
        String Query = "select GIG.GIG_DESCRIPTION, VENUES.VENUE_NAME, VENUES.LATITUDE, VENUES.LONGITUDE, BAND.BAND_NAME, GIG.PRICE, GIG.GIG_DATE, GIG.ISCONFIRMED "
                + "from GIG "
                + "INNER JOIN VENUES "
                + "ON GIG.VENUEID = VENUES.VENUEID "
                + "INNER JOIN BAND "
                + "ON GIG.BANDID = BAND.BANDID "
                + "INNER JOIN USERS "
                + "ON GIG.USERID = USERS.USERID "
                + "WHERE GIG.GIGID= ? ";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, gigID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //We get our results and insert them into a new user object. 
                //gig = new Gig(results.getString(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5));
                gigDesc = (rs.getString(1));
                venueName = (rs.getString(2));
                latitude = (rs.getString(3));
                longitude = (rs.getString(4));
                bandName = (rs.getString(5));
                price = (rs.getDouble(6));
                gigDate = (rs.getString(7));
                isConfirmed = (rs.getString(8));
            }
            int voteCount = vDAO.getGigVotes(gigID);
            String voteTrue = vDAO.getVoteTrue(gigID, userid);
            gig.setGigID(gigID);
            gig.setVotes(voteCount);
            gig.setGigDescription(gigDesc);
            gig.setVenueName(venueName);
            gig.setLatitude(latitude);
            gig.setLongitude(longitude);
            gig.setBandName(bandName);
            gig.setVoteCheck(voteTrue);
            gig.setPrice(price);
            gig.setGigDate(gigDate);
            gig.setIsConfirmed(isConfirmed);
            
            rs.close();
            pstmt.close();
            con.close();
       
        return gig;
    }
    
   public Gig getTheGig(int gigID) throws SQLException{

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due 
        //to the return statement at the end of the method
        
        Double price = 0.0;
        String gigDate = null;
        
        Gig gig = new Gig(); 
        VoteDAO vDAO = new VoteDAO();
        String Query = "select GIG.PRICE, GIG.GIG_DATE "
                + "from GIG "
                + "WHERE GIG.GIGID= ? ";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, gigID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //We get our results and insert them into a new user object. 
                //gig = new Gig(results.getString(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5));
                
                price = (rs.getDouble(1));
                gigDate = (rs.getString(2));
                
            }
            
            gig.setGigID(gigID);
            gig.setPrice(price);
            gig.setGigDate(gigDate);
            
            rs.close();
            pstmt.close();
            con.close();
       
        return gig;
    }
   
    public Vector<Gig> getAllGigs(){
    
       Vector<Gig> gigList = new Vector<Gig>();
        
       Statement stmt;

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        int gigId = 0;
        String desc = null;
        String vName = null;
        String bName = null;
        String madeBy = null;
        String gigDate = null;
        String picDir = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT GIG.GIGID, GIG.GIG_DESCRIPTION, VENUES.VENUE_NAME, BAND.PICDIR, BAND.BAND_NAME, " +
            "CASE WHEN GIG.USERID = 0 THEN BAND.BAND_NAME ELSE " +
            "USERS.USERNAME END, " +
            "GIG.GIG_DATE " +
            "from GIG " +
            "INNER JOIN VENUES ON GIG.VENUEID = VENUES.VENUEID " +
            "INNER JOIN BAND ON GIG.BANDID = BAND.BANDID " +
            "LEFT JOIN USERS ON GIG.USERID = USERS.USERID " +
            "order by Gig.GigID");

            
            
            
            while (rs.next()) {
                Gig gig1 = new Gig();
                gigId = rs.getInt(1);
                desc = rs.getString(2);
                vName = rs.getString(3);
                picDir = rs.getString(4);
                bName = rs.getString(5);
                madeBy = rs.getString(6);
                gigDate = rs.getString(7);
                
                gig1.setGigID(gigId);
                gig1.setGigDescription(desc);
                gig1.setVenueName(vName);
                gig1.setBandName(bName);
                gig1.setUsername(madeBy);
                gig1.setPicDir(picDir);
                gig1.setGigDate(gigDate);
                
                
                gigList.add(gig1);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            
        }
        return gigList;
    }
public Vector<Gig> getAllConfGigs(int userid){
    
       Vector<Gig> gigList = new Vector<Gig>();
        
       Statement stmt;

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        int gigId = 0;
        String desc = null;
        String vName = null;
        String bName = null;
        String madeBy = null;
        String gigDate = null;
        String picDir = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT GIG.GIGID, VENUES.VENUE_NAME, BAND.PICDIR, BAND.BAND_NAME, " +
            "GIG.GIG_DATE " +
            "from GIG " +
            "INNER JOIN VENUES ON GIG.VENUEID = VENUES.VENUEID " +
            "INNER JOIN BAND ON GIG.BANDID = BAND.BANDID " +
            "LEFT JOIN USERS ON GIG.USERID = USERS.USERID " +
            "Where GIG.ISConfirmed = 'YES' "
             + "order by Gig.GigID");

            
            
            VoteDAO vDAO = new VoteDAO();
            while (rs.next()) {
                Gig gig1 = new Gig();
                
                gigId = rs.getInt(1);
                
                vName = rs.getString(2);
                picDir = rs.getString(3);
                bName = rs.getString(4);
                gigDate = rs.getString(5);
                
                int voteCount = vDAO.getGigVotes(gigId);
                String voteTrue = vDAO.getVoteTrue(gigId, userid);
                gig1.setVoteCheck(voteTrue);
                gig1.setGigID(gigId);
                gig1.setVenueName(vName);
                gig1.setBandName(bName);       
                gig1.setPicDir(picDir);
                gig1.setGigDate(gigDate);
                gig1.setVotes(voteCount);
                
                gigList.add(gig1);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            
        }
        return gigList;
    }    
   
    public Vector<Gig> getAllTheGigs(int userid){
    
       Vector<Gig> gigList = new Vector<Gig>();
        
       Statement stmt;

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        int gigId = 0;
        String desc = null;
        String vName = null;
        String bName = null;
        String madeBy = null;
        String gigDate = null;
        String picDir = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT GIG.GIGID, VENUES.VENUE_NAME, BAND.PICDIR, BAND.BAND_NAME, " +
            "GIG.GIG_DATE " +
            "from GIG " +
            "INNER JOIN VENUES ON GIG.VENUEID = VENUES.VENUEID " +
            "INNER JOIN BAND ON GIG.BANDID = BAND.BANDID " +
            "LEFT JOIN USERS ON GIG.USERID = USERS.USERID " +
            "Where GIG.ISConfirmed = 'NO' "
             + "order by Gig.GigID");

            
            
            VoteDAO vDAO = new VoteDAO();
            while (rs.next()) {
                Gig gig1 = new Gig();
                
                gigId = rs.getInt(1);
                
                vName = rs.getString(2);
                picDir = rs.getString(3);
                bName = rs.getString(4);
                gigDate = rs.getString(5);
                
                int voteCount = vDAO.getGigVotes(gigId);
                String voteTrue = vDAO.getVoteTrue(gigId, userid);
                
                gig1.setVoteCheck(voteTrue);
                gig1.setGigID(gigId);
                gig1.setVenueName(vName);
                gig1.setBandName(bName);       
                gig1.setPicDir(picDir);
                gig1.setGigDate(gigDate);
                gig1.setVotes(voteCount);
                
                gigList.add(gig1);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            
        }
        return gigList;
    }
    
    public Vector<Gig> getAllBandGigs(int bandid){
    
       Vector<Gig> gigList = new Vector<Gig>();

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        int gigId = 0;
        String desc = null;
        String vName = null;
        String bName = null;
        String madeBy = null;
        String gigDate = null;
        String isconfirmed = null;
        String picDir = null;
        try {
           
            String Query = "SELECT GIG.GIGID, VENUES.VENUE_NAME, BAND.PICDIR, BAND.BAND_NAME, " +
            "GIG.GIG_DATE, GIG.ISCONFIRMED " +
            "from GIG " +
            "INNER JOIN VENUES ON GIG.VENUEID = VENUES.VENUEID " +
            "INNER JOIN BAND ON GIG.BANDID = BAND.BANDID " +
            "LEFT JOIN USERS ON GIG.USERID = USERS.USERID " +
            "Where GIG.BANDID = ? "
             + "order by Gig.GigID";

            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, bandid);
            ResultSet rs = pstmt.executeQuery( );
            
            VoteDAO vDAO = new VoteDAO();
            while (rs.next()) {
                Gig gig1 = new Gig();
                
                gigId = rs.getInt(1);
                
                vName = rs.getString(2);
                picDir = rs.getString(3);
                bName = rs.getString(4);
                gigDate = rs.getString(5);
                isconfirmed = rs.getString(6);
                int voteCount = vDAO.getGigVotes(gigId);
                gig1.setGigID(gigId);
                gig1.setVenueName(vName);
                gig1.setBandName(bName);       
                gig1.setPicDir(picDir);
                gig1.setGigDate(gigDate);
                gig1.setVotes(voteCount);
                gig1.setIsConfirmed(isconfirmed);
                gigList.add(gig1);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            
        }
        return gigList;
    }
    
    public Vector<Gig> getAllUserGigs(int userid){
    
       Vector<Gig> gigList = new Vector<Gig>();

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        int gigId = 0;
        String desc = null;
        String vName = null;
        String bName = null;
        String madeBy = null;
        String gigDate = null;
        String isconfirmed = null;
        String picDir = null;
        try {
           
            String Query = "SELECT GIG.GIGID, VENUES.VENUE_NAME, BAND.PICDIR, BAND.BAND_NAME, " +
            "GIG.GIG_DATE, GIG.ISCONFIRMED " +
            "from GIG " +
            "INNER JOIN VENUES ON GIG.VENUEID = VENUES.VENUEID " +
            "INNER JOIN BAND ON GIG.BANDID = BAND.BANDID " +
            "LEFT JOIN USERS ON GIG.USERID = USERS.USERID " +
            "Where GIG.USERID = ? "
             + "order by Gig.GigID";

            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, userid);
            ResultSet rs = pstmt.executeQuery( );
            
            VoteDAO vDAO = new VoteDAO();
            while (rs.next()) {
                Gig gig1 = new Gig();
                
                gigId = rs.getInt(1);
                
                vName = rs.getString(2);
                picDir = rs.getString(3);
                bName = rs.getString(4);
                gigDate = rs.getString(5);
                isconfirmed = rs.getString(6);
                int voteCount = vDAO.getGigVotes(gigId);
                gig1.setGigID(gigId);
                gig1.setVenueName(vName);
                gig1.setBandName(bName);       
                gig1.setPicDir(picDir);
                gig1.setGigDate(gigDate);
                gig1.setVotes(voteCount);
                gig1.setIsConfirmed(isconfirmed);
                gigList.add(gig1);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            
        }
        return gigList;
    }
    
    public int checkParameter(int gigID) throws SQLException{
           
        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        int gigCount = 0;
        try {
            String Query = "select Count(*) from Gig WHERE GIGID = ?";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, gigID);
            ResultSet rs = pstmt.executeQuery( );
            
            while (rs.next()) {
                
                gigCount = (rs.getInt(1));
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return gigCount;
    }
    
    public void insertGig(Gig gig) throws SQLException{
       
       DBManager dmbgr = new DBManager();
       Connection con = dmbgr.getConnection();
        try{
        String Query = "INSERT INTO GIG(VENUEID,BANDID,USERID,GIG_DESCRIPTION,DATE_CREATED,GIG_DATE,PRICE,ISCONFIRMED)"
                + "VALUES(?,?,?,?,CURRENT_TIMESTAMP,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(Query);
        pstmt.setInt( 1, gig.getVenueID()); 
        pstmt.setInt( 2, gig.getBandID());
        pstmt.setInt( 3, gig.getUserID()); 
        pstmt.setString( 4, gig.getGigDescription());
        pstmt.setString( 5, gig.getGigDate());
        pstmt.setDouble( 6, gig.getPrice());
        pstmt.setString( 7, gig.getIsConfirmed());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
        }catch (SQLException sqlExcept){   
        System.out.println("SQL Error code:" + sqlExcept);
        
        }
        
        
    }
    public String acceptGig(int gigid) throws SQLException{
        
        
        String success = "NO";
         try {
           
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
            
            
            //Query to be executed.
            String Query = "UPDATE gig SET ISCONFIRMED = 'YES'"
                    + " WHERE gigid = ?";
            //Sys out to validate our Query
            PreparedStatement pstmt = con.prepareStatement(Query);
            //Executing Query by calling stmt.execute, 'Statement stmt' declared above.
           
            pstmt.setInt(1, gigid); 
            success = "YES";
            
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
                
        } catch (SQLException Ex) {
            success = "NO";
        }
        
        return success;
        
    }
    
    public String declineGig(int gigid) throws SQLException{
        
        
        String success = "NO";
         try {
           
            DBManager dmbgr = new DBManager();
            Connection con = dmbgr.getConnection();
            
            
            //Query to be executed.
            String Query = "Delete from gig"
                    + " WHERE gigid = ?";

            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt(1, gigid); 
            success = "YES";
            
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
                
        } catch (SQLException Ex) {
            success = "NO";
        }
        
        return success;
        
    }
    
    public void updateGig(int gigID, String date, double price) throws SQLException{

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();

        try {
            //Query to be executed.
            String Query = "UPDATE GIG SET gig_date = ?, price = ? where gigid = ?";
            
            PreparedStatement pstmt = con.prepareStatement(Query);
            //Executing Query by calling stmt.execute, 'Statement stmt' declared above.
           
            pstmt.setString(1, date);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, gigID);
            
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            

            //Cathcing SQL exception that may be thrown from stmt.execute().    
        } catch (SQLException Ex) {
            //Sys out to print message + Ex--> Exception
            System.out.println("SQL Exception" + Ex);
        }
        
        
    }
    
    public void deleteGig(int gigID) throws SQLException{
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        
        stmt = con.createStatement();
        String Query = "DELETE FROM GIG WHERE GIGID =" + gigID  ;
        
        stmt.executeUpdate(Query);
    }
     
}
