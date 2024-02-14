package org.fs.oop.thisAndSuper;

class  A{
    public A() {
        System.out.println("Default constructor of A");
    }
    public A(int a){
        System.out.println("Parameterized constructor of A");
    }

}
class  B extends A{
    public B() {
        super(5);
        System.out.println("Default constructor of B");
    }
    public B(int a){
        this();

        System.out.println("Parameterized constructor of B");
    }
}
public class Main {
    public static void main(String[] args) {
        B b = new B(3);


    }
}
