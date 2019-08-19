package examples;

import Java.Streams.Multipliers;
import Java.Streams.WordFrequency;

/**
 * @author GASedelnikov
 */
public class Examples {

    public static void main(String[] args) {
        ExampleInterface example;

        example = new WordFrequency();example.start();
//        example = new Multipliers();example.start();
//        example = new NewInJava8( ); example.start();        
    }


}
