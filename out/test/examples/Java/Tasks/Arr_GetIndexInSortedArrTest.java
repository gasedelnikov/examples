package Java.Tasks;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GASedelnikov
 */
public class Arr_GetIndexInSortedArrTest {
 
    @Test
    public void getIndexInSortedArr_last(){
        Arr_GetIndexInSortedArr instance = new Arr_GetIndexInSortedArr();
        int pos = instance.getIndexInSortedArr(new int[]{1, 2, 3, 5, 6, 11, 20}, 20);
        assertEquals(6, pos);
    }
    
    @Test
    public void getIndexInSortedArr_first(){
        Arr_GetIndexInSortedArr instance = new Arr_GetIndexInSortedArr();
        int pos = instance.getIndexInSortedArr(new int[]{1, 2, 3, 5, 6, 11, 20}, 1);
        assertEquals(0, pos);
    }    
    
    @Test
    public void getIndexInSortedArr_midle(){
        Arr_GetIndexInSortedArr instance = new Arr_GetIndexInSortedArr();
        int pos = instance.getIndexInSortedArr(new int[]{1, 2, 3, 5, 6, 11, 20}, 5);
        assertEquals(3, pos);
    }     
    
    @Test
    public void getIndexInSortedArr_notFound(){
        Arr_GetIndexInSortedArr instance = new Arr_GetIndexInSortedArr();
        int pos = instance.getIndexInSortedArr(new int[]{1, 2, 3, 5, 6, 11, 20}, 7);
        assertEquals(-1, pos);
    }  
    
    @Test
    public void getIndexInSortedArr_null(){
        Arr_GetIndexInSortedArr instance = new Arr_GetIndexInSortedArr();
        int pos = instance.getIndexInSortedArr(null, 7);
        assertEquals(-1, pos);
    }     
    
}
