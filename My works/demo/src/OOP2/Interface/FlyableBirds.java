package OOP2.Interface;

public interface FlyableBirds {
    void  fly();
}
class Parrot1 implements FlyableBirds,Birds1{


    @Override
    public void makesound() {
        System.out.println("sound");
    }

    @Override
    public void eat() {
        System.out.println("eat");

    }

    @Override
    public void fly() {
        System.out.println("fly");

    }
}
class ISP{
    public static void main(String[] args) {
       Parrot1 p = new Parrot1();
       p.eat();
       p.makesound();
       p.fly();

    }

}

