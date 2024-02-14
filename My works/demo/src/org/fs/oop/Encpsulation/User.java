package org.fs.oop.Encpsulation;

public class User {
    public static void main(String[] args) {
        Employee e=new Employee();
        e.setId(004);
        e.setName("Anu");
        e.setSalary(10000);
        System.out.println(" Id :"+e.getId() +"\n Name: "+e.getName()+"\n Salary: "+e.getSalary());

    }

}
