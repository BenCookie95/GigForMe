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
public class UserManager {
     /** This will take a username and select from user table
     * This will return three possible statuses, login correct, 
     * unknown user or password incorrect
     * @param inUser 
     */
    public User loginUser(String username, String passWord){
        
        userDAO userDAO = new userDAO();
        User user = userDAO.getTheUser(username);
       
        String thepassword = "password";
        if(user == null){
            return null;
        }else{
            System.out.println("The user password is: " + user.getPassword() + " " + user.getIsBanned());
            if (user.getPassword().equals(passWord)){
                return user;
            }
            else return null;
        }
    }
}
