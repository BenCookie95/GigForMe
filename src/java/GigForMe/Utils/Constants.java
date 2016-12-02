/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigForMe.Utils;

/**
 *
 * @author Ben
 */
public interface Constants {
    //User Types
    public static final String USER_TYPE_ADMIN = "TRUE";
    public static final String USER_TYPE_GENERAL_USER = "FALSE";
    public String userfilepath = "C://Users//113491948//Downloads//GigForMe//GigForMe//";
    
    
    //Session Keys
    public String SESSION_ADMIN = "Admin";
    public String SESSION_GENUSER = "USER";
    public String SESSION_BAND = "BAND";
    public static final String SESSION_KEY_ALL_USERS = "SKALLUSERS";
    public static final String SESSION_KEY_ALL_VENUES = "SKALLVENUES";
    public static final String SESSION_KEY_ALL_GIGS = "SKALLGIGS";
    public static final String SESSION_KEY_ALL_BANDS = "SKALLBANDS";
    public static final String SESSION_KEY_USER = "SKUSER";
    public static final String SESSION_KEY_BAND = "SKBAND";
    public static final String SESSION_KEY_GIGEDIT = "SKGIGEDIT";
    
    public static final String SESSION_KEY_ALL_CONFIRMEDGIGS = "SKALLCGIGS";
    public static final String SESSION_KEY_ALLGIGS = "ALLGIGS";
    public static final String SESSION_KEY_ALLUSERGIGS = "ALLUSERGIGS";
    public static final String SESSION_KEY_GIG = "SKGIG";
    public static final String SESSION_KEY_COMMENT = "SKCOMMENT";
    public static final String SESSION_KEY_VIEWUSER = "SKVIEWUSER";
    
    public static final String SESSION_KEY_ALLBANDGIGS = "ALLBANDGIGS";
}
