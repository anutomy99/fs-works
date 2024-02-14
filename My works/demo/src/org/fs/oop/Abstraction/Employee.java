package org.fs.oop.Abstraction;

public class Employee extends Person {
    private int id;
    public Employee(String name, String gender,int EmployeeId) {
        super(name, gender);
        this.id=EmployeeId;
    }



    public static void main(String[] args) {
        Employee e=new Employee("Anu","Female",101);
        e.office();
        e.changeName(e.getName());
    }



    @Override
    public void office() {
        if(id==0){
            System.out.println("Employee Loggedout");
        }else {
            System.out.println("Employee LoggedIn");
        }
    }
}
