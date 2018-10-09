
package Java.XXX_OLD.Threads;

/**
 *
 * @author g_sedelnikov
 */
public class PingPong2on2 {
    
    private final Object obj1 = new Object();
    private final Object obj2 = new Object();

    int cnt = 0;
    volatile  int tt = 1;
        
    public PingPong2on2(){
        p2on2(); 
    }
    
    private void p2on2(){
        RunPP t1 = new RunPP("T1a...", 0, obj1, obj2);
        RunPP t2 = new RunPP("T1b...", 1, obj1, obj2);
        RunPP t3 = new RunPP("T2a...", 2, obj2, obj1);
        RunPP t4 = new RunPP("T2b...", 3, obj2, obj1);
        (new Thread(t1)).start();
        (new Thread(t2)).start();
        (new Thread(t3)).start();
        (new Thread(t4)).start();       
    }
    
    class RunPP implements Runnable{
        int index;
        
        String text;
        final Object o1;
        final Object o2;

        
        public RunPP(String text, int index, Object o1, Object o2){
            this.text = text;
            this.o1 = o1;
            this.o2 = o2;
            this.index = index;
        }
        
        @Override
        public void run() {
            cnt = index;
            System.out.println(text + " cnt: " + cnt); 

            if (index == 2){
                cnt = tt*10; 
                
            }
            System.out.println(text + " cnt: " + cnt); 
                
                
//            while (true) {            
//                cnt += 1;
//                System.out.println(text + " cnt: " + cnt);            
//            }            
//            try {
//                if (index != 0) {
//                    synchronized (o1) {
//                        o1.wait();
//                    }                    
//                }
//                while (true) {
//                    cnt += 1;
//                    System.out.println(text + " cnt: " + cnt);
//                    synchronized (o2) {
//                        o2.notify();
//                    }
//                    synchronized (o1) {
//                        o1.wait();
//                    }
//                    Thread.sleep(0);
//
//                }
//            } catch (InterruptedException ex) {
//            }
        }    
    }     
    
}
