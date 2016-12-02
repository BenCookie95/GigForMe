/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GigForMe.TestClasses;

import GigForMe.DAO.userDAO;
import GigForMe.Database.DBManager;
import GigForMe.Database.SetupDb;
import GigForMe.Model.User;
import java.sql.SQLException;

/**
 *
 * @author BEmerson
 */
public class UserDAOTest {

    
            
    public static void main(String[] args) throws SQLException {
        DBManager mngr = new DBManager();
        mngr.checkConnection();
        
        SetupDb sdb = new SetupDb();
        sdb.createTables();
        sdb.insertSetupData();
      
        //creates new DAO Object
        userDAO uDAO= new userDAO();
        
        //show a user
        showUser(1);
        
        //show all users
        showAllUsers();
        
        //create new user object and insert into the Database
        User user1 = new User("JWalters","Jon Walters","Footballer and Music Enthusiast","jonWal@hotmail.com","ww.google.com","NO","jonWalters123");
        
        //enter new user into the database
        enterUser(user1);
        
        //shows all users following the user update
        showAllUsers();
        
        //create new user object and insert into the Database
        User user2 = new User("RBrady","Robbie Brady","Music Fan est. 1990","robbieB@hotmail.com","ww.google.com","NO","RBrady999");
        
        //enter new user into the database
        enterUser(user2);
        
        //shows all users following the user update
        showAllUsers();
                
        //deletes a user
        removeUser(1);
        
        //show all users follwing deletion
        showAllUsers();
        
        //updates a user
        editUser(4);
        
        //shows all users following the user update
        showAllUsers();
        
    }
    
        private static void showUser(int userID) throws SQLException{
            //creates new DAO Object
            userDAO uDAO= new userDAO();
        
            System.out.println("\n _________Printing a User____________________");
            System.out.println(uDAO.getUser(1));
        }
        
         private static void showAllUsers(){
             //creates new DAO Object
            userDAO uDAO= new userDAO();
            
            System.out.println("\n _________Printing all Users____________________");
            System.out.printf(uDAO.getAllUsers().toString());
            
         }
         
         private static void enterUser(User user) throws SQLException{
             //creates new DAO Object
             userDAO uDAO= new userDAO();
            
             //uDAO.insertUser(user);
         }
         
         private static void removeUser(int id) throws SQLException{
             
             //creates new DAO Object
             userDAO uDAO= new userDAO();
            
             //deletes a user from the database
             System.out.println("\n\nDeleting User");
             uDAO.deleteUser(id);
         }
         
         private static void editUser(int id) throws SQLException{
             //creates new DAO Object
            userDAO uDAO= new userDAO();
            
             System.out.println("\n\nUpdating User\n");
             //uDAO.updateUser(id);
         }
    }
    