package examples;

/**
 *
 * @author GASedelnikov
 */
public interface ExampleInterface {

    /**
     * Запуск примера
     */
    public void start();
    
    /**
     * Вывод результата
     * @param text - массив текстов для вывода
     */
    public default void printResult(String text){
        if (text == null){
            System.out.println("null");           
        }
        else{
            System.out.println(text);
        }
    }
}
