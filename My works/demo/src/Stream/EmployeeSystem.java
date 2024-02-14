package Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void incrementSalary(int amount) {
        this.salary+=amount;
    }
}
    class EmployeeSystem {
        List<Employee> employeeList;

        public EmployeeSystem() {
            this.employeeList =new ArrayList<>();
        }
        public  void addEmployee( ){
            employeeList.add(new Employee(101,"Anu",20000));
            employeeList.add(new Employee(102,"Malu",22000));
            employeeList.add(new Employee(103,"Jithu",23000));
            employeeList.add(new Employee(104,"Melbi",20000));
        }
        public  void displayEmployeeDetails() {
            System.out.println("----------------------Employee Details----------------------");
             employeeList
                   .forEach(employee -> System.out.println("Employee Id : "+employee.getId()+", Employee Name : "+employee.getName()+", Salary : "+employee.getSalary()));
        }
        public void salaryGraterThan20000() {
            System.out.println("----------------Employee List Salary >20000------------------");
            employeeList.stream()
                    .filter(employee -> employee.getSalary()>20000)
                    .forEach(employee -> System.out.println("Employee Id : "+employee.getId()+", Employee Name : "+employee.getName()+", Salary : "+employee.getSalary()));

        }
        public  void incrementSalary(int amount) {
            System.out.println("----------------Employee with incremented salary------------------");
            employeeList.stream()
                    .filter(employee -> employee.getSalary()>20000)
                    .forEach(employee -> {employee.incrementSalary(amount);
                               System.out.println("Employee Id : "+employee.getId()+",  Employee Name : "+employee.getName()+",Salary :  "+employee.getSalary());
                    });
        }
        public void distinctSalary() {
            System.out.println("----------------Distinct Salaries------------------");
          List<Integer> distinctSalaries = employeeList.stream()
                    .map(Employee::getSalary)
                    .distinct()
                    .collect(Collectors.toList());
          System.out.println(distinctSalaries);


        }

        public static void main(String[] args) {

            EmployeeSystem employeeSystem = new EmployeeSystem();

            employeeSystem.addEmployee();
            employeeSystem.displayEmployeeDetails();
            employeeSystem.salaryGraterThan20000();
            employeeSystem.incrementSalary(5000);
            employeeSystem.distinctSalary();
        }




    }
