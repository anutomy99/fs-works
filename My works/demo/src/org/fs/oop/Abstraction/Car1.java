package org.fs.oop.Abstraction;

abstract class Vehicle {
    public  void engine() {
        System.out.println("Every vechicle has engine");
    }
    public  abstract  void  noOfWheels();
}

public class Car1 extends Vehicle{
    public  void noOfWheels(){
        System.out.println("Car has 4 tiers");
    }

    public static void main(String[] args) {
        Vehicle v=new Car1();
        v.noOfWheels();
        v.engine();

    }
}

