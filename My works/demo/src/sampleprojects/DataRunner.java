package sampleprojects;

import java.util.HashMap;
import java.util.Map;

class College {
    private int collegeId;
    private String collegeName;
    Map<Integer, College> collegeMap = new HashMap<>();

    public College() {

    }


    public void addCollege() {
        collegeMap.put(101, new College(101, "DBC"));
    }


    public College(int i, String dbc) {
    }


}
    class Student extends  College{
    private  int studentId;
    private  String studentName;




}
class DataRunner {
    public static void main(String[] args) {
        Map<Integer, College> collegeMap = new HashMap<>();
        College c = new College();
        c.addCollege();
    }

}
