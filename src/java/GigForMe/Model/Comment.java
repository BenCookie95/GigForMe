/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Model;

import GigForMe.*;


public class Comment {
    private int commentID;
    private int userID;
    private int bandID;
    private int gigID;
    private String comment;
    private String username;
    private String picdir;
    private String Name;
    
   public Comment(int commentID, int userID, int gigID, int bandID, String comment){
       this.commentID = commentID;
       this.userID = userID;
       this.gigID = gigID; 
       this.bandID = bandID;
       this.comment = comment;
       
   }
   public Comment(){
       
   }
    /**
     * @return the commentID
     */
    public int getCommentID() {
        return commentID;
    }

    /**
     * @param commentID the commentID to set
     */
    public void setCommentID(int commentID) {
        this.commentID = commentID;
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
     * @return the gigID
     */
    public int getGigID() {
        return gigID;
    }

    /**
     * @param gigID the gigID to set
     */
    public void setGigID(int gigID) {
        this.gigID = gigID;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
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
     * @return the picdir
     */
    public String getPicdir() {
        return picdir;
    }

    /**
     * @param picdir the picdir to set
     */
    public void setPicdir(String picdir) {
        this.picdir = picdir;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }
   
   
}
