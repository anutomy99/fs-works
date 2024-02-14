package org.fs.oop.Inheritance.MultilevelInheritance;

public class Course extends  Student{
    private  String  courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Course(int collegeId, String collegeName, String studentName, String courseName) {
        super(collegeId, collegeName, studentName);
        this.courseName=courseName;
    }

        public void printDetails(){
        System.out.println("College Id : "+getCollegeId());
        System.out.println("College Name : "+getCollegeName());
        System.out.println("Student Name : "+getStudentName());
        System.out.println(getStudentName()+" entrolled "+getCourseName());

    }
    public static void main(String[] args) {
        Course c1 = new Course(101,"Donbosco","Anu","Java");

        Course c2= new Course(102,"Donbosco","Malu","Java");
        c1.printDetails();
        c2.printDetails();

    }
}
