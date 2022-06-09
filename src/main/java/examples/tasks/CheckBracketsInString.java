package examples.tasks;

import examples.interfaces.ExampleInterface;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Проверка правильности расстановки скобок в строке
 * @author GASedelnikov
 */
public class CheckBracketsInString implements ExampleInterface{

    @Override
    public void start() {
        startAndPrint("12345");        
        startAndPrint("1(2345");
        startAndPrint("1(23)45");        
        startAndPrint("1(2[3)45");        
        startAndPrint("1(2[]3)45");        
        startAndPrint("1(2[]3){45");        
        startAndPrint("1(2[]3){45}");    
        
        startAndPrint("1({2[}]3){45}");    
        startAndPrint("(((}}]");   
        startAndPrint("()");         
        startAndPrint("(");         
        startAndPrint(")");      
        startAndPrint("");          
        
        startAndPrint(null);   
        
        printResult("result = " + checkBracketsInString("aa", new char[]{'a'}, new char[]{'a'}));         
        
//        checkBracketsInString("(((}}]", null, new char[]{']','}',')'});  
//        checkBracketsInString("(((}}]", new char[] {'['}, null);  
//        checkBracketsInString("(((}}]", new char[] {'['}, new char[]{']','}',')'});          
    }    
    
    private void startAndPrint(String text){
        printResult("result = " + checkBracketsInString(text)+ "; value = '" + text +"'");        
    }      
    
    public Boolean checkBracketsInString(String text){
        return checkBracketsInString(text, new char[] {'[','{','('}, new char[]{']','}',')'});
    }    
    
    public Boolean checkBracketsInString(String text, char[] leftBrackets, char[] rigthBrackets) throws IllegalArgumentException{
        if (text == null){
            return null;
        }
        if (leftBrackets == null || rigthBrackets == null || leftBrackets.length != rigthBrackets.length){
            throw new IllegalArgumentException("Error. Check that leftBrackets != null && rigthBrackets != null && leftBrackets.length = rigthBrackets.length!");
        }        
        
        boolean result = true;    
        Deque<Character> queue = new ArrayDeque();        
        
        char[] stringToCharArray = text.toCharArray() ;
        int c = 0;
        while (result && c < stringToCharArray.length) {
            char output = stringToCharArray[c++];
            for (char left : leftBrackets){ 
                if (left == output){
                    queue.addLast(output);
                }
            }
            
            for (int i =0; i < rigthBrackets.length; i++){ 
                if (rigthBrackets[i] == output){
                    if (queue.peekLast() != null && queue.peekLast() == leftBrackets[i]){
                        queue.pollLast();
                    }
                    else {
                        result = false; 
                    }
                }
            }          
        }
        return result && queue.isEmpty();
    }     
}