/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Model;

/**
 *
 * @author Ben
 */
public class UserError {
    private String blankField = "You left a required field blank";
    private String incorrectLoginDetail = "Your username or password was incorrect";
    private String capError = "Your value for capacity wasn't numeric";
    private String priceError = "Your price must be a numeric value";
    /**
     * @return the blankField
     */
    public String getBlankField() {
        return blankField;
    }

    /**
     * @param blankField the blankField to set
     */
    public void setBlankField(String blankField) {
        this.blankField = blankField;
    }

    /**
     * @return the incorrectLoginDetail
     */
    public String getIncorrectLoginDetail() {
        return incorrectLoginDetail;
    }

    /**
     * @param incorrectLoginDetail the incorrectLoginDetail to set
     */
    public void setIncorrectLoginDetail(String incorrectLoginDetail) {
        this.incorrectLoginDetail = incorrectLoginDetail;
    }

    /**
     * @return the capError
     */
    public String getCapError() {
        return capError;
    }

    /**
     * @param capError the capError to set
     */
    public void setCapError(String capError) {
        this.capError = capError;
    }

    /**
     * @return the priceError
     */
    public String getPriceError() {
        return priceError;
    }

    /**
     * @param priceError the priceError to set
     */
    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }
}
