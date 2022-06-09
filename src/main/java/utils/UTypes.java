package utils;

/**
 *
 * @author GASedelnikov
 */
public class UTypes {
    

    public static int parseInt(String value, int defValue){    
        int result;
        try {
            result = Integer.parseInt(value); 
        }
        catch (NumberFormatException t) {
            result = defValue;
        }
        return result;   
    }

    public static boolean parseBoolean(String value){    
        return parseBoolean(value, false);
    }      
    
    public static boolean parseBoolean(String value, boolean defValue){    
        boolean result;
        try {
            result = value.equals("1") || value.equals("true"); 
        }
        catch (NullPointerException t) {
            result = defValue;
        }
        return result;   
    }    
    
}
