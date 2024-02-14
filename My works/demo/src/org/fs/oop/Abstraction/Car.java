package org.fs.oop.Abstraction;

public interface Car
{
    public void start();
}
class BMW implements Car {


    public  void engine() {
     System.out.println("BMW Engine");
    }

    @Override
    public void start() {
        System.out.println("BMW Started");
    }

    public static void main(String[] args) {

        Car c=new BMW();
        c.start();

       BMW  b=(BMW) c;
       b.start();
       b.engine();



    }
}