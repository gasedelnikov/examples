package Java.Threads.Concurrent;

import examples.ExampleInterface;
import java.util.concurrent.Semaphore;

/**
 *
 * @author GASedelnikov
 */

public class Semaphore_Parking implements ExampleInterface{
    private static final int carsCountDef = 7;
    private static final int placesCountDef = 5;   
    
    private final boolean[] PARKING_PLACES ; //Парковочное место занято - true, свободно - false
    private final Semaphore SEMAPHORE; //Устанавливаем флаг "справедливый", в таком случае метод aсquire() будет раздавать разрешения в порядке очереди
    private final int carsCount;
    private final int placesCount;    

    public Semaphore_Parking() {
        this(Semaphore_Parking.carsCountDef, Semaphore_Parking.placesCountDef);
    }
    
    /**
     * Конструктор
     * @param carsCount - количество машин
     * @param placesCount - количество мест на парковке
     */
    public Semaphore_Parking(int carsCount, int placesCount) {
        this.carsCount = carsCount;
        this.placesCount = placesCount;
        
        this.PARKING_PLACES = new boolean[this.placesCount]; 
        this.SEMAPHORE = new Semaphore(this.placesCount, true); 
    }
    
    @Override
    public void start() {
        for (int i = 1; i <= this.carsCount; i++) {
            new Thread(new Car(i)).start();
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
            }
        }
    }

    public class Car implements Runnable {
        private final int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            System.out.printf("Автомобиль №%d подъехал к парковке.\n", carNumber);
            try {
                //acquire() запрашивает доступ к следующему за вызовом этого метода блоку кода,
                //если доступ не разрешен, поток вызвавший этот метод блокируется до тех пор,
                //пока семафор не разрешит доступ
                SEMAPHORE.acquire();

                int parkingNumber = -1;

                //Ищем свободное место и паркуемся
                synchronized (PARKING_PLACES){
                    for (int i = 0; i < placesCount; i++)
                        if (!PARKING_PLACES[i]) {      //Если место свободно
                            PARKING_PLACES[i] = true;  //занимаем его
                            parkingNumber = i;         //Наличие свободного места, гарантирует семафор
                            System.out.printf("Автомобиль №%d припарковался на месте %d.\n", carNumber, i);
                            break;
                        }
                }

                Thread.sleep(5000);       //Уходим за покупками, к примеру

                synchronized (PARKING_PLACES) {
                    PARKING_PLACES[parkingNumber] = false;//Освобождаем место
                }
                
                //release(), напротив, освобождает ресурс
                SEMAPHORE.release();
                System.out.printf("Автомобиль №%d покинул парковку.\n", carNumber);
            } catch (InterruptedException e) {
            }
        }
    }
}