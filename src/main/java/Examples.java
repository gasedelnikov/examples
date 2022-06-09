import examples.algorithms.IntersectionOfValues;
import examples.interfaces.ExampleInterface;

/**
 * @author GASedelnikov
 */
public class Examples {

    public static void main(String[] args) {
        ExampleInterface example;
//        Arrays.stream(B.class.getMethods()).peek(method -> System.out.println(method));

        example = new IntersectionOfValues();example.start();
//        example = new WordFrequency();example.start();
//        example = new Multipliers();example.start();
//        example = new NewInJava8( ); example.start();        
    }


}
