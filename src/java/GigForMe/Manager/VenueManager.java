/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Manager;

import GigForMe.DAO.venueDAO;
import GigForMe.Model.User;
import GigForMe.Model.Venue;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class VenueManager {
    
    public Venue addVenue(String venueName, int cap) throws SQLException{
        venueDAO vDAO = new venueDAO();
        Venue venue1 = new Venue(venueName, cap);
        
       
        Venue venue = vDAO.insertVenue(venue1);
       
        if(venue == null){
            return null;
        }else{
            
            return venue;
        }
        
        
        
    }
    
    
}
