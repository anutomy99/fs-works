package org.fs.oop.Inheritance.HierarchicalInheritance;


class  A{
    public void messageFromA(){
        System.out.println("Am the parent class");
    }
}
class B extends A{
    public  void messageFromB(){
        System.out.println("Hello from child B");
    }
}
class  C extends  A{
    public  void  messageFromC(){
        System.out.println("Hello from child C");
    }
}
public class Test {
    public static void main(String[] args) {
        B b= new B();
        b.messageFromA();
        b.messageFromB();

        C c= new C();
        c.messageFromA();
        c.messageFromC();
    }
}
