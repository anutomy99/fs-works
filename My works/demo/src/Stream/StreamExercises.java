package Stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class StreamExercises {
    public static void main(String[] args) {
        List<Integer> numbers =List.of(1,2,8,22);
        List<String> courses = List.of("English","Malayalam","Maths" ,"science");
        System.out.println(filterOddNumbers(numbers));
        System.out.println(getCourseNameCharacterCount(courses));
        System.out.println(sumOfSquares(numbers));
        System.out.println(findMaxEvenNumbers(numbers));
    }

    private static int findMaxEvenNumbers(List<Integer> numbers) {
        if(numbers == null){
            return 0;
        }
       Optional<Integer> maxEven = numbers.stream()
               .filter(number ->number%2 == 0)
               .max(Integer::compare);
        return maxEven.orElse(0);
    }

    private static long sumOfSquares(List<Integer> numbers) {
        if (numbers==null){
            return 0;
        }
        return numbers.stream()
                .mapToLong(n ->n*n)
                .sum();
    }

    private static List<Integer> getCourseNameCharacterCount(List<String> courses) {
        if (courses == null){
            return  List.of();
        }
        return courses.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    private static List<Integer> filterOddNumbers(List<Integer> numbers) {
        return  numbers.stream()
                .filter(n ->n%2!=0)
                .collect(Collectors.toList());
    }
}
