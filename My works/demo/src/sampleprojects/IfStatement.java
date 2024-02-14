package sampleprojects;

public class IfStatement {
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    private int mark;

    public IfStatement(int mark){
        this.mark=mark;
    }

    public void displayMarks(){
        if(this.mark<0  || this.mark>100){
            System.out.println("X");
        } else if (this.mark>=80 && this.mark<90) {
            System.out.println("B");

        } else if (this.mark>=70 && this.mark<80) {
            System.out.println("C");

        } else if (this.mark>=60 && this.mark<70) {
            System.out.println("D");

        } else if (this.mark>=50 && this.mark<60) {
            System.out.println("E");

        } else  {
            System.out.println("F");

        }
    }

    public static void main(String[] args) {
        IfStatement f=new IfStatement(120);
        f.setMark(50);
        f.getMark();

        f.displayMarks();
    }
    }

