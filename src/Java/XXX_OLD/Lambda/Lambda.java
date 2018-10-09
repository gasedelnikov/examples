package Java.XXX_OLD.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author g_sedelnikov 
 */
public class Lambda {
    
    public static void start(){
        FunctInterface_0_params fi_0_0  = new FunctInterface_0_params() {
            @Override
            public void printX() {
                Lambda.metod_0_params();
            }
        };
        final String finalString = "finalString";
        String finalString2 = "finalString"; // она таки final т.к. используется в fi_1_0
//        finalString2 = "sdf"; // в fi_1_0 получим: local variables referenced from a lambda expression must be final or effectively final
        FunctInterface_0_params fi_0_0a = () -> {Lambda.metod_0_params();};        
        FunctInterface_0_params fi_0_1  = () -> Lambda.metod_0_params();  
        FunctInterface_0_params fi_0_2  =   Lambda::metod_0_params; 

        FunctInterface_1_params fi_1_0  = (String firstStr)-> {int i = 1; System.out.println(finalString2 + finalString + firstStr + i); };  
        FunctInterface_1_params fi_1_1  = (String firstStr)-> Lambda.metod_1_params(firstStr);  
        FunctInterface_1_params fi_1_2  =         firstStr -> Lambda.metod_1_params(firstStr);  
        FunctInterface_1_params fi_1_3  =         firstStr -> Lambda.metod_2_params(firstStr, finalString);  
        FunctInterface_1_params fi_1_4  = Lambda::metod_1_params;  

        FunctInterface_2_params fi_2_0  =  (String firstStr, String secondStr) -> {int i = 1; System.out.println(finalString2 + finalString + firstStr + secondStr + i);}; 
        FunctInterface_2_params fi_2_1  =  (String firstStr, String secondStr) -> Lambda.metod_2_params(firstStr, secondStr);  
        FunctInterface_2_params fi_2_2  =  (       firstStr,        secondStr) -> Lambda.metod_2_params(firstStr, secondStr);  
        FunctInterface_2_params fi_2_3  =   Lambda::metod_2_params; 
        FunctInterface_2_params fi_2_4  =  (String firstStr, String secondStr) -> Lambda.metod_1_array(new String[]{firstStr, secondStr});  
        
        Comparator<String> comp0 = (firstStr, secondStr) -> {return firstStr.length() - secondStr.length();};        
        Comparator<String> comp1 = (firstStr, secondStr) -> Integer.compare(firstStr.length(),secondStr.length());        
        Comparator<String> comp2 = Lambda::metod_2_params;            
        
        String arr[] = {"a5","aa2","a1","aa4","a7","a3","a6","a9","aa9","a0"};
//        List<String> list = Arrays.asList(arr);
        Arrays.stream(arr)
            .filter(p -> {return p.length() == 2;})
//            .sorted()
            .sorted((s1, s2) -> {return -s1.compareTo(s2);})
            .forEach(System.out::println);
        
    }
    
    
    public static void metod_1_params(String i){}
    public static void metod_0_params(){}
    public static int metod_2_params(String firstStr, String secondStr){return 1;}    
    public static void metod_1_array(String[] arr){}       
    
}
