package Java.XXX_OLD.Lambda;

/**
 *
 * @author g_sedelnikov
 */
@FunctionalInterface
public interface FunctInterface_1_params {
    void printX(String str);    
    default String getFirstName() { return "FunctInterface_1_params"; }
}
