package examples.streams;

import examples.interfaces.ExampleInterface;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class BestPractices implements ExampleInterface {

    public BestPractices() {
        getStreamInStream();
    }

    @Override
    public void start(){}

    public void getStreamInStream(){
        IntStream.rangeClosed(1, 5)
                .flatMap(i -> IntStream.iterate(i, IntUnaryOperator.identity()).limit(i))
                .forEach(i -> printFormattedResult(" %d", i));
    }
}
