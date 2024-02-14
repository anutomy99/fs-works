package DeamonThread;

import java.util.Scanner;

public class Rectangle {
    double length;
    double width;
    public Rectangle(double length,double width) {
        this.length = length;
        this.width = width;
    }


   public void rectangleArea(){
       double area= this.length * this.width;
       System.out.println("Area of the rectangle is  "+area );

   }
   public void reactanglePerimeter(){
        double perimeter =2 * (this.length + this.width);
        System.out.println("Perimeter of the rectangle is  "+perimeter);
   }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter length : ");
        double l= sc.nextDouble();
        System.out.print("Enter width : ");
        double a= sc.nextDouble();
        Rectangle r=new Rectangle(l,a);
        r.rectangleArea();
        r.reactanglePerimeter();
    }
}
