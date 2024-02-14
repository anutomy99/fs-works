package Collection.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee{
    private int empNo;
    private String empName;
    private int empSalary;

    public Employee(int empNo, String empName, int empSalary) {
        this.empNo = empNo;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public Employee() {

    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }
    public void addEmployee(int number,String name,int salary){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter employee number: ");
        int empNmbr = s.nextInt();
        System.out.println("Enter Employee name: ");
        String empName = s.next();
        System.out.println("Enter Employee Salary: ");
        int empSalary = s.nextInt();

    }
}
