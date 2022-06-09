package examples.threads.concurrent;

import examples.interfaces.ExampleInterface;
import java.util.ArrayList;
import java.util.concurrent.Phaser;

/**
 *
 * @author GASedelnikov
 */

public class Phaser_Train implements ExampleInterface{
    private static final int stopsCountDef      = 5;
    private static final int passengersCountDef = 10;    
    
    private final int stopsCount;
    private final int passengersCount;
            
    private final Phaser PHASER = new Phaser(1); // регистрируем главный поток
    //Фазы 0 и last - это начало и конец пути

    public Phaser_Train() {
       this(Phaser_Train.stopsCountDef, Phaser_Train.passengersCountDef);
    }    
    
    /**
     * Конструктор
     * @param stopsCount - количество станций
     * @param passengersCount - количество пассажиров
     */
    public Phaser_Train(int stopsCount, int passengersCount) {
        this.stopsCount      = stopsCount + 2;
        this.passengersCount = passengersCount;
    }

    @Override
    public void start() {
        ArrayList<Passenger> passengers = new ArrayList<>();

        for (int i = 0; i < passengersCount; i++) {           //Сгенерируем пассажиров 
            int startStation = 1 + (int) (Math.random() * (stopsCount-3));
            int endStation   = 1 + startStation + (int) ( Math.random() * (stopsCount - startStation-2));            
            
            passengers.add(new Passenger(i+1, startStation, endStation));
        }

        for (int i = 0; i < stopsCount; i++) {
            if (i == 0){
                    System.out.println("Поезд готовится.");
                    PHASER.arrive();//В фазе 0 всего 1 участник - поезд
            }
            else {
                if (i == (stopsCount-1)){
                    System.out.println("Поезд уехал отдыхать.");
                    PHASER.arriveAndDeregister();//Снимаем главный поток, ломаем барьер
                }
                else{
                    int currentBusStop = PHASER.getPhase();
                    System.out.println("Станция № " + currentBusStop);

                    for (Passenger p : passengers)          //Проверяем, есть ли пассажиры на остановке
                        if (p.departure == currentBusStop) {
                            PHASER.register();//Регистрируем поток, который будет участвовать в фазах
                            p.start();        // и запускаем
                        }

                    PHASER.arriveAndAwaitAdvance();//Сообщаем о своей готовности
                }    
            }
        }
    }

    public class Passenger extends Thread {
        private final int threadNumber;        
        private final int departure;
        private final int destination;

        public Passenger(int threadNumber, int departure, int destination) {
            this.threadNumber = threadNumber;            
            this.departure = departure;
            this.destination = destination;
            System.out.println(this + " ждёт на станции № " + this.departure + ". Станций в пути: " + (destination - departure));
        }

        @Override
        public void run() {
            try {
                System.out.println(this + " сел в поезд.");

                while (PHASER.getPhase() < destination) //Пока поезд не приедет на нужную станцию(фазу)
                    PHASER.arriveAndAwaitAdvance();     //заявляем в каждой фазе о готовности и ждем

                Thread.sleep(1);
                System.out.println(this + " покинул поезд.");
                PHASER.arriveAndDeregister();   //Отменяем регистрацию на нужной фазе
            } catch (InterruptedException e) {
            }
        }

        @Override
        public String toString() {
            return "Пассажир №" + threadNumber + " {" + departure + " -> " + destination + '}';
        }
    }
}