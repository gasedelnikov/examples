package Java.Streams;

import examples.ExampleInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Задача: Есть строка, необходимо подсчитать в нем частоту появления слов,
 * и в конце выводящую N наиболее часто встречающихся слов.
 * Слово - непрерывная последовательность символов, состоящую только из букв и цифр.
 * Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
 * Выводить слова в нижнем регистре. Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 * Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
 * то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
 *
 * @author GASedelnikov
 */
public class WordFrequency implements ExampleInterface {

    @Override
    public void start() {
        int limitOfWords = 10;
        String text = "Мама  вчч   мыла-Мыла-мыла раму сччч аччч вчч бччч вчч вчч!";
        printResult(text, limitOfWords, split(text, limitOfWords));
    }

    private void printResult(String text, int limitOfWords, List<String> res) {
        printFormattedResult("%ntext = %s, limitOfWords = %d%n  WordFrequency: %s", text, limitOfWords, res);
    }

    public List<String> split(String text, int limitOfWords) {
        return Arrays.stream((text == null ? "" : text.toLowerCase()).split("[\\p{Blank}\\p{Punct}]+"))
                .filter(s -> !s.equals(""))
                .collect(groupingBy(s -> s, counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> (o2.getValue() == o1.getValue())
                        ? o1.getKey().compareTo(o2.getKey())
                        : o2.getValue().compareTo(o1.getValue())
                )
                .map(entry -> getResultFormatted(entry.getKey(), entry.getValue()))
                .limit(limitOfWords > 0 ? limitOfWords : 0)
                .collect(Collectors.toList());
    }

    public String getResultFormatted(String key, long value){
        return "'" + key + "' (" + value + ")";
    }
}
