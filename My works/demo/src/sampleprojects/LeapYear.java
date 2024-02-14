package sampleprojects;

public class LeapYear {
    static void isLeapYear(int year){
        if(year<1){
            System.out.println("Not Leap Year");
        }
        if (year%4!=0 || year%400==0 || year %100!=0){
            System.out.println("Leap Year");
        }
        else {
            System.out.println("Not Leap Year");
        }
    }

    public static void main(String[] args) {
        isLeapYear(400);
    }
}

