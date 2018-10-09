package Java.XXX_OLD.Generics;

/**
 *
 * @author g_sedelnikov
 */
public class ClassB extends ClassA{
    private int B;

    public ClassB() {
    }
    
    public ClassB(int B) {
        this.B = B;
    }
    
    public int getB() {
        return B;
    }

    public void setB(int B) {
        this.B = B;
    }
    
    @Override
    public String toString(){
       return " " + B; 
    }
    
}