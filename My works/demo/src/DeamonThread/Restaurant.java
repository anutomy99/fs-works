package DeamonThread;

public  class Restaurant{
    private  String[] menuItems;
    private  double[] prices;
    private  int[] ratings;

    private double[] totalRating;

    public Restaurant(int size) {
        menuItems = new String[size];
        prices =new double[size] ;
        ratings = new int[size];
        totalRating = new double[size];
    }
//    public void addMenuItem(String itemName, double itemPrice, int itemRating, int index) {
//     if(ratings[index]==0){
//         menuItems[index] =itemName;
//     }
//     ratings[index]++;
//
//        }
//
//    }

    public double[] averageRatings() {
        double[] averageRatings = new double[ratings.length];

        for(int i = 0;i<ratings.length;i++){
            if(ratings[i]==0){
                averageRatings[i] =0.0;

            }else {
                averageRatings[i] = totalRating[i]/ratings[i];

            }
        }

        return averageRatings;
    }
    public static void main(String[] args) {
//        Restaurant restaurant = new Restaurant(3);
//        restaurant.addMenuItem("Pizza",550.0,2,0);
//        restaurant.addMenuItem("Pizza",250.0,4,1);
//        restaurant.addMenuItem("Pizza",500.0,4,2);
//
//        double[] averageRatings = restaurant.averageRatings();
//
//        for(int i = 0;i <averageRatings.length;i++){
//            System.out.println("Average Rating for : "+restaurant.menuItems[i]+":"+averageRatings[i]);
//        }

    }




}
