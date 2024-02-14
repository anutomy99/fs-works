package FunctionalInterface;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class EvenNumberPredicate implements Predicate<Integer>{
    @Override
    public boolean test(Integer number) {
        return number%2 ==0;
    }
}
class SysOutConsumer implements Consumer<Integer>{

    @Override
    public void accept(Integer number) {
        System.out.println(number);
    }
}

class NumberSquareMapper implements Function<Integer,Integer> {

    @Override
    public Integer apply(Integer number) {
        return number * number;
    }
}
public class LambdaBehindTheScreensRunner {
    public static void main(String[] args) {
        List.of(23,25,89,22,10,9,4).stream()
                .filter(n ->n%2 ==0)
                .forEach(e -> System.out.println(e));

        System.out.println("------------------------------");
             List.of(23,25,89,22,10,9,4).stream()
                     .filter(new EvenNumberPredicate())
                     .forEach(e -> System.out.println(e));

        System.out.println("------------------------------");
         List.of(23,25,89,22,10,9,4).stream()
            .filter(new EvenNumberPredicate())
             .map(new NumberSquareMapper())
            .forEach(new SysOutConsumer());
    }
}
