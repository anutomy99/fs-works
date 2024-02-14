package org.fs.oop.Encpsulation;


// importance of 'this' key word
// if the local and instance variable have the same name then,
// if we want to get the current object reference we use 'this' keyword
public class Student{
    private  int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    //   public void setId(int id, Student s) {
        // if we do like this it will create a new object so we cant change the existing object
//         Student s1= new Student();
//         s1.id = id;
//        Student s1 = s;
//       s1.id=id;

    //}

    // in the above case we use same object for calling and the for passing as an argument
    // so to avoid this java will give solution that is by using 'this' keyword.

    public  void  setId(int id){
        this.id=id;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Student s=new Student();
      //  s.setId(102,s); // Here we pass the object itself
        s.setId(102);
        s.setName("Anu");
        s.setAge(24);
        System.out.println("ID :"+s.getId()+", Name:"+s.getName()+", Age:"+s.getAge());

    }
}
