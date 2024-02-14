package org.fs.oop.Inheritance.MultilevelInheritance;

import org.fs.oop.Inheritance.SingleInheritance.College;

public class Student extends College {

    private  String studentName;
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Student(int collegeId, String collegeName, String studentName) {
       super(collegeId,collegeName);
       this.studentName=studentName;


    }

//    public static void main(String[] args) {
//        Student s = new Student(101,"Donbosco","Anu");
//        s.printCollegeDetails(s.getStudentName());
//    }
}
