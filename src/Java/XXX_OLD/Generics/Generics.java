package Java.XXX_OLD.Generics;

/**
 *
 * @author g_sedelnikov
 * @param <T>
 */
public class Generics<T> {
    private T val; 
    
    public Generics() { 

    }
    
    public void set(T val){
       this.val = val; 
    }

    public T getVal() {
        return val;
    }
    
}
