package Java.Threads.Concurrent;

/**
 *
 * @author GASedelnikov
 */

import examples.ExampleInterface;
import java.util.concurrent.Exchanger;

public class Exchanger_Delivery implements ExampleInterface {
    //Создаем обменник, который будет обмениваться типом String
    private final Exchanger<String> EXCHANGER = new Exchanger<>();
  
    @Override
    public void start(){
        try {  
            String[] p1 = new String[]{"{посылка A->D}", "{посылка A->C}"};//Формируем груз для 1-го грузовика
            String[] p2 = new String[]{"{посылка B->C}", "{посылка B->D}"};//Формируем груз для 2-го грузовика
            new Thread(new Truck(1, "A", "D", p1)).start();//Отправляем 1-й грузовик из А в D
            Thread.sleep(100);
            new Thread(new Truck(2, "B", "C", p2)).start();//Отправляем 2-й грузовик из В в С
        } catch (InterruptedException ex) {
        }         
    }

    public class Truck implements Runnable {
        private final int number;
        private final String dep;
        private final String dest;
        private final String[] parcels;

        public Truck(int number, String departure, String destination, String[] parcels) {
            this.number = number;
            this.dep = departure;
            this.dest = destination;
            this.parcels = parcels;
        }

        @Override
        public void run() {
            try {
                System.out.printf("В грузовик №%d погрузили: %s и %s.\n", number, parcels[0], parcels[1]);
                System.out.printf("Грузовик №%d выехал из пункта %s в пункт %s.\n", number, dep, dest);
                Thread.sleep(1000 + (long) (Math.random() * 5000));
                System.out.printf("Грузовик №%d приехал в пункт Е.\n", number);
                parcels[1] = EXCHANGER.exchange(parcels[1]);//При вызове exchange() поток блокируется и ждет
                //пока другой поток вызовет exchange(), после этого произойдет обмен посылками
                System.out.printf("В грузовик №%d переместили посылку для пункта %s.\n", number, dest);
                Thread.sleep(1000 + (long) (Math.random() * 5000));
                System.out.printf("Грузовик №%d приехал в %s и доставил: %s и %s.\n", number, dest, parcels[0], parcels[1]);
            } catch (InterruptedException e) {
            }
        }
    }
}