package examples.algorithms;

import examples.interfaces.ExampleInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfValues<T> implements ExampleInterface {

    @Override
    public void start() {
        List<Integer> arrayA = Arrays.asList(0, 1, 2, 3, 2, 0);
        List<Integer> arrayB =  Arrays.asList(5, 0, 1, 2, 7, 3, 2, 0, 0);

        IntersectionOfValues<Integer> intersectionOfValues = new IntersectionOfValues<>();
        List<Integer> result = intersectionOfValues.getIntersection(arrayA, arrayB);
        printResult(result.toString());
    }

    public List<T> getIntersection(List<T> arrayA, List<T> arrayB) {
        if (arrayA == null || arrayA.isEmpty() || arrayB == null || arrayB.isEmpty()){
            return Collections.emptyList();
        }

        Map<T, Integer> dict = new HashMap<>();
        for (T i : arrayA) {
            Integer v = dict.getOrDefault(i, 0) + 1;
            dict.put(i, v);
        }

        List<T> result = new ArrayList<>();
        for (T i : arrayB) {
            Integer cntFromDict = dict.getOrDefault(i, 0);
            if (cntFromDict > 0) {
                dict.put(i, cntFromDict - 1);
                result.add(i);
            }
        }
        return result;
    }

}
