
package GigForMe.Model;


public class Vote {
 
    private int voteID;
    private int userID;
    private int gigID;
    
    public Vote(int voteId, int userID, int gigID){
        this.voteID = voteID;
        this.userID = userID;
        this.gigID = gigID;
    }

    /**
     * @return the voteID
     */
    public int getVoteID() {
        return voteID;
    }

    /**
     * @param voteID the voteID to set
     */
    public void setVoteID(int voteID) {
        this.voteID = voteID;
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
    
}
