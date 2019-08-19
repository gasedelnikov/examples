package Java.Threads.Concurrent;

/**
 *
 * @author GASedelnikov
 */

import examples.ExampleInterface;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier_Ferry implements ExampleInterface{
    private static final int placesDef = 3;     //Условная длина гоночной трассы
    private static final int carsCountDef = 9;      
    
    private final int carsCount;
    private final int placesCount;      
    private final CyclicBarrier BARRIER;

    public CyclicBarrier_Ferry() {
        this(CyclicBarrier_Ferry.carsCountDef, CyclicBarrier_Ferry.placesDef);
    }

    /**
     * Конструктор
     * @param carsCount - количество машин
     * @param placesCount - количество 
     */
    public CyclicBarrier_Ferry(int carsCount, int placesCount) {
        this.carsCount = carsCount;
        this.placesCount = placesCount;
        this.BARRIER = new CyclicBarrier(this.placesCount, new FerryBoat());
    //Инициализируем барьер на placesCount потокjd и таском, который будет выполняться, когда
    //у барьера соберется три потока. После этого, они будут освобождены.        
    }
    
    @Override
    public void start() {
        try {        
            for (int i = 0; i < this.carsCount; i++) {
                new Thread(new Car(i)).start();
                Thread.sleep(400);
            }
        } catch (InterruptedException ex) {
        }        
    }

    //Таск, который будет выполняться при достижении сторонами барьера
    public class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили!");
            } catch (InterruptedException e) {
            }
        }
    }

    //Стороны, которые будут достигать барьера
    public class Car implements Runnable {
        private final int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к паромной переправе.\n", carNumber);
                //Для указания потоку о том что он достиг барьера, нужно вызвать метод await()
                //После этого данный поток блокируется, и ждет пока остальные стороны достигнут барьера
                BARRIER.await();
                System.out.printf("Автомобиль №%d продолжил движение.\n", carNumber);
            } catch (Exception e) {
            }
        }
    }
}