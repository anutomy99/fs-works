package MainTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class  MenuItem {
    String itemName;
    double price;
    List<Double> ratings;

    public MenuItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public void addRating(double rating) {
        ratings.add(rating);
    }

    public double averageRatingOfItem() {
        if (ratings.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }
}


class  Restaurent{
    static Scanner sc = new Scanner(System.in);
   List<MenuItem> menu;

    public Restaurent() {
        this.menu = new ArrayList<>();
    }
    public void addItem(String itemName,double price){
        MenuItem newItem = new MenuItem(itemName,price);
        menu.add(newItem);
        System.out.println("Item added");
        System.out.println("--------------------------------------------------");
    }
    public  void  displayItem(){
        if(menu.isEmpty()){
            System.out.println("/////////// Empty Menu List///////////");
        }else {
            System.out.println("_________Menu List_______");
            for (MenuItem item :menu) {
                System.out.println("Item name : "+item.itemName+" Price : "+item.price+" Ratings : "+item.ratings);

            }
            System.out.println("_______________________________________________");
        }
    }
    public  void  addRating(String itemName){
        MenuItem item = findItem(itemName);
        if (item!=null){
            System.out.print("Enter rating : ");

            double newRating = sc.nextDouble();
            item.addRating(newRating);
        }else {
            System.out.println("Item not found in the menu.Can't add rating");
        }
    }
    public  void calculateAverageRating(String itemName) {
        MenuItem item = findItem(itemName);
        if (item != null){
            double averageRating = item.averageRatingOfItem();
            System.out.println("Item name : "+item.itemName+" Average Rating : "+averageRating);
            System.out.println("________________________________________________");

        }else {
            System.out.println("Item not found in the menu");
        }
    }


    private MenuItem findItem(String itemName){
        for (MenuItem item: menu){
            if(item.itemName.equals(itemName)){
                return item;
            }
        }
        return null;
    }
}
public class RestaurentTest {
    public static void main(String[] args) {

        Restaurent restaurent = new Restaurent();
        boolean exit = false;
        while (!exit) {
            System.out.println(" 1.Add Item \n 2.Display Menu \n 3.Add Rating \n 4.Average Rating of Item \n 5.Exit");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Item name : ");
                    String itemName = sc.next();
                    System.out.print("Enter Item price : ");
                    double price = sc.nextDouble();
                    restaurent.addItem(itemName, price);
                    break;
                case 2:
                    restaurent.displayItem();
                    break;
             case  3 :
                 System.out.print("Enter name of the item for rating  ");
                 String itemNameRate = sc.next();
                 restaurent.addRating(itemNameRate);
                 break;
             case  4 :
                 System.out.print("Calculate average rating of ");
                 String averageRatingItem = sc.next();
                 restaurent.calculateAverageRating(averageRatingItem);
                 break;

                case 5  :
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
