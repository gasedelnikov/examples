package Java.XXX_OLD.Lambda;

/**
 *
 * @author g_sedelnikov
 */
public interface DefaultInterface extends FunctInterface_1_params, FunctInterface_2_params{
    
    @Override
    default String getFirstName() { return FunctInterface_1_params.super.getFirstName(); };
// или  default String getFirstName() { return FunctInterface_2_params.super.getFirstName(); };

    
}
