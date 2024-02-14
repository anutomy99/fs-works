package FunctionalProgramming;

import java.util.List;

public class Streamrunner {
    public static void main(String[] args) {
//          List<Integer> list = List.of(1,3,4,5);
//          printWithFunctionalProgramming(list);
//          List<String> list1 = List.of("Cat","Bat","Lion","Tiger");
//          printWithFPWithFiltering(list1);

            List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
            printFPFliterOfOdd(numbers);

    }

    private static void printFPFliterOfOdd(List<Integer> numbers) {
        numbers.stream()
                .filter(element ->(element%2 ==1))
                .forEach(element ->System.out.println(element));

    }
//        private static void printWithFunctionalProgramming(List<Integer> list) {
//            list.stream().forEach(element -> System.out.println(element));
//        }
//    private static void printWithFPWithFiltering(List<String> list1) {
//        list1.stream()
//                .filter(element -> element.endsWith("at"))
//                .forEach(element -> System.out.println(element));
//    }


    }

