package examples.tasks;

import examples.interfaces.ExampleInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Поиск элемента массива, сумма элементов слева которого строго равна сумме элементов справа
 * @author GASedelnikov
 */
public class Arr_MiddleElement implements ExampleInterface{
    
    @Override
    public void start(){
        startAndPrint(new int[]{-3,2,-1,-3,5,20, 5, 11, -5, 0, 7, -1, 7, 8, 2, -9, 1, -2, 1, -25, 5, 5, 15});
        startAndPrint(new int[]{5, 1, 1});
        startAndPrint(new int[]{});
    }     
    
    private void startAndPrint(int[] inArr){
        printResult("");
        printResult("inArr:" + Arrays.toString(inArr)); 
        printResult("MiddleElements :" + Arrays.toString(middleElement(inArr)));
    }    
    
    public int[] middleElement(int[] inArr){
        List<Integer> result = new ArrayList();
        if (inArr != null && inArr.length > 0){
            int sum = 0;
            for (int i=0; i < inArr.length; i++){
                sum+= inArr[i];
            }        
            int sumL = 0;
            for (int i=0; i < inArr.length; i++){
                if (sumL == sum - sumL -inArr[i]){
                    result.add(i);
                }
                sumL += inArr[i];
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }      

}
