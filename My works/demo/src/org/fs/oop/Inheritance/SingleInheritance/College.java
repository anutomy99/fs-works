package org.fs.oop.Inheritance.SingleInheritance;

public class College {
    private int collegeId;
    private  String collegeName;

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public College(int collegeId, String collegeName) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
    }

    public void printCollegeDetails(String studentName){
        System.out.println("College Id : "+collegeId);
        System.out.println("College Name : "+collegeName);
        System.out.println("Student Name : "+studentName);
    }
}
