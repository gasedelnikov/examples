package Java.XXX_OLD.Lambda;

/**
 *
 * @author g_sedelnikov
 */
public interface FunctInterface_2_params{
    void printX(String str1, String str2);   
    default String getFirstName() { return "FunctInterface_1_params"; }
}
