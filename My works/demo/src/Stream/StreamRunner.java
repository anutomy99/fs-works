package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamRunner {
    public static void main(String[] args) {
        IntStream.range(1, 10)
                .map(element -> element * element)
                .forEach(element -> System.out.println(element));

    List<String> fruitList=    List.of("Apple", "Orange", "Banana").stream()
                .map(e -> e.toLowerCase())
                .collect(Collectors.toList());
    System.out.println(fruitList);



        List.of("Apple", "Banana", "Mango").stream()
                .map(e -> e.length())
                .forEach(e -> System.out.println(e));

         Integer max=   List.of(20,5,30,12,50).stream().max((n1,n2)->Integer.compare(n1,n2)).get();
         System.out.println("Max element"+max);

         List<Integer> oddList = List.of(1,5,2,8,7,10,11,12).stream()
                 .filter(e ->e%2==1)
                 .sorted()
                 .collect(Collectors.toList());
        System.out.println(oddList);
    }
}
