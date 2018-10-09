package Java.XXX_OLD.Generics;

/**
 *
 * @author g_sedelnikov
 */
public class ClassC extends ClassB{
    private int C;

    public ClassC() {
    }
    
    public ClassC(int C) {
        this.C = C;
    }
    
    public int getC() {
        return C;
    }

    public void setC(int C) {
        this.C = C;
    }
    
    @Override
    public String toString(){
       return " " + C; 
    }    
}