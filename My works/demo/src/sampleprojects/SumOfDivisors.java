package sampleprojects;

public class SumOfDivisors {

    private  int n;

    public  SumOfDivisors(int n){
        this.n=n;
    }

    public int findSum() {
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfDivisors sd=new SumOfDivisors(10);
        System.out.println("Sum is "+sd.findSum());



    }
}
