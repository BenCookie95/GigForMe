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
public class StringUtils {
    public static boolean isStringEmpty(String input){
        if (input == null){
            return true;
        }
        else if (input.length()==0){
            return true;
        }
        else return false;
    }
    public static boolean isNumeric(String input){
         try
            { int i = Integer.parseInt(input); return true; }

        catch(NumberFormatException er)
        { return false; }
    }
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
