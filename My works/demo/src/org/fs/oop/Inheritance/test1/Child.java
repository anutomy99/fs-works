package org.fs.oop.Inheritance.test1;

public class Child extends Parent {
    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.name);
        System.out.println(c.getX());
        c.print();
    }
}
