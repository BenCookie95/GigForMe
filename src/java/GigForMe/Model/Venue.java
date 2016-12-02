/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Model;


public class Venue {
    
    private int venueID;
    private String venueName;
    private int capacity;
    private String latitude;
    private String longitude;
    
    public Venue(int venueID, String venueName, int capacity){
        this.venueID = venueID;
        this.venueName = venueName;
        this.capacity = capacity;
    
    }
    public Venue(){
        
    }
    
    public Venue(int venueID, String venueName){
        this.venueID = venueID;
        this.venueName = venueName;
        
    }
    
    public Venue(String venueName, int capacity){
        this.venueName = venueName;
        this.capacity = capacity;
    }
    public Venue(String venueName, int capacity, String Latitude, String Longitude){
        this.venueName = venueName;
        this.capacity = capacity;
        this.latitude = Latitude;
        this.longitude = Longitude;
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
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    @Override
   public String toString() {
       String vid=venueID +"";
       String arrayOutput = "\nVenue ID: " + vid + ". Name: " + venueName + ". Capacity: " + capacity;
       return arrayOutput;
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
    
}
