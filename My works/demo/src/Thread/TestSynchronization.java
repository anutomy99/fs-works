package Thread;
class Table{
    synchronized void printTable(int n)//synchronized method
    {
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){
                System.out.println(e);}
        }

    }
}
class MyThread1 extends Thread{
    SharedTable t;
    MyThread1(SharedTable t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }

}
class MyThread2 extends Thread{
    SharedTable t;
    MyThread2(SharedTable t){
        this.t=t;
    }
    public void run(){
        t.printTable(100);
    }
}

public class TestSynchronization {
    public static void main(String args[]){
        SharedTable obj = new SharedTable();//only one object
        MyThread1 t1=new MyThread1(obj);
        PrintThread2 t2=new PrintThread2(obj);
        t1.start();
        t2.start();
    }
}
