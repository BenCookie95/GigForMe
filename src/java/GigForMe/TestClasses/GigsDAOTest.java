
package GigForMe.TestClasses;

import GigForMe.DAO.gigDAO;
import GigForMe.Database.DBManager;
import GigForMe.Database.SetupDb;
import GigForMe.Model.Gig;
import java.sql.SQLException;

/**
 *
 * @author 113491948
 */
public class GigsDAOTest {
    public static void main(String[] args) throws SQLException {
        DBManager mngr = new DBManager();
        mngr.checkConnection();
        SetupDb sdb = new SetupDb();
        sdb.createTables();
        sdb.insertSetupData();
        
        //creating a DAO Object
        gigDAO gDAO = new gigDAO();
        
        //shows a gig
        System.out.println("----Showing a gig----");
        showGig(3);
        
        showAllGigs();
        //creates a new user Object 
        //Gig gig1 = new Gig(1,1,1,"Biggest Gig On Earth", "20/04/2015", "25/12/2015",85.50,false);
        
        //calls enterUser mathos which inserts a user
        //enterGig(gig1);
        
        
        //method shows all Gigs in database following insertion
        showAllGigs();
        
        //outlines which gig is going to be updated
        System.out.println("\n---------Preparing to update the following Gig Details----------");
        showGig(1);
        
        //call methos which updates Gig
        editGig(1);
        
        //shows the newly updated gig
        showGig(1);
        
        //calls merthod which deletes Gig
        removeGig(4);
        
        ////method shows all Gigs in database (following insertion, updating and deletion of data)
        showAllGigs();
        
    }
    
    private static void showGig(int gigID) throws SQLException{
        //created new DAO Object
        gigDAO gDAO = new gigDAO();
        
        
        
        
        
    }
    
    private static void showAllGigs(){
        //created new DAO Object
        gigDAO gDAO = new gigDAO();
        
        
        //outputs the array containing all the gigs in the database
        System.out.println("\n______Printing all Gigs___________");
        System.out.println(gDAO.getAllGigs().toString());
        
    }
    
    private static void enterGig(Gig gig1) throws SQLException{
        //created new DAO Object
        gigDAO gDAO = new gigDAO();
        
        System.out.println("\n-----------------Inserting new Gig----------------");
        gDAO.insertGig(gig1);
    }
    
    private static void editGig(int gigID) throws SQLException{
        //created new DAO Object
        gigDAO gDAO = new gigDAO();
        
        //updates the gig
        //gDAO.updateGig(1);
        System.out.println("\n-------------------The following Gig has been Updated------------\n");
    }
    
    private static void removeGig(int gigID) throws SQLException{
        //created new DAO Object
        gigDAO gDAO = new gigDAO();
        
        //deletes a gig from the database
        gDAO.deleteGig(gigID);
        System.out.println("\n-----------1 Gig Deleted.------------\n");
    }
}
