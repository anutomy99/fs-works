package org.fs.oop.Encpsulation;


// Constructor
// Constructor is a special method, its name is same as the class name,
// it do not return any data.
// Constructor is called every time when we create an object.
// if we want to assign a value at the same time when the object is created we can use constructor.
public class Student1 {
    private int id;
    private String name;

    public Student1() {   //Default constructor
        id =102;
        name = "Anu";
        System.out.println("Constructor called");
    }

    public Student1(int id, String name) {  //Parameterized constructor accept 2 arguments both id and name
        this.id = id;
        this.name = name;
    }

    public Student1(String name) {   // Parameterized constructor only accept name
        this.id=101;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Student1 s=new Student1();
        Student1 s1=new Student1(102,"Anu");
        System.out.println("Id :"+s1.getId()+" Name : "+s1.getName());
        Student1 s2= new Student1("Malavika");
        System.out.println("Id :"+s2.getId()+" Name : "+s2.getName());

    }
}
