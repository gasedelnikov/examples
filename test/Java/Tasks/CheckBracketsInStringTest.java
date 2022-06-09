package Java.Tasks;

import examples.tasks.CheckBracketsInString;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GASedelnikov
 */
public class CheckBracketsInStringTest {
    
    @Test
    public void testCheckBracketsInString_positive() {
        CheckBracketsInString instance = new CheckBracketsInString();
            assertEquals(true, instance.checkBracketsInString("12345"));        
            assertEquals(true, instance.checkBracketsInString("1(23)45"));        
        assertEquals(true, instance.checkBracketsInString("1(2[]3)45"));        
        assertEquals(true, instance.checkBracketsInString("1(2[]3){45}"));           
        assertEquals(true, instance.checkBracketsInString("()"));         
        assertEquals(true, instance.checkBracketsInString(""));    
        assertEquals(true, instance.checkBracketsInString("1a2c5d2b", new char[]{'a','c'}, new char[]{'b','d'})); 
        assertEquals(true, instance.checkBracketsInString("1a2c5d2b", new char[]{}, new char[]{})); 
        assertEquals(true, instance.checkBracketsInString("a", new char[]{'a'}, new char[]{'a'}));         
        assertEquals(true, instance.checkBracketsInString("aa", new char[]{'a'}, new char[]{'a'})); 
    }    
    
    @Test
    public void testCheckBracketsInString_negative() {
        CheckBracketsInString instance = new CheckBracketsInString();
        assertEquals(false, instance.checkBracketsInString("1(2345"));
        assertEquals(false, instance.checkBracketsInString("1(2[3)45"));        
        assertEquals(false, instance.checkBracketsInString("1(2[]3){45"));        
        assertEquals(false, instance.checkBracketsInString("1({2[}]3){45}"));    
        assertEquals(false, instance.checkBracketsInString("(((}}]"));   
        assertEquals(false, instance.checkBracketsInString("("));         
        assertEquals(false, instance.checkBracketsInString(")"));      
        assertEquals(false, instance.checkBracketsInString("1a2c5d2b", new char[]{'a','b'}, new char[]{'c','d'})); 
    }

    @Test
    public void testCheckBracketsInString_text_null() {
        CheckBracketsInString instance = new CheckBracketsInString();
        assertEquals(null , instance.checkBracketsInString(null));            
    }    
    
    @Test
    public void testCheckBracketsInString_left_null() {
        CheckBracketsInString instance = new CheckBracketsInString();
        try {
           instance.checkBracketsInString("(((}}]", null, new char[]{']','}',')'}); 
           fail();
        } catch (IllegalArgumentException s) {
        }
    }        
    
    @Test
    public void testCheckBracketsInString_rigth_null() {
        CheckBracketsInString instance = new CheckBracketsInString();
        try {
           instance.checkBracketsInString("(((}}]", new char[]{']','}',')'}, null); 
           fail();
        } catch (IllegalArgumentException s) {
        }
    }    
    
    @Test
    public void testCheckBracketsInString_dif_length() {
        CheckBracketsInString instance = new CheckBracketsInString();
        try {
           instance.checkBracketsInString("(((}}]", new char[]{']','}',')'}, new char[]{']'}); 
           fail();
        } catch (IllegalArgumentException s) {
        }
    }      
}
