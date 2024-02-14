package org.fs.oop.Inheritance.test2;

import org.fs.oop.Inheritance.test1.Child;
import org.fs.oop.Inheritance.test1.Parent;

public class Child2 extends Parent  {
    public static void main(String[] args) {
        Child2 c2 = new Child2();
//        Child c= new Child();

        System.out.println(c2.getX());
//        c.print();
    }
}
