package sampleprojects;

public class LastDigit {
    public static void main(String[] args) {
        int n=000;
        if(n==0){
            System.out.println(0);
        } else if (n<0) {
            System.out.println(-1);
        }
        else {
            n=n%10;
            System.out.println(n);
        }
        }

    }

