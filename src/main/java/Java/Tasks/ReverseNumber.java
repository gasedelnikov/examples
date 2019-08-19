package Java.Tasks;

import examples.ExampleInterface;

/**
 * Получение полиндрома числа
 * @author GASedelnikov
 */
public class ReverseNumber implements ExampleInterface{

    @Override
    public void start() {
        startAndPrint(12345);
        startAndPrint(1000);
        startAndPrint(10001);
        startAndPrint(1200);
        startAndPrint(-15);   
        startAndPrint(-1500);  
        startAndPrint(Integer.MAX_VALUE); 
        startAndPrint(Integer.MIN_VALUE); 
    }
    
    private void startAndPrint(int value){
        printResult("value = " + value + 
                   "; ReverseNumber = " + reverseNumber(value));        
    }      
    
    private long reverseNumber(int num){
        long result = 0;
        while (num != 0){
            result = result * 10 + num % 10;
            num /= 10;            
        }
        return result;
    }    
    
}
