package Thread;

class SharedTable
{
   void printTable(int n){
        synchronized(SharedTable.class){//synchronized block
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+" "+n*i);
                try{
                    Thread.sleep(400);
                }catch(Exception e){System.out.println(e);}
            }
        }
    }//end of the method
}

class PrintThread1 extends Thread{
    SharedTable t;
    PrintThread1(SharedTable t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }

}
class PrintThread2 extends Thread{

    SharedTable t;
    PrintThread2(SharedTable t){
        this.t=t;
    }
    public void run(){
        t.printTable(100);
    }
}

public class TestSynchronizedBlock1{
    public static void main(String args[]){
        SharedTable obj = new SharedTable();//only one object
        SharedTable obj1 = new SharedTable();
        PrintThread1 t1=new PrintThread1(obj);
        PrintThread2 t2=new PrintThread2(obj1);
        t1.start();
        t2.start();
    }
}