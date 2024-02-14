package Collection.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student id: "+id+"  Student name: "+name+"\n";
    }

    @Override
    public int compareTo(Student student) {
        return Integer.compare(this.id,student.id);
    }
}
public class StudentRunner {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(107,"Anu"));
        students.add(new Student(105,"Malu"));
        System.out.println(students);
        ArrayList<Student> studentList = new ArrayList<>(students);
        Collections.sort(studentList);
        System.out.println(studentList);
    }
}
