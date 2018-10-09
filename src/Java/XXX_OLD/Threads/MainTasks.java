package Java.XXX_OLD.Threads;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g_sedelnikov
 */
public class MainTasks {
    private final Deque<String> data = new ArrayDeque<>();
    
    public MainTasks(){
        
    }
    
    public void start_Producer_Consumer(){
        Runnable prodRun = new Runnable() {
            @Override
            public void run() {
                for (int i =0; i < 20 ;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainTasks.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
                    
                    synchronized (data){
                       data.add("Str" + i); 
                       data.notify();
                       System.out.println("Add " + i);
                    }
                }
            }
        };
      
        
        Thread prodThr = new Thread(prodRun);
        prodThr.start();
        Thread consThr1 = new Thread(new Consumer(1, 1500));
        consThr1.start();        
        Thread consThr2 = new Thread(new Consumer(2, 1500));
        consThr2.start(); 
    }
    
    class Consumer implements Runnable{
        private final int index;
        private final long timeout;
        
        public Consumer(int index, long timeout){
           this.index = index; 
           this.timeout = timeout;
        }
        
        @Override
        public void run() {
            while (true){
                synchronized (data){
                    try {
                        data.wait();
                    } catch (InterruptedException ex) {

                    }

                    String str = data.poll();
                    System.out.println(" Read " + index + " " + str);
                }  

                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException ex) {
                }                      

            }
        }        
        
    }
    
    
    
    
}
