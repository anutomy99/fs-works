package FunctionalProgramming;

import java.util.List;

public class FPNumberRunner {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4,6,8,13,3,15);
        printFPWithSumOfNum(numbers);
    }

    private static void printFPWithSumOfNum(List<Integer> numbers) {
      int sum=  numbers.stream()
                .reduce(0,(number1 , number2)->number1+number2);
      System.out.println(sum);
    }
}
