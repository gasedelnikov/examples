package Java.Streams;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class WordFrequencyTest {
    private WordFrequency instance = new WordFrequency();

    @Test
    public void positiveTest() {
        int limitOfWords = 3;
        String text = "a h c a b a v g";
        List<String> res = instance.split(text, limitOfWords);
        assertEquals(3, res.size());
        assertEquals(instance.getResultFormatted("a", 3), res.get(0));
        assertEquals(instance.getResultFormatted("b", 1), res.get(1));
        assertEquals(instance.getResultFormatted("c", 1), res.get(2));
    }

    @Test
    public void emptyTextTest() {
        int limitOfWords = 3;
        String text = "";
        List<String> res = instance.split(text, limitOfWords);
        assertEquals(0, res.size());
    }

    @Test
    public void nullTextTest() {
        int limitOfWords = 3;
        String text = null;
        List<String> res = instance.split(text, limitOfWords);
        assertEquals(0, res.size());
    }
}
