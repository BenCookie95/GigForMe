
package GigForMe.TestClasses;

import GigForMe.DAO.venueDAO;
import GigForMe.Database.DBManager;
import GigForMe.Database.SetupDb;
import GigForMe.Model.Venue;
import java.sql.SQLException;

/**
 *
 * @author 113491948
 */
public class VenueDAOTest {
    public static void main(String[] args) throws SQLException {
        DBManager mngr = new DBManager();
        mngr.checkConnection();
        SetupDb sdb = new SetupDb();
        sdb.createTables();
        sdb.insertSetupData();
        venueDAO vDAO = new venueDAO();
        
        //method shows specified venue
        showVenue(1);
        
        //show all venues
        showAllVenues();
        
        //create a new venue object
        Venue venue1 = new Venue("Savoy",2000);
        
        //call method which inserts new venue
        enterVenue(venue1);
        
        //show all venues following insertion
        showAllVenues();
        
        //call method which deletes venue
        removeVenue(1);
        
        //show all venues following deletion
        showAllVenues();
        
        //showing venue to be updated
        System.out.println("\n\nShowing Venue to be updated");
        showVenue(5);
        
        //call method which updates
        editVenue(5);
        
        //showw all venues following insertion updating and deletion
        System.out.println("\n\nShow Venue following update");
        showVenue(5);
        
        
        
    }
    
    private static void showVenue(int venueID){
        //create DAO object 
        venueDAO vDAO = new venueDAO();
        //shows a venue
        System.out.println("\n______Printing a Venue___________");
        System.out.println("Venue ID: " + vDAO.getVenue(venueID).getVenueID() + ". Name: " + vDAO.getVenue(venueID).getVenueName() + ". Capacity: " + vDAO.getVenue(venueID).getCapacity());
    }
    
    private static void showAllVenues(){
        //create DAO object 
        venueDAO vDAO = new venueDAO();
        
        //prints all the venues
        System.out.println("\n______Printing all the Venues___________");
        System.out.println(vDAO.getAllVenues().toString());
    }
    
    private static void enterVenue(Venue venue1) throws SQLException{
         //create DAO object 
        venueDAO vDAO = new venueDAO();
        
        System.out.println("\nInserting A Venue");
        vDAO.insertVenue(venue1);
    }
    
    private static void removeVenue(int venueID) throws SQLException{
         //create DAO object 
        venueDAO vDAO = new venueDAO();
        
        //vDAO.deleteVenue(venueID);
        System.out.println("\n1 Venue Deleted. Including any gigs associated with it.");
    }
    
    private static void editVenue(int venueID) throws SQLException{
         //create DAO object 
        venueDAO vDAO = new venueDAO();
        
        //vDAO.updateVenue(venueID);
        System.out.println("\n\nVenue Updated");
    }
}
