package org.fs.oop.Inheritance.test1;

public class Parent {

    private   int x = 10;



    protected String name = "Anu";


   public   void print() {
       System.out.println("Hello "+name);

   }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
