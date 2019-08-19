
package Java.Serializable;

import examples.ExampleInterface ;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author GASedelnikov
 */
public class TestSerializable implements ExampleInterface{

    @Override
    public void start() {
        String fileName = "C:\\Home\\temp.out";
        
        ClassAB before = new ClassAB();
        printResult("before: " + before.toString());  
        simpleWrite(before, fileName);
        
        ClassAB after = (ClassAB) simpleRead(fileName);
         printResult("after: " + after.toString());
    }    
    
    public void simpleWrite(Object obj, String fileName) {
        try  {
            FileOutputStream fos = new FileOutputStream(fileName);          
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(obj);
                oos.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    private Object simpleRead(String fileName) {
        Object result = null;
        try  {    
            FileInputStream fis = new FileInputStream(fileName); 
            ObjectInputStream oin = new ObjectInputStream(fis);
            result = oin.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);              
        }
        return result;
    }


}


