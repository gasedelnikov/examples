package Java.Algorithms;

import examples.algorithms.IntersectionOfValues;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntersectionOfValuesTest {

    @Test
    public void testGetIntersection_Test2() {
        List<Integer> arrayA = Arrays.asList(0, 1);
        List<Integer> arrayB = Arrays.asList(1, 0);

        IntersectionOfValues<Integer> intersectionOfValues = new IntersectionOfValues<>();
        List<Integer> result = intersectionOfValues.getIntersection(arrayA, arrayB);

        List<Integer> eRresult = Arrays.asList(1, 0);

        assertEquals(eRresult, result);
    }


    @Test
    public void testGetIntersection_Test1() {
        List<Integer> arrayA = Arrays.asList(0, 1, 2, 3, 2, 0);
        List<Integer> arrayB = Arrays.asList(5, 0, 1, 2, 7, 3, 2, 0, 0);

        IntersectionOfValues<Integer> intersectionOfValues = new IntersectionOfValues<>();
        List<Integer> result = intersectionOfValues.getIntersection(arrayA, arrayB);

        List<Integer> eRresult = Arrays.asList(0, 1, 2, 3, 2, 0);

        assertEquals(eRresult, result);
    }

    @Test
    public void testGetIntersection_TwoNulls() {
        List<Integer> arrayA = null;
        List<Integer> arrayB = null;

        IntersectionOfValues<Integer> intersectionOfValues = new IntersectionOfValues<>();
        assertEquals(Collections.emptyList(), intersectionOfValues.getIntersection(arrayA, arrayB));
    }

    @Test
    public void testGetIntersection_OneNull1() {
        List<Integer> arrayA = null;
        List<Integer> arrayB = Collections.emptyList();

        IntersectionOfValues<Integer> intersectionOfValues = new IntersectionOfValues<>();
        assertEquals(Collections.emptyList(), intersectionOfValues.getIntersection(arrayA, arrayB));
    }

    @Test
    public void testGetIntersection_OneNull2() {
        List<Integer> arrayA = Collections.emptyList();
        List<Integer> arrayB = null;

        IntersectionOfValues<Integer> intersectionOfValues = new IntersectionOfValues<>();
        assertEquals(Collections.emptyList(), intersectionOfValues.getIntersection(arrayA, arrayB));
    }

    @Test
    public void testGetIntersection_TwoEmpty() {
        List<Integer> arrayA = Collections.emptyList();
        List<Integer> arrayB = Collections.emptyList();

        IntersectionOfValues<Integer> intersectionOfValues = new IntersectionOfValues<>();
        List<Integer> result = intersectionOfValues.getIntersection(arrayA, arrayB);

        List<Integer> eRresult = Collections.emptyList();

        assertEquals(eRresult, result);
    }

    @Test
    public void testGetIntersection_OneEmpty1() {
        List<Integer> arrayA = Collections.emptyList();
        List<Integer> arrayB = Collections.singletonList(1);

        IntersectionOfValues<Integer> intersectionOfValues = new IntersectionOfValues<>();
        List<Integer> result = intersectionOfValues.getIntersection(arrayA, arrayB);

        List<Integer> eRresult = Collections.emptyList();

        assertEquals(eRresult, result);
    }

    @Test
    public void testGetIntersection_OneEmpty2() {
        List<Integer> arrayA = Collections.singletonList(1);
        List<Integer> arrayB = Collections.emptyList();

        IntersectionOfValues<Integer> intersectionOfValues = new IntersectionOfValues<>();
        List<Integer> result = intersectionOfValues.getIntersection(arrayA, arrayB);
        assertEquals(Collections.emptyList(), result);
    }

}