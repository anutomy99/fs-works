package Stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Book {
    private int id;
    private String bookName;
    private String authorName;

    public Book(int id, String bookName, String authorName) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
    }


    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }



}

   class BookSystem {
       Map<Integer, Book> bookMap;

       public BookSystem() {
          this.bookMap =new HashMap<>();
       }
       public void addBooks(){
           bookMap.put(101, new Book(101, "Java programming", "Author1"));
           bookMap.put(102, new Book(102, "Python programming", "Author2"));
           bookMap.put(103, new Book(103, "Java Beginners", "Author3"));
           bookMap.put(104, new Book(104, "Python Beginners", "Author4"));
       }


       public void displayBookNameWithId(int id) {
         bookMap.keySet().stream()
                   .filter(bookId->bookId.equals(id))
                   .map(bookMap::get)
                   .forEach(e-> System.out.println("Bisplay Book Name with id: --  Book Id :"+e.getId()+"   Name : "+e.getBookName()));
       }
       public void bookNameStartWithJava(String word) {
           System.out.println("----------BookName Start with Java------------");
          List<Book> bookList = bookMap.values().stream()
                   .filter(n ->n.getBookName().startsWith(word))
                           .toList();
           bookList.forEach(e-> System.out.println("Book Id : "+e.getId()+"  Book Name : "+e.getBookName()));

       }
       public void listOfBookNameStartWithJava(String word) {
           System.out.println("-----------List of Books start with Java-------------------");
            List<String> javaBookList = bookMap.values().stream()
                    .filter(book -> book.getBookName().startsWith("Java"))
                    .map(book -> "Book Id :"+ book.getId()+"  Name : "+book.getBookName()+" Author : "+book.getAuthorName()+"\n")
                    .toList();
           System.out.println(javaBookList);


       }


       public static void main(String[] args) {

           BookSystem bookSystem=new BookSystem();
           bookSystem.addBooks();
           bookSystem.displayBookNameWithId(101);
           bookSystem.bookNameStartWithJava("Java");
           bookSystem.listOfBookNameStartWithJava("Java");

        }

   }
