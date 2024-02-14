package DeamonThread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookLibrary {
    public static void main(String[] args) {
        HashMap<Integer, String> bookMap = new HashMap<>();
        bookMap.put(101, "Java Programming");
        bookMap.put(102, "Python Programming");
        bookMap.put(103, "Java Beginners");

        bookwithSpecificCode(bookMap);
        bookStartWithJava(bookMap);
        listOfJavaBooks(bookMap);
    }

    private static void listOfJavaBooks(HashMap<Integer, String> bookMap) {
        List<String > javaBookList = bookMap.entrySet().stream()
                .filter(bookData ->bookData.getValue().startsWith("Java"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println("List of Books start with Java "+javaBookList);
    }


    private static void bookStartWithJava(HashMap<Integer, String> bookMap) {
        List<String > javaBooks = bookMap.entrySet().stream()
                .filter(entry ->entry.getValue().startsWith("Java"))
                .map(Map.Entry::getValue)  // .map(entry ->entry.getValue())

                .collect(Collectors.toList());
                System.out.println("Books start with Java "+javaBooks);
    }

    private static void bookwithSpecificCode(HashMap<Integer, String> bookMap) {
        String bookName = bookMap.entrySet().stream()
                .filter(code -> 101 == (code.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
        System.out.println("Book with code 101 : "+bookName);
    }
}