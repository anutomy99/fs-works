package org.fs.oop.Polymorphism;
class A{
    public void show(){
        System.out.println("In A show");
    }
}
class B extends A{
    public void show(){
        System.out.println("In B show");
    }
}
public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.show();

        a = new B();
        a.show();
    }
}
