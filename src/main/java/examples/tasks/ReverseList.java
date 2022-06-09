package examples.tasks;

import examples.interfaces.ExampleInterface;
import java.util.ArrayList;
import java.util.List;

/**
 * Реверсивное изменение ссылок в односвязном списке. Проверка на цикличность связного списка
 * @author GASedelnikov
 */
public class ReverseList implements ExampleInterface{

    @Override
    public void start() {
        ReverseListsElement el5 = new ReverseListsElement(5, null);
        ReverseListsElement el4 = new ReverseListsElement(4, el5);
        ReverseListsElement el3 = new ReverseListsElement(3, el4);
        ReverseListsElement el2 = new ReverseListsElement(2, el3);
        ReverseListsElement el1 = new ReverseListsElement(1, el2);
        ReverseListsElement el0 = new ReverseListsElement(0, el1);
        
        printResult("Start List  : " + el0.getChildString());
        printResult("CycleElement: " + el0.getCycleElement());
        printResult("reverseList : " + reverseListSimple(el0).getChildString());
        
        el0.ref = el5;     
        printResult("");        
        printResult("Start List  : " + el5.getChildString());
        printResult("CycleElement: " + el5.getCycleElement());
        printResult("reverseList : " + reverseListSimple(el0).getChildString());
    }
   
    private ReverseListsElement reverseListSimple(ReverseListsElement e){
        ReverseListsElement eRef = e.ref;
        e.ref = null;
        do {
            ReverseListsElement e2 = eRef;
            eRef = e2.ref;
            e2.ref = e;           
            e = e2;
        }
        while (eRef != null);
        return e;
    }
    
    private class ReverseListsElement{
        public int value;
        public ReverseListsElement ref;

        public ReverseListsElement(int value, ReverseListsElement ref) {
            this.value = value;
            this.ref = ref;
        }

        public ReverseListsElement getCycleElement(){
            ReverseListsElement e  = this;            
            ReverseListsElement e2 = this;
            do{
                if (e != null){
                   e  = e.ref; 
                }
                if ((e2 != null) && (e2.ref != null)){
                   e2  = e2.ref.ref; 
                }
            }
            while ((e != null) && (e2 != null) && (e != e2));
            return (e == e2)?e:null;
        }

        @Override
        public String toString(){
            return Integer.toString(value);
        }
        
        public List<ReverseListsElement> getChild(){
            List<ReverseListsElement> result = new ArrayList<>();
            ReverseListsElement e = this;     
            result.add(e);
            ReverseListsElement eCycle = getCycleElement();
            int found = 0; 
            while ((e != null) && (found != 2)){
                if ((eCycle != null) && (e == eCycle)){
                   found ++; 
                }
                e = e.ref;
                if (e != null){
                   result.add(e);
                }
            }
            return result;
        }

        public String getChildString(){
            List<ReverseListsElement> list = getChild();

            StringBuilder sb = new StringBuilder();
            for (ReverseListsElement el:list){
                sb.append(el).append(";");
            }
            return sb.toString();
        }        
    }    
}