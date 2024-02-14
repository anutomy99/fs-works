package OOP2.Interface;
interface Birds{
    void makeSound();
    void eat();
    void fly();
    void swim();
}
class Parrot implements Birds{

    @Override
    public void makeSound() {
        System.out.println("Make Something Sound");
    }

    @Override
    public void eat() {
        System.out.println("Eat Something ");

    }

    @Override
    public void fly() {
        System.out.println("fly");

    }

    @Override
    public void swim() {
        throw new UnsupportedOperationException("I cant swim");
    }
}
public class InterfaceSegregationTest {
    public static void main(String[] args) {
       Birds b = new Parrot();
       b.eat();
       b.makeSound();
       b.fly();
       b.swim();
    }
}
