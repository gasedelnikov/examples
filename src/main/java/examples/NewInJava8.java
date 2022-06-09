package examples;

import examples.interfaces.ExampleInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author GASedelnikov
 */
public class NewInJava8 implements ExampleInterface {

    @Override
    public void start() {
        interface_default();
        lambda();
        functionalInterface();
        
    }
   
    public void functionalInterface(){
        Converter<String, Integer> converter1 = (from) -> Integer.valueOf(from);
        Integer converted1 = converter1.convert("123");
        
        Converter<String, String> converter2 = (from) -> Integer.toBinaryString(Integer.valueOf(from)) ;
        String converted2 = converter2.convert("123");        
        
        printResult(converted1.toString());    // 123 
        printResult(converted1 + " toBinary: " + converted2);        
    }
    
    public void lambda(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        printResult(names.toString());
        
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });      
        
        printResult(names.toString());
        
        names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> b.compareTo(a));    
        printResult(names.toString());        
    }
    
    public void interface_default() {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return a * a;
            }
        };
       
        Formula formula2 = (int a) -> a * a;        
        
        printResult("formula1 " + formula1.calculate(11)+ " " + formula1.sqrt(121));
        printResult("formula2 " + formula2.calculate(11)+ " " + formula1.sqrt(121));
    }      
}

interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}