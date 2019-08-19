package examples;

/**
 * @author GASedelnikov
 */
public interface ExampleInterface {

    /**
     * Запуск примера
     */
    public void start();

    /**
     * Вывод результата
     *
     * @param text - текст для вывода
     */
    public default void printResult(String text) {
        if (text == null) {
            System.out.println("null");
        } else {
            System.out.println(text);
        }
    }

    /**
     * Вывод результата
     *
     * @param text - текст для вывода
     * @param fields - переменные вывода
     */
    public default void printFormattedResult(String text, Object... fields) {
        if (text == null) {
            System.out.println("null");
        } else {
            System.out.format(text, fields);
        }
    }
}
