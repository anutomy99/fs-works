package DeamonThread;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private  String name;
    private int salary;

     public Employee(String name, int salary) {
         this.name = name;
         this.salary = salary;
     }

    public String getName() {
         return name;
     }
     public int getSalary() {
         return salary;
     }
    private void incrementSalary(int amount) {
        this.salary+=amount;
    }
    public static void displayAllEmployees(List<Employee> employeeList) {
         System.out.println("--------Employee List--------");
         employeeList
                 .forEach(employee -> System.out.println("Name:  "+employee.getName()+" Salary : "+employee.getSalary()));
        System.out.println("----------------------------");
    }
    public static void displayEmployeeWithSalary(List<Employee> employeeList) {
         System.out.println("Employees with salary > 20000");
         employeeList.stream()
                 .filter(employee -> employee.getSalary()>20000)
                 .forEach(employee -> System.out.println("Name :"+employee.getName()));
    }
    public static void employeeIncrementSalary(List<Employee> employeeList) {
        System.out.println("Employees with salary incremented by 5000");
        employeeList.stream()
                .filter(employee -> employee.getSalary()>20000)
                .forEach(employee -> {
                    employee.incrementSalary(5000);
                    System.out.println("Name :"+employee.getName()+" Incremented salary : "+employee.getSalary());
    });
    }
    public static void distinctSalary(List<Employee> employeeList) {

         List<Integer> distinctSalaries = employeeList.stream()
                 .map(Employee::getSalary)
                 .distinct()
                 .toList();
         System.out.println("Distinct salaries : "+distinctSalaries);

    }

}
class EmployeeStream{
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Anu",19000));
        employeeList.add(new Employee("Jithu",20000));
        employeeList.add(new Employee("Malu",21000));
        employeeList.add(new Employee("Melbi",22000));

        Employee.displayAllEmployees(employeeList);
        Employee.displayEmployeeWithSalary(employeeList);
        Employee.distinctSalary(employeeList);
        Employee.employeeIncrementSalary(employeeList);

    }
}