package Java.Threads.Concurrent;

import examples.ExampleInterface;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author GASedelnikov
 */


public class CountDownLatch_Race implements ExampleInterface{
    private static final int trackLengthDef = 500000;     //Условная длина гоночной трассы
    private static final int carsCountDef = 5;
    
    private final CountDownLatch START;
    private final int trackLength;    
    private final int carsCount;    

    public CountDownLatch_Race() {
        this(CountDownLatch_Race.carsCountDef, CountDownLatch_Race.trackLengthDef);
    }

    /**
     * Конструктор
     * @param carsCount - количество машин
     * @param trackLength - Условная длина гоночной трассы 
     */
    public CountDownLatch_Race(int carsCount, int trackLength) {
        this.carsCount = carsCount;
        this.trackLength = trackLength;
        START = new CountDownLatch(this.carsCount + 3);     //Создаем CountDownLatch на (carsCount + 3) "условий"
    }
    
    @Override
    public void start()  {
        try {        
            for (int i = 1; i <= this.carsCount; i++) {
                new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
                Thread.sleep(1000);
            }

            while (START.getCount() > 3){ //Проверяем, собрались ли все автомобили
                Thread.sleep(100);       //  у стартовой прямой. Если нет, ждем 100ms
            }
            
            Thread.sleep(1000);

            System.out.println("На старт!");
            START.countDown();//Команда дана, уменьшаем счетчик на 1
            Thread.sleep(1000);
            System.out.println("Внимание!");
            START.countDown();//Команда дана, уменьшаем счетчик на 1
            Thread.sleep(1000);
            System.out.println("Марш!");
            START.countDown();//Команда дана, уменьшаем счетчик на 1
            //счетчик становится равным нулю, и все ожидающие потоки одновременно разблокируются
        } catch (InterruptedException ex) {
        }        
    }

    public class Car implements Runnable {
        private final int carNumber;
        private final int carSpeed;//считаем, что скорость автомобиля постоянная

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к стартовой прямой.\n", carNumber);
                //Автомобиль подъехал к стартовой прямой - условие выполнено
                //уменьшаем счетчик на 1
                START.countDown();
                //метод await() блокирует поток, вызвавший его, до тех пор, пока
                //счетчик CountDownLatch не станет равен 0
                START.await();
                Thread.sleep(trackLength / carSpeed);//ждем пока проедет трассу
                System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
            } catch (InterruptedException e) {
            }
        }
    }
}