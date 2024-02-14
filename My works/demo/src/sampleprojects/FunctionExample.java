package sampleprojects;

public class FunctionExample {
    public static void main(String[] args) {
        FunctionExample fs=new FunctionExample();
//        int result1=  fs.add(3,2);
//        System.out.println(result1);
        int result2=fs.sub(3,2);
        System.out.println("After addition result : "+result2);
        Sample1 s=new Sample1();
        s.print();

    }
    public  int add(int a, int b){
        for(int i=1;i<=10;i++){
            System.out.println(i);

        }
        return a+b;

    }
    public int sub(int a,int b){
      int re=  add(4,3);
      System.out.println(("After Substraction "+re));
        return  a-b;
    }

}