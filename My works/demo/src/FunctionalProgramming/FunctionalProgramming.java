package FunctionalProgramming;

import java.util.List;

public class FunctionalProgramming {
    public static void main(String[] args) {

        List<String> list =List.of("Apple","Banana","Cat");
//        extracted(list);
        printWithFunctionalProgramming(list);
    }

    private static void extracted(List<String> list) {
        for (String string: list
             ) {
            System.out.println(string);
        }
    }
    private static void printWithFunctionalProgramming(List<String> list) {
       list.stream().forEach(element -> System.out.println(element));
    }
}
