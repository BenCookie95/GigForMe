
package GigForMe.Model;

import java.io.Serializable;


public class Gig implements Serializable{
    private int gigID;
    private int venueID;
    private int bandID;
    private int userID;
    private String venueName;
    private String bandName;
    private String username;
    private String gigDescription;
    private String picDir;
    private String dateCreated;
    private String gigDate;
    private double price;
    private String isConfirmed;
    private int votes;
    private String latitude;
    private String longitude;
    private String voteCheck;
    public Gig(){
        
    }
    
    public Gig(int venueID,int bandID, int userID){
        this.venueID = venueID;
        this.bandID = bandID;
        this.userID = userID;
    }
    public Gig(String gigDescription, String venueName, String bandName, String username, String gigDate){
        
        this.gigDescription = gigDescription;
        this.venueName = venueName;
        this.bandName = bandName;
        this.username = username;
        this.gigDate = gigDate;
    }
    public Gig(int gigID, String gigDescription, String venueName, String bandName, String username, String gigDate){
        this.gigID = gigID;
        this.gigDescription = gigDescription;
        this.venueName = venueName;
        this.bandName = bandName;
        this.username = username;
        this.gigDate = gigDate;
    }
    public Gig(int gigID,int venueID,int bandID, int userID, String gigDescription){
        this.gigID = gigID;
        this.venueID = venueID;
        this.bandID = bandID;
        this.userID = userID;
        this.gigDescription = gigDescription;
    }
    
    public Gig(int gigID,int venueID,int bandID, int userID, String gigDescription, String dateCreated, String gigDate, double price){
        this.gigID = gigID;
        this.venueID = venueID;
        this.bandID = bandID;
        this.userID = userID;
        this.gigDescription = gigDescription;
        this.dateCreated = dateCreated;
        this.gigDate = gigDate;
        this.price = price;
    }
    
    public Gig(int venueID,int bandID, int userID, String gigDescription, String dateCreated, String gigDate, double price, String isConfirmed){
        
        this.venueID = venueID;
        this.bandID = bandID;
        this.userID = userID;
        this.gigDescription = gigDescription;
        this.dateCreated = dateCreated;
        this.gigDate = gigDate;
        this.price = price;
        this.isConfirmed = isConfirmed;
    }
    public Gig(int venueID,int bandID, int userID, String gigDescription, String gigDate, double price, String isConfirmed){
        
        this.venueID = venueID;
        this.bandID = bandID;
        this.userID = userID;
        this.gigDescription = gigDescription;
        this.gigDate = gigDate;
        this.price = price;
        this.isConfirmed = isConfirmed;
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
     * @return the venueID
     */
    public int getVenueID() {
        return venueID;
    }

    /**
     * @param venueID the venueID to set
     */
    public void setVenueID(int venueID) {
        this.venueID = venueID;
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
     * @return the gigDescription
     */
    public String getGigDescription() {
        return gigDescription;
    }

    /**
     * @param gigDescription the gigDescription to set
     */
    public void setGigDescription(String gigDescription) {
        this.gigDescription = gigDescription;
    }

   

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the isConfirmed
     */
    public String getIsConfirmed() {
        return isConfirmed;
    }

    /**
     * @param isConfirmed the isConfirmed to set
     */
    public void setIsConfirmed(String isConfirmed) {
        this.isConfirmed = isConfirmed;
    }



    /**
     * @return the dateCreated
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return the gigDate
     */
    public String getGigDate() {
        return gigDate;
    }

    /**
     * @param gigDate the gigDate to set
     */
    public void setGigDate(String gigDate) {
        this.gigDate = gigDate;
    }

    /**
     * @return the venueName
     */
    public String getVenueName() {
        return venueName;
    }

    /**
     * @param venueName the venueName to set
     */
    public void setVenueName(String venueName) {
        this.venueName = venueName;
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
    
    @Override
   public String toString() {
       String gid=gigID +"";
       String arrayOutput = "\nGig ID: " + gid + "\nVenue: " + venueName + "\nBand: " + bandName + "\nCreated By: " + username;
       return arrayOutput;
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
     * @return the votes
     */
    public int getVotes() {
        return votes;
    }

    /**
     * @param votes the votes to set
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the voteCheck
     */
    public String getVoteCheck() {
        return voteCheck;
    }

    /**
     * @param voteCheck the voteCheck to set
     */
    public void setVoteCheck(String voteCheck) {
        this.voteCheck = voteCheck;
    }
}
