/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.DAO;

import GigForMe.Database.DBManager;
import GigForMe.Model.User;
import GigForMe.Model.Venue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class venueDAO {
    public Venue getVenue(int venueID){
           
        Statement stmt;

        DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due 
        //to the return statement at the end of the method
        Venue venue = null;
      
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery
        ("select * from VENUES WHERE VENUEID=" + venueID);

            while (results.next()) {
                //We get our results and insert them into a new user object. 
                venue = new Venue(results.getInt(1), results.getString(2),results.getInt(3));
            }
            results.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null, "error getting Venue");
        }
        return venue;
    }
    
    public Vector<Venue> getAllVenues(){
    
       Vector<Venue> venueList = new Vector<Venue>();
        
       Statement stmt;

       DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
        //We have to instatiate user here due to the return statement at the end of the method
        int venueId = 0;
        String venueName = null;
        int venueCap = 0;
        
        try {
            stmt = con.createStatement();
            String Query = "select * from VENUES"; 
            PreparedStatement pstmt = con.prepareStatement(Query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Venue venue = new Venue();
                venueId = (rs.getInt(1));
                venueName = (rs.getString(2));
                venueCap = (rs.getInt(3));
                venue.setVenueID(venueId);
                venue.setVenueName(venueName);
                venue.setCapacity(venueCap);
                venueList.add(venue);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venueList;
    }
    
    public Venue insertVenue(Venue venue) throws SQLException{
       
       DBManager dmbgr = new DBManager();
       Connection con = dmbgr.getConnection();
        try{
            
        String Query = "INSERT INTO VENUES(VENUE_NAME,CAPACITY, LATITUDE, LONGITUDE)"
                + "VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(Query);
        //String vars = "'" + venue.getVenueName() + "'," +  venue.getCapacity()  + ")";
        //Query = Query + vars;
        //stmt.executeUpdate(Query);
        pstmt.setString( 1, venue.getVenueName()); 
        pstmt.setInt( 2, venue.getCapacity());
        pstmt.setString( 3, venue.getLatitude()); 
        pstmt.setString( 4, venue.getLongitude()); 
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
        }catch (SQLException sqlExcept){   
        System.out.println("SQL Error code:" + sqlExcept);
        
        }
        
        return venue;
        
        
    }
    
    
    
    public String removeVenue(int venueID) throws SQLException{
        
        
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        String success = "NO";
        try {
            String Query = "Delete from Venues WHERE VENUEID = ?";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt( 1, venueID);
            
            pstmt.executeUpdate( );
            String Query1= "Delete from gig where venueid = ?";
            PreparedStatement pstmt1 = con.prepareStatement(Query1);
            pstmt1.setInt( 1, venueID);
            pstmt1.executeUpdate( );
            
            success = "YES";
            pstmt.close();
            pstmt1.close();
            con.close();
        } catch (SQLException e) {
            success = "NO";
        }
        
        return success;
    }
    
}
