package Java.Threads;

import Utils.UTypes;
import examples.ExampleInterface;
/*
        example = new PingPong_Interrupt();                                                         example.start();     
        example = new PingPong_Interrupt(new String[]{"5"});                                        example.start();        
        example = new PingPong_Interrupt(new String[]{"5", "7"});                                   example.start();           
        example = new PingPong_Interrupt(new String[]{"5", "7", "1", "2", "3", "55"});              example.start();           
        example = new PingPong_Interrupt(new String[]{"3", "10", "0", "0", "0", "1", "0", "1"});    example.start();      
        example = new PingPong_Interrupt(3, 10, new int[]{0, 0, 0, 1, 0, 2, 8, 1});                 example.start();  
 */

/**
 * Пример работы с потоками. В цикле потоки пишут сообщения и пробуждают другие потоки. 
 * Для пробуждения используется Interrupt, что не очень хорошо для принудительного завершения потоков.
 * playersCount – количество потоков
 * roundsCount – количество кругов
 * gameArr – матрица вызовов, gameArr[i] – следующий пробуждаемый поток
 * @author GASedelnikov
 */
  
public class PingPong_Interrupt implements ExampleInterface{
    private static final int playersCountDef    = 2;
    private static final int roundsCountDef     = 10;    
    private static final int[] gameArrDef       = new int[]{0, 1}; 
    private static final int gameArrShiftArgs   = 3;
    
    private final int playersCount;
    private final int roundsCount;
    private final int[] gameArr; 
    
    private volatile Integer phase = 0;//new AtomicInteger(0); 
    private volatile Integer round = 0;//new AtomicInteger(0); 
    
    /**
     * Основной конструктор 
     * @param playersCount – количество потоков
     * @param roundsCount – количество кругов
     * @param gameArr – матрица вызовов, gameArr[i] – следующий пробуждаемый поток
     */
    public PingPong_Interrupt(int playersCount, int roundsCount, int[] gameArr) {
        this.playersCount = playersCount;
        this.roundsCount = roundsCount;
        this.gameArr = gameArr;
        for (int i=0; i< this.gameArr.length; i++){
            this.gameArr[i] = Math.abs(this.gameArr[i] % this.playersCount);
        }        
    }    
    
    /**
     * Конструктор для примера с двумя потоками 
     * @param roundsCount – количество кругов
     */
    public PingPong_Interrupt(int roundsCount){
       this(PingPong_Interrupt.playersCountDef, roundsCount, PingPong_Interrupt.gameArrDef);
    }       
    
    /**
     * Конструктор для примера с перенастроенными параметрами 
     */
    public PingPong_Interrupt(){
       this(PingPong_Interrupt.playersCountDef, PingPong_Interrupt.roundsCountDef, PingPong_Interrupt.gameArrDef);
    }    
    
    /**
     * Конструктор для примера, где памраметры могут определяться через командную строку
     * @param args Параметры playersCount, roundsCount, массив gameArr
          playersCount – количество потоков
          roundsCount – количество кругов
          gameArr – матрица вызовов, gameArr[i] – следующий пробуждаемый поток* 
     */
    public PingPong_Interrupt(String[] args){
        this.playersCount= (args.length > 1) ? UTypes.parseInt(args[1], PingPong_Interrupt.playersCountDef): PingPong_Interrupt.playersCountDef;
        this.roundsCount = (args.length > 2) ? UTypes.parseInt(args[2], PingPong_Interrupt.roundsCountDef) : PingPong_Interrupt.roundsCountDef;
        
        if (args.length > PingPong_Interrupt.gameArrShiftArgs) {
            this.gameArr = new int[args.length - PingPong_Interrupt.gameArrShiftArgs];
            for (int i=0; i < args.length - PingPong_Interrupt.gameArrShiftArgs; i++){
                this.gameArr[i] =  Math.abs(UTypes.parseInt(args[i+PingPong_Interrupt.gameArrShiftArgs], 0) % this.playersCount);
            }
        }   
        else{
            this.gameArr = PingPong_Interrupt.gameArrDef;
        }
    }

    @Override
    public void start(){
        printStartConditions();
        
        Thread[] threads = new Thread[playersCount];
        for (int i=0; i < playersCount; i++){
            threads[i] = new Thread("Thread №" + i){
                @Override
                public void run() {                
                    while (round < roundsCount){
                        synchronized(gameArr) {
                            try {      
                                gameArr.wait();
                            } catch (java.lang.InterruptedException ex) {
                            }                                  
                        }
                        
                        synchronized(gameArr) {   
                            if (round < roundsCount){
                                System.out.println("round =" + round + "; phase = " + phase + "; " + this.getName());
                         
                                phase++;
                                if (phase >= gameArr.length){
                                    phase = 0;
                                    round++;
                                }            
                            } 
                            threads[gameArr[phase]].interrupt();
                        }    
                    }
                    
                    synchronized(gameArr) {                     
                        gameArr.notifyAll();
                    }
                    System.out.println("Stop " + this.getName());
                }    
            };
            threads[i].start();
        }

        threads[gameArr[0]].interrupt(); 
    }

    public void printStartConditions(){
        System.out.println();        
        System.out.println("playerCount: " + playersCount);
        System.out.println("roundsCount: " + roundsCount);
        for (int i=0; i< gameArr.length; i++){
            System.out.println("  gameArr["+i+"]: "+ gameArr[i]);            
        }
    }    
    
}
