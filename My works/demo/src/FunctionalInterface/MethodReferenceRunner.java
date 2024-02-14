package FunctionalInterface;

import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceRunner {
    public static void main(String[] args) {
        List.of("Apple","Banana","Mango","Cherry").stream()
                .map(s ->s.length())
                .forEach(fruit -> System.out.println(fruit));
        System.out.println("--------------------------------");
        List.of("Apple","Banana","Mango","Cherry").stream()
                .map(String::length )//s ->s.length()
                .forEach(MethodReferenceRunner::print);//s ->MethodReferenceRunner.print(s))
        // .forEach(s ->System.out.println(s) **.forEach(System.out::println)


        System.out.println("--------------------------------");
        List.of("Apple","Banana","Mango","Cherry").stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void print(Integer number) {
        System.out.println(number);
    }
}
