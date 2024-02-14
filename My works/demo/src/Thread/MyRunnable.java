package Thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Hello");
    }
}
class Main{
    public static void main(String[] args) {
       MyRunnable r = new MyRunnable();
       Thread t = new Thread(r);
       Thread t1 = new Thread(r);
       t.start();
       t.setName("Thread1");
       t1.start();
       t1.setName("Thread2");
       }

}

