package Java.XXX_OLD.Generics;

/**
 *
 * @author g_sedelnikov
 */
public class ClassA {
    private int A;

    public ClassA() {
    }
    
    public ClassA(int A) {
        this.A = A;
    }
    
    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
    }
    
    @Override
    public String toString(){
       return " " + A; 
    }
    
    
}
