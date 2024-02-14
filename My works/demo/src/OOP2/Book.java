package OOP2;

import java.util.ArrayList;

public class Book {
    private  int id;
    private String bookName;

    private ArrayList<Reviews> reviews =new ArrayList<Reviews>();

    public Book(int id, String bookName) {
        this.id = id;
        this.bookName = bookName;

    }
    public  void addReviews( Reviews review){
        this.reviews.add(review);
    }

    @Override
    public String toString() {
        return String.format("Id :  %d ,Book Name : %s,    Reviews : %s",id,bookName,reviews);
    }
}
