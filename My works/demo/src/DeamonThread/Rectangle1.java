package DeamonThread;

import java.util.Scanner;

public class Rectangle1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the length :");
        double l = s.nextDouble();
        System.out.print("Enter the width :");
        double w = s.nextDouble();
        Rectangle1 r=new Rectangle1();
        double a= r.area(l,w);
        double p= r.perimeter(l,w);
        System.out.println("Area of rectangle is " +a);
        System.out.println("Perimeter of rectangle is " +p);



    }

    public double area(double l,double w){
        double area=l * w;
        return  area;
    }

    public  double perimeter(double l,double w){
        double perimeter = 2 * (l+w);
        return perimeter;
    }
}
