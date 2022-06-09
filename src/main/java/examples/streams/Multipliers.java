package examples.streams;

import utils.UField;
import examples.interfaces.ExampleInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Задача: Есть лист элементов ключ-значение; есть Мапа ключ-значение,
 * необходимо значения листа перемножить на значения Мапы при совпадении ключей.
 *
 * @author GASedelnikov
 */
public class Multipliers implements ExampleInterface {
    private final List<String> keysOfItems = Arrays.asList("A", "B", "C", "D", "E");

    private final String[] excludedValues = new String[]{keysOfItems.get(1)};
    private final String[] excludedMultipliers = new String[]{keysOfItems.get(0)};
    private final int cntOfItems = 10;
    private final int numberOrigin = 1;
    private final int numberBound = 10;

    @Override
    public void start() {
        List<UField> values = genNotUniq(cntOfItems, numberOrigin, numberBound, keysOfItems, excludedValues);
        Map<String, Integer> multipliers = genUniq(numberOrigin, numberBound, keysOfItems, excludedMultipliers);

        printFormattedResult("values:");
        values.forEach(f -> printFormattedResult(" %s;", f));
        printFormattedResult(" multipliers:");
        multipliers.forEach((s, integer) -> printFormattedResult(" %s=%d;", s, integer));

        printFormattedResult("%nResult1:");
        usingFlatMap(values, multipliers).forEach(f -> printFormattedResult(" %s;", f));

        printFormattedResult("%nResult2:");
        usingMap(values, multipliers).forEach(f -> printFormattedResult(" %s;", f));
    }

    public List<UField> usingMap(List<UField> values, Map<String, Integer> multipliers) {
        return values.stream()
                .map(ai -> multipliers.entrySet().stream()
                        .filter(bi -> bi.getKey().equals(ai.getKey()))
                        .map(Map.Entry::getValue)
                        .findFirst()
                        .map(i -> new UField(ai.getKey(), ai.getValue() * i))
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<UField> usingFlatMap(List<UField> values, Map<String, Integer> multipliers) {
        return values.stream()
                .flatMap(ai -> multipliers.entrySet().stream()
                        .filter(bi -> bi.getKey().equals(ai.getKey()))
                        .limit(1)
                        .map(bi -> new UField(ai.getKey(), bi.getValue() * ai.getValue())))
                .collect(Collectors.toList());
    }

    private List<UField> genNotUniq(int cnt, int numberOrigin, int numberBound, List<String> keys, String... excluded) {
        Random rnd = new Random();
        return rnd.ints(cnt, numberOrigin, numberBound)
                .boxed()
                .map(val -> new UField(keys.get(rnd.nextInt(keys.size())), val))
                .filter(uField -> Arrays.stream(excluded).noneMatch(x -> x.equals(uField.getKey())))
                .collect(Collectors.toList());
    }

    private Map<String, Integer> genUniq(int numberOrigin, int numberBound, List<String> keys, String... excluded) {
        Random rnd = new Random();
        return keys.stream()
                .filter(key -> Arrays.stream(excluded).noneMatch(x -> x.equals(key)))
                .collect(Collectors.toMap(key -> key,
                        i -> numberOrigin + rnd.nextInt(numberBound)
                        , (e1, e2) -> e1));
    }
}
