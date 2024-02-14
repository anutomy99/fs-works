package Object;

class Student{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//     return   "ID: "+id+", Name :"+name;
//
//    }
}

public class ObIniConstructor {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Anu");
        s.setId(101);
        System.out.println(s.getId()+"  "+s.getName());
    }

}
