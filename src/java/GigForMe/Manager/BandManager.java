/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Manager;

import GigForMe.DAO.bandDAO;
import GigForMe.DAO.userDAO;
import GigForMe.Model.Band;
import GigForMe.Model.User;

/**
 *
 * @author Ben
 */
public class BandManager {
    public Band loginBand(String username, String passWord){
        
        bandDAO bandDAO = new bandDAO();
        Band band = bandDAO.getBandUsername(username);
       
        
        if(band.getUsername() == null){
            return null;
        }else{
            //System.out.println("The user password is: " + user.getPassword() + " " + user.getIsAdmin());
            if (band.getPassword().equals(passWord)){
                return band;
            }
            else return null;
        }
    }
}
