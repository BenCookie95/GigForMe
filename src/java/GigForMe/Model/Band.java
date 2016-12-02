/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Model;

import java.io.Serializable;


public class Band implements Serializable {
    
    private int bandID;
    private String username;
    private String bandName;
    private String bio;
    private String picDir;
    private String email;
    private String password;
    
    public Band(){
        
    }
  public Band(int bandID,String BandName){
        this.bandID = bandID;
        this.bandName = BandName;
        
  }
  
  
    public Band(String Name, String email, String userName,String PicDir, String password1){
        this.bandName = Name;
        this.email = email;
        this.username = userName;
        
        this.picDir = PicDir;
        this.password = password1;
        
    }
    public Band(String email1, String name, String username1, String password1){
        this.email = email1;
        this.bandName = name;
        this.username = username1;
        this.password = password1;
    }
    public Band(int bandid, String Username, String bname, String BIO, String Email, String upDir, String Password){
        this.bandID = bandid;
        this.username = Username;
        this.bandName = bname;
        this.bio = BIO;
        this.email = Email;
        this.picDir = upDir;
        this.password = Password;
    }
    /**
     * @return the bandID
     */
    public int getBandID() {
        return bandID;
    }

    /**
     * @param bandID the bandID to set
     */
    public void setBandID(int bandID) {
        this.bandID = bandID;
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
     * @return the bandName
     */
    public String getBandName() {
        return bandName;
    }

    /**
     * @param bandName the bandName to set
     */
    public void setBandName(String bandName) {
        this.bandName = bandName;
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
}
