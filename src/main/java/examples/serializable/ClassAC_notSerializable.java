package examples.serializable;

import java.io.NotSerializableException;

/**
 *
 * @author GASedelnikov
 */
public class ClassAC_notSerializable extends ClassA{
    public int c = 1;         
       
    private void writeObject(java.io.ObjectOutputStream stream) throws NotSerializableException{
        throw new NotSerializableException();
    }    
    
    private void readObject(java.io.ObjectInputStream stream) throws NotSerializableException{
        throw new NotSerializableException();        
    }      
}
