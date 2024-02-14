package org.fs.oop.Encpsulation;

class Vehicle{
    public Vehicle() {

        System.out.println("Vehicle constructor");
    }
    public Vehicle(String name){
        System.out.println("Vehicle name");


    }
}
 class Car extends  Vehicle{
     public Car() {

         System.out.println("Car constructor");
     }
     public  Car(String name){
         this();
         System.out.println("Car Name "+name);

     }

     public static void main(String[] args) {
      Car c = new Car("BMW");
    }

}
