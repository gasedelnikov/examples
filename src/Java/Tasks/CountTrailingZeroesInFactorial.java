package Java.Tasks;

import examples.ExampleInterface;

/**
 * Получение кол-ва нулей в конце факториала числа
 * @author GASedelnikov
 */
public class CountTrailingZeroesInFactorial implements ExampleInterface{

    @Override
    public void start() {
        startAndPrint(0);  // 0        
        startAndPrint(4);  // 0               
        startAndPrint(5);  // 1        
        startAndPrint(25);  // 6
        startAndPrint(5*5*5);  // 31
        startAndPrint(5*5*5*5);  // 156

        startAndPrint(15);  // 3 
        startAndPrint(100); // 24        
        startAndPrint(200); //  49      
        startAndPrint(20000);    
        startAndPrint(520000);    
        startAndPrint(Integer.MAX_VALUE);         
    }
    
    private void startAndPrint(int value){
        printResult("value = " + value + "; countZeroesInFactorial2 = " + сountTrailingZeroesInFactorial(value) + "; " + сountTrailingZeroesInFactorial_usingCycles(value));        
    }      
    
    public static int сountTrailingZeroesInFactorial(int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException("value must be positive");
        }
        int result = 0;        
        int k = (int) Math.round(Math.log10(value) / Math.log10(5));
        for (int i=1; i <= k; i++){
            result += value / Math.pow(5, i);
        }
        
        return result;
    }    
    
    public static int сountTrailingZeroesInFactorial_usingCycles(int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException("value must be positive");
        }
        int result = 0;
        for (int i=5;(i > 0) && (i <= value);i=i+5){
            result += countZeroes(i);
        }
        return result;        
    }    
    
    private static int countZeroes(int value){
 	int result = 0;
	while (value >= 5 && value % 5 == 0) {
            value = value / 5;
	    result++;
	}
 	return result;
    }    
    
}
