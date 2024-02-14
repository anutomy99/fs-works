package Object;

class  Employee{
    int id;
    String name;

    public void display() {
        System.out.println("Id :"+id+"   Name : "+name);
    }
}
public class ObjInitReference {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.id =101;
        e.name ="Anu";
        e.display();
    }

}
