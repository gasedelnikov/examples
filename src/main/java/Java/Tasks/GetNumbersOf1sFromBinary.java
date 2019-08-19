package Java.Tasks;

import examples.ExampleInterface;

/**
 * Поиск количества единиц в двоичном представлении числа
 * @author GASedelnikov
 */
public class GetNumbersOf1sFromBinary implements ExampleInterface{

    @Override
    public void start() {
        startAndPrint(1);
        startAndPrint(7);
        startAndPrint(15);
        startAndPrint(16);
        startAndPrint(-15);     
    }
    
    private void startAndPrint(int value){
        printResult("value = " + value + 
                   "; Binary = " + Integer.toBinaryString(value) +
                   "; Numbers Of 1-s From Binary = " + get1sFromBinary(value));        
    }      
    
    private int get1sFromBinary(int num){
        int result = 0;
        while (num != 0){
            result += num & 1;
            num = num >>> 1;            
        }
        return result;
    }    
    
}
