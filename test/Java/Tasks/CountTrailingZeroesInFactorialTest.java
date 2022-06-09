package Java.Tasks;

import static examples.tasks.CountTrailingZeroesInFactorial.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Тест метода получения кол-ва нулей в факториале числа
 * @author GASedelnikov
 */
public class CountTrailingZeroesInFactorialTest {
    
    @Test
    public void countZeroesInFactorial_SimpleValues() {
        assertEquals(0,   сountTrailingZeroesInFactorial(0));        
        assertEquals(0,   сountTrailingZeroesInFactorial(4));        
        assertEquals(1,   сountTrailingZeroesInFactorial(5));        
        assertEquals(3,   сountTrailingZeroesInFactorial(15));        
        assertEquals(6,   сountTrailingZeroesInFactorial(25));        
        assertEquals(7,   сountTrailingZeroesInFactorial(32));        
        assertEquals(24,  сountTrailingZeroesInFactorial(100));        
        assertEquals(31,  сountTrailingZeroesInFactorial(125));        
        assertEquals(49,  сountTrailingZeroesInFactorial(200));        
        assertEquals(156, сountTrailingZeroesInFactorial(625));        
    }
    
    @Test
    public void countZeroesInFactorial_TwoMetods() {
        int i = 10000; 
        assertEquals(сountTrailingZeroesInFactorial_usingCycles(i), сountTrailingZeroesInFactorial(i));        
        i = 20000; 
        assertEquals(сountTrailingZeroesInFactorial_usingCycles(i), сountTrailingZeroesInFactorial(i));         
        i = 520000; 
        assertEquals(сountTrailingZeroesInFactorial_usingCycles(i), сountTrailingZeroesInFactorial(i));        
        i = Integer.MAX_VALUE; 
        assertEquals(сountTrailingZeroesInFactorial_usingCycles(i), сountTrailingZeroesInFactorial(i));             
    }    

    @Test
    public void countZeroesInFactorial_NegativeValue() {
        try {
            сountTrailingZeroesInFactorial(-1); 
            fail();
        } catch (IllegalArgumentException s) {
        }      
    }    

    @Test
    public void countZeroesInFactorial_NegativeValueUsingCycles() {
        try {
            сountTrailingZeroesInFactorial_usingCycles(-1); 
            fail();
        } catch (IllegalArgumentException s) {
        }      
    }      
}
