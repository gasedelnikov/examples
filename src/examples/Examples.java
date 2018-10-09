package examples;

import Java.NewInJava8;
import Java.Serializable.TestSerializable;
import Java.Tasks.Arr_MiddleElement;
import Java.Tasks.CheckBracketsInString;
import Java.Tasks.GetNumbersOf1sFromBinary;
import Java.Tasks.ReverseList;
import Java.Tasks.ReverseNumber;
import Java.Threads.Concurrent.Exchanger_Delivery;
import Java.Threads.Concurrent.CyclicBarrier_Ferry;
import Java.Threads.Concurrent.Semaphore_Parking;
import Java.Threads.Concurrent.CountDownLatch_Race;
import Java.Threads.Concurrent.Phaser_Train;
import Java.Threads.PingPong_Interrupt;
import Java.Threads.PingPong_NotifyAll;

/**
 *
 * @author GASedelnikov
 */
public class Examples {

    public static void main(String[] args) {
        ExampleInterface example; 

        example = new TestSerializable( ); example.start();     
//        example = new NewInJava8( ); example.start();        
    }
  
    
}
