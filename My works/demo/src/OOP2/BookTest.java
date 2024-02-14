package OOP2;

import java.util.ArrayList;

public class BookTest {
    public static void main(String[] args) {

        Book book = new Book(101,"Object Oriented Programming");
        book.addReviews(new Reviews(1,"Excellent",5));
        book.addReviews(new Reviews(2,"Great book",4));
        System.out.println(book);

    }
}
