package OOP2;

class Person{
    private  String name;
    private  String email;

    private  int age;

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name : %s, Email : %s ,Age : %d ,",name,email,age);
    }
}
public class Student extends Person {

    private String college;
    private String course;


    public Student(String name, String email, int age,String college,String course) {
        super(name, email, age);
        this.college = college;
        this.course = course;

    }


    @Override
    public String toString() {
        return String.format(super.toString()+"College: %s,Course: %s ",college,course);
    }

    public static void main(String[] args) {
        Student s = new Student("Anu","anu@gmail.com",24,"Donbosco","MCA");
        System.out.println(s);
    }
}
