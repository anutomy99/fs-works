package org.fs.oop.Inheritance.MultilevelInheritance;

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


}
