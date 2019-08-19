package Java.Threads;

import Utils.UTypes;
import examples.ExampleInterface;
import java.util.concurrent.Phaser;

/**
 * Пример работы с потоками. В цикле потоки пишут сообщения и пробуждают другие потоки.
 * playersCount – количество потоков
 * roundsCount – количество кругов
 * gameArr – матрица вызовов, gameArr[i] – следующий пробуждаемый поток
 * @author GASedelnikov
 */
  
public class PingPong_NotifyAll implements ExampleInterface{
    private static final int playersCountDef    = 2;
    private static final int roundsCountDef     = 10;    
    private static final int[] gameArrDef       = new int[]{0, 1}; 
    private static final int gameArrShiftArgs   = 3;
    
    private final int playersCount;
    private final int roundsCount;
    private final int[] gameArr; 
    
    private volatile Integer phase = 0;//new AtomicInteger(0); 
    private volatile Integer round = 0;//new AtomicInteger(0); 
    
    private final Phaser phaser;
    
    /**
     * Основной конструктор 
     * @param playersCount – количество потоков
     * @param roundsCount – количество кругов
     * @param gameArr – матрица вызовов, gameArr[i] – следующий пробуждаемый поток
     */
    public PingPong_NotifyAll(int playersCount, int roundsCount, int[] gameArr) {
        this.playersCount = playersCount;
        this.roundsCount = roundsCount;
        this.gameArr = gameArr;
        for (int i=0; i< this.gameArr.length; i++){
            this.gameArr[i] = Math.abs(this.gameArr[i] % this.playersCount);
        }  
        
        phaser = new Phaser(this.playersCount);
    }    
    
    /**
     * Конструктор для примера с двумя потоками 
     * @param roundsCount – количество кругов
     */
    public PingPong_NotifyAll(int roundsCount){
       this(PingPong_NotifyAll.playersCountDef, roundsCount, PingPong_NotifyAll.gameArrDef);
    }       
    
    /**
     * Конструктор для примера с перенастроенными параметрами 
     */
    public PingPong_NotifyAll(){
       this(PingPong_NotifyAll.playersCountDef, PingPong_NotifyAll.roundsCountDef, PingPong_NotifyAll.gameArrDef);
    }    
    
    /**
     * Конструктор для примера, где памраметры могут определяться через командную строку
     * @param args Параметры playersCount, roundsCount, массив gameArr
          playersCount – количество потоков
          roundsCount – количество кругов
          gameArr – матрица вызовов, gameArr[i] – следующий пробуждаемый поток* 
     */
    public PingPong_NotifyAll(String[] args){
        this.playersCount= (args.length > 1) ? UTypes.parseInt(args[1], PingPong_NotifyAll.playersCountDef): PingPong_NotifyAll.playersCountDef;
        this.roundsCount = (args.length > 2) ? UTypes.parseInt(args[2], PingPong_NotifyAll.roundsCountDef) : PingPong_NotifyAll.roundsCountDef;
        
        if (args.length > PingPong_NotifyAll.gameArrShiftArgs) {
            this.gameArr = new int[args.length - PingPong_NotifyAll.gameArrShiftArgs];
            for (int i=0; i < args.length - PingPong_NotifyAll.gameArrShiftArgs; i++){
                this.gameArr[i] =  Math.abs(UTypes.parseInt(args[i+PingPong_NotifyAll.gameArrShiftArgs], 0) % this.playersCount);
            }
        }   
        else{
            this.gameArr = PingPong_NotifyAll.gameArrDef;
        }
        phaser = new Phaser(this.playersCount);
    }

       
    @Override
    public void start(){
        printStartConditions();
      
        for (int i=0; i < playersCount; i++){
            new PP_Runnable(i, "Thread №" + i).start();
        }
    }

    public void printStartConditions(){
        System.out.println();        
        System.out.println("playerCount: " + playersCount);
        System.out.println("roundsCount: " + roundsCount);
        for (int i=0; i< gameArr.length; i++){
            System.out.println("  gameArr["+i+"]: "+ gameArr[i]);            
        }
    }    
    
    class PP_Runnable extends Thread{
        private final int thread_number;
    
        public PP_Runnable(int thread_number, String name){
            super(name);
            this.thread_number = thread_number;
        }

        @Override
        public void run() {           
            try {              
                while (round < roundsCount){
                    if ((thread_number != gameArr[phase])){
                        synchronized(gameArr) {
                            gameArr.wait();
                        }
                    }
            
                    synchronized(gameArr) {                        
                        if (thread_number == gameArr[phase]){
                            if (round < roundsCount){
                                System.out.println("round =" + round + "; phase = " + phase + "; " + this.getName());

                                phase++;
                                if (phase >= gameArr.length){
                                    phase = 0;
                                    round++;
                                }            
                            } 
                        }
                        gameArr.notifyAll();
                    }
                }
            } catch (java.lang.InterruptedException ex) {
                System.out.println("Stop by Interrupted " + this.getName());
            }
            finally {
                System.out.println("Stop " + this.getName());
            }
        }    
    }
}

