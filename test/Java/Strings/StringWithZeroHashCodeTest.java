package Java.Strings;

import examples.strings.StringWithZeroHashCode;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class StringWithZeroHashCodeTest {
    private static final int cntIterations = 1000000;
    
    @Test    
    public void getStringWithTheSameHashCodeTest() {
        StringWithZeroHashCode instance = new StringWithZeroHashCode();
        getStringWithTheSameHashCodeTest(instance, "ts_ab"  , 100);
        getStringWithTheSameHashCodeTest(instance, "a"      , 100);
        getStringWithTheSameHashCodeTest(instance, ""       , 100);
    }    

    public void getStringWithTheSameHashCodeTest(StringWithZeroHashCode instance, String str, int cnt) {
        String[] arr =  instance.getStringWithTheSameHashCode(str, cnt); 
        int hc = str.hashCode();
        for (int i =0; i< cnt; i++){
            if (arr[i] != null){ 
                assertEquals("i = "+i+"; str = "+arr[i], hc, arr[i].hashCode());
                assertEquals(false, str.equals(arr[i]));
            }
        } 
        for (int i=0; i < cnt; i++){
            for (int j=i+1; j < cnt; j++){
                if (arr[i] != null && arr[j] != null){ 
                    assertEquals(false, arr[i].equals(arr[j]));
                }    
            }          
        }          
    }      
    
    @Test    
    public void getStringWithZeroHashCodeTest() {
        StringWithZeroHashCode instance = new StringWithZeroHashCode();        
        for (int i =0; i< cntIterations; i++){
            int hc = Math.round((float)Math.random() * Integer.MAX_VALUE);
            int max = Math.round((float)Math.random() * Character.MAX_VALUE / 31);
            if (max == 0){
               max = 1;
            }
            String str = instance.getStringByHashCode(hc, max);
            assertEquals(0, instance.getStringWithZeroHashCode(str).hashCode());         
        }        
    }

    @Test
    public void getStringByHashCodeTest() {
        StringWithZeroHashCode instance = new StringWithZeroHashCode();
        for (int i =0; i< cntIterations; i++){
            int hc = Math.round((float)Math.random() * Integer.MAX_VALUE);
            int max = Math.round((float)Math.random() * Character.MAX_VALUE / 31);
            if (max == 0){
               max = 1;
            }
       
            assertEquals("Ошибка! inHashCode = "+ hc+"; multipleOfFactor = " + max,  hc, instance.getStringByHashCode( hc, max).hashCode());         
            assertEquals("Ошибка! inHashCode = "+-hc+"; multipleOfFactor = " + max, -hc, instance.getStringByHashCode(-hc, max).hashCode());         
        }
    }

    
}
