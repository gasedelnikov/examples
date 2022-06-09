package examples.tasks;

import examples.interfaces.ExampleInterface;
import java.util.Arrays;

/**
 * Поиск элемента сортированного массива по значению
 * @author GASedelnikov
 */
public class Arr_GetIndexInSortedArr implements ExampleInterface{
    
    @Override
    public void start(){
        startAndPrint(new int[]{1, 2, 3, 5, 6, 11, 20}, 20);        
        startAndPrint(new int[]{1, 2, 3, 5, 6, 11, 20}, 1);        
        startAndPrint(new int[]{1, 2, 3, 5, 6, 11, 20}, 99);        
        startAndPrint(new int[]{-11, -5, 1, 2, 3, 5, 6, 11, 20}, 11);        
    }  
    
    private void startAndPrint(int[] inArr, int value){
        printResult("value = " + value + 
                    "; inArr: " + Arrays.toString(inArr)+ 
                    "; index = " + getIndexInSortedArr(inArr, value));        
    }    
        
    public int getIndexInSortedArr(int[] inArr, int value){
        int result = -1;
        if ((inArr != null) && (inArr.length > 0)){
            int index1 = 0; 
            int index2 = inArr.length -1;
            boolean notFound = true;
            while (notFound){
                result = (index1 + index2) / 2;
                int comp = value - inArr[result];
                if (comp == 0){
                    notFound = false;
                }
                else{
                    if (index1 == index2){
                        notFound = false;
                        result = -1;
                    }
                    else{
                        if (comp > 0){
                            index1 = result+1;
                        }
                        else{
                            index2 = result-1;
                        }
                    }
                }
            } 
        }
        return result;
    }    
}
