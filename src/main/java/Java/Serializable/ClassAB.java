package Java.Serializable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author GASedelnikov
 */
public class ClassAB extends ClassA implements Serializable{
    private static final long SerialVersionUID = 11;       
    
    public int b = 1; 
    private int secretField = 11; 
    private transient int transientField = 121; 

    private void writeObject(ObjectOutputStream stream) throws java.io.IOException{
        secretField = secretField << 2; // obscure the sensitive data
        stream.defaultWriteObject();
        secretField = secretField >> 2;        
    }    
    
    private void readObject(ObjectInputStream stream) throws java.io.IOException, ClassNotFoundException{
        stream.defaultReadObject();
        secretField = secretField >> 2;  // de-obscure the sensitive data         
    }    
    
    @Override
    public String toString(){
        return " secretField = " + secretField + "; transientField = " + transientField;
    }     
}
