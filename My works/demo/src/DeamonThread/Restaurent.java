package DeamonThread;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurent {
    static Scanner sc = new Scanner(System.in);
    private  String itemName;
    private  double price;
    private ArrayList<Double> ratings = new ArrayList<Double>();

    public  void  addItem(){
        System.out.println("Enter item name :");
        String item = sc.next();
        System.out.println("Enter item price: ");
        double price = sc.nextDouble();
        itemName = item;
        this.price = price;
        System.out.println("Item added successfully");
    }
    public  void rateItem(){
        if(itemName ==null){
            System.out.println("No item added yet .. Please add Item");

        }else {
            addRating();

        }
    }
    public  void addRating() {
        if (itemName == null){
            System.out.println("Item not found");
        }else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please Rate this item....");
            double newRating = sc.nextDouble();
            ratings.add(newRating);

        }

    }
    public  int getNumberOfRatings(){

        return ratings.size();
    }
    public  double getTotalOfRatings(){
        double total = 0.0;
        for (double rating:ratings) {
            total +=rating;
        }
        return total;
    }
    public void getAverageRating() {
        if(itemName==null){
            System.out.println("Item Not found ...");
        }else {
            double total = getTotalOfRatings();
            int number = getNumberOfRatings();
            BigDecimal average = new BigDecimal(total).divide(new BigDecimal(number), 3, RoundingMode.UP);
            System.out.println("Average Rating of " + itemName + " is " + average);
        }

    }

    public  void  displayItemDetails(){
        if (itemName == null){
            System.out.println("No item found..........");
        }else {
            System.out.println(" Item Name : " + itemName + " \n Price : " + price);
            if (ratings.isEmpty()) {
                System.out.println(".....No Ratings.....");
            } else {
                System.out.println(" Ratings : " + ratings);
            }
        }
    }
    public void removeItem(String itemName){
        System.out.println("Enter item name");
        String removeItem =sc.next();
        if(itemName.equals(removeItem)){
            this.itemName =null;
            price = 0;
            ratings.clear();
            System.out.println("Item removed successfully");
        }else{
            System.out.println("Please make sure that you are enter the correct item");
        }
    }
    public static void main(String[] args) {

        Restaurent r =new Restaurent();
        boolean exit = false;
        while (!exit) {
            System.out.println(" 1.Add Item \n 2.Rate Item \n 3.Didplay Item \n 4.Average rating of Item \n 5.remove item \n 6.exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    r.addItem();
                    break;
                case  2:
                    r.rateItem();
                    break;
                case  3:
                    r.displayItemDetails();
                    break;
                case  4:
                    r.getAverageRating();
                    break;
                case  5:
                    r.removeItem(r.itemName);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Bye...Bye....");
                    break;
                default:
                    System.out.println("Invalid credentials");
            }
        }
    }

}

