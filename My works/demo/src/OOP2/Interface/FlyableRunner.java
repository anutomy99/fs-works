package OOP2.Interface;

interface  Flyable{
    void fly();

}
class  Bird implements FlyableBirds {

    @Override
    public void fly() {
        System.out.println("With wings");
    }
}
class Aeroplane implements FlyableBirds {

    @Override
    public void fly() {
        System.out.println("With fuel");
    }
}
public class FlyableRunner {
    public static void main(String[] args) {
      FlyableBirds flyingOb[] ={new Bird(),new Aeroplane()};
        for (FlyableBirds object: flyingOb) {
            object.fly();
        }
    }

}
