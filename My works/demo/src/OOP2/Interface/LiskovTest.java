package OOP2.Interface;

import java.util.ArrayList;
import java.util.List;

class Vehicle{
    public Integer noOfWheels(){
      return  2;
    }
    public  Boolean hasEngie(){
        return true;
    }

}
//class Car extends Vehicle {
//    @Override
//    public Integer noOfWheels() {
//        return 4;
//    }
//}
//
//class Bike extends Vehicle{
//    @Override
//    public Integer noOfWheels() {
//        return 2;
//    }
//}
class EngineVehicle extends Vehicle{
    @Override
    public Integer noOfWheels() {
        return 4;
    }

    @Override
    public Boolean hasEngie() {
        return true;
    }
}
class Car extends  EngineVehicle{
    @Override
    public Integer noOfWheels() {
        return 4;
    }

    @Override
    public Boolean hasEngie() {
        return true;
    }
}
class ByCycle extends  Vehicle{

    @Override
    public Integer noOfWheels() {
        return 2;
    }

    @Override
    public Boolean hasEngie() {
       return false;
    }
}


public class LiskovTest {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car());
//        vehicleList.add(new Bike());
        vehicleList.add(new ByCycle());
        for ( Vehicle v : vehicleList ){  // Here we can call only the noOfwheels() which is visible in Vehicle class
            System.out.println(v.hasEngie().toString());
        }

    }
}

