package sampleprojects;

import java.time.format.DateTimeFormatter;

class Parent{
    private  String name;
    private int age;

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Parent(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return " Parent name : " + name + "\n age : " + age;
    }
}
class Child extends  Parent{
    private String name;
    private int age;
    private DateTimeFormatter time;

    public Child(String parentName, String name, int age,DateTimeFormatter time) {
        super(parentName);
        this.name = name;
        this.age = age;
        this.time = time;


    }

    @Override
    public String toString() {
        return " Parent name : "+getName()+"\n Child name : "+name+"\n Age : "+age +"Time : ";
    }
}
public class Test {
    public static void main(String[] args) {
        Child c =new Child("Tomy","Anu",24,DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println(c);
        Parent p =new Parent("Tomy",53);
        System.out.println(p);
    }

}

