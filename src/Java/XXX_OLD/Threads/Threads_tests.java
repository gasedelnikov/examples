package Java.XXX_OLD.Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g_sedelnikov
 */
public class Threads_tests {
    public static volatile Integer value = 0;
    public static final Object obj = new Object();
    
    public static void start(){
//        text = "dfg";
        Runnable prod = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
//                    System.out.println("           T1 value =" + value);                    
                        Thread.sleep(100);

                        synchronized(obj){
                            obj.notifyAll();
                            value ++;                
                            obj.wait();
                        }
                    }    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads_tests.class.getName()).log(Level.SEVERE, null, ex);
                }                        
            }
        };
        Runnable cons = new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized(obj){
                        try {
                            obj.notifyAll();
                            System.out.println("value = " + value);                    
                            obj.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Threads_tests.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        };
        
        Thread th_prod = new Thread(prod); th_prod.start();
        Thread th_cons = new Thread(cons); th_cons.start();
        
        
        
    }
    
}
