/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Model;

import GigForMe.*;
import java.io.Serializable;

public class User implements Serializable {
    
    private int userID;
    private String username;
    private String name;
    private String bio;
    private String picDir;
    private String email;
    private String password;
    private String isAdmin;
    private String isBanned;
    

    public User(int userID,String name){
        this.userID = userID;
        this.name = name;
    }
    
    public User(String userName,String Name, String bio, String picDir, String email){
        this.username = userName;
        this.name = Name;
        this.bio = bio;
        this.picDir = picDir;
        this.email = email;
    }
    
    public User(int userID1, String userName,String Name, String bio, String picDir, String email){
        this.userID = userID1;
        this.username = userName;
        this.name = Name;
        this.bio = bio;
        this.picDir = picDir;
        this.email = email;
    }
    
    public User(){
        
    }
    
    public User(String userName,String Name, String bio, String email, String picDir, String isADmin, String password){
        
        this.username = userName;
        this.name = Name;
        this.bio = bio;
        this.email = email;
        this.picDir = picDir;
        this.isAdmin = isADmin;
        this.password = password;
        
        
    }

    public User(int userID, String Username, String name, String bio, String email, String picDir, String isAdmin, String password) {
        this.userID = userID;
        this.username = Username;
        this.name = name;
        this.bio = bio;
        this.email = email;
        this.picDir = picDir;
        
        this.isAdmin = isAdmin;
        this.password = password;
        
    }
    public User(int userID, String Username, String name, String bio, String email, String picDir, String password) {
        this.userID = userID;
        this.username = Username;
        this.name = name;
        this.bio = bio;
        this.email = email;
        this.picDir = picDir;
        this.password = password;      
    }
    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * @return the picDir
     */
    public String getPicDir() {
        return picDir;
    }

    /**
     * @param picDir the picDir to set
     */
    public void setPicDir(String picDir) {
        this.picDir = picDir;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the isAdmin
     */
    public String getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
       /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
  
    @Override
   public String toString() {
       String uid=userID +"";
       String arrayOutput = "\nUserID: " + uid + "." + " Name: " + name;
       return arrayOutput;
   }

    /**
     * @return the isBanned
     */
    public String getIsBanned() {
        return isBanned;
    }

    /**
     * @param isBanned the isBanned to set
     */
    public void setIsBanned(String isBanned) {
        this.isBanned = isBanned;
    }
    
}
