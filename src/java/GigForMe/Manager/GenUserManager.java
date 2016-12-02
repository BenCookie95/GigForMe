/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Manager;

import GigForMe.DAO.userDAO;
import GigForMe.Model.User;

/**
 *
 * @author Ben
 */
public class GenUserManager {
    public User loginUser(String username, String passWord){
        
        userDAO userDAO = new userDAO();
        User user = userDAO.getGenUser(username);
       
        
        if(user.getUsername() == null){
            return null;
        }else{
            //System.out.println("The user password is: " + user.getPassword() + " " + user.getIsAdmin());
            if (user.getPassword().equals(passWord)){
                return user;
            }
            else return null;
        }
    }
}
