package org.fs.oop.Inheritance.HybridInheritance;

interface main{
    public  void mainMessage();
}
interface  A extends main{
    public void messageOfA();
}
interface B extends main{
    public  void  messageOfB();
}
class C implements A,B{

    @Override
    public void messageOfA() {
        System.out.println("Implimentation for the interface A");
    }

    @Override
    public void messageOfB() {
        System.out.println("Implimentation for the interface B");

    }

    @Override
    public void mainMessage() {
        System.out.println("Implimentation for the main interface");

    }
    public void messageOfC(){
        System.out.println("Message from c's Own method");

    }
}
public class Test {
    public static void main(String[] args) {
        C c=new C();
        c.mainMessage();
        c.messageOfA();
        c.messageOfB();
        c.messageOfC();
    }
}
