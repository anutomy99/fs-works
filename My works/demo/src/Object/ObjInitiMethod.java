package Object;

class Employee1 {
    String companyName;
    String employeeName;

    public void display(String feathersoft, String anu) {
        System.out.println("Company Name : "+companyName+" Employee Name : "+employeeName);
    }
}
public class ObjInitiMethod {
    public static void main(String[] args) {
        Employee1 e1 = new Employee1();
        e1.display("Feathersoft","Anu");
    }
}
