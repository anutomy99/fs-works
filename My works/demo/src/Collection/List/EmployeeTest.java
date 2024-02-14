package Collection.List;

import java.io.PrintStream;
import java.util.ArrayList;

class Employees {
    private int id;
    private String name;
    private int salary;

    public Employees(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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




    public class EmployeeTest {
        public static void main(String[] args) {
            ArrayList<Employees> employeeList = new ArrayList<Employees>();
            employeeList.add(new Employees(101, "Anu", 100000));
            employeeList.add(new Employees(102, "Malu", 200000));
        }


    }
}
