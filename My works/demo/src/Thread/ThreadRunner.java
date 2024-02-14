package Thread;
class Task1 extends Thread{
    public  void  run() {
        System.out.println("Task 1 started");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Task 1 Done");
    }
}
class Task2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Task 2 started");
        for (int i = 21; i <= 30; i++) {
            System.out.print(i + " ");

        }

        System.out.println("Task 2 Done");
    }
}

public class ThreadRunner {
    public static void main(String[] args) throws InterruptedException {

        Task1 task1 = new Task1();
        task1.setPriority(1);
        task1.start();

        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.setPriority(10);
        task2Thread.start();
        task1.join();

        task2Thread.join();
        System.out.println("Task 3 started");
        for (int i =31;i<=40;i++){
            System.out.print(i+" ");
        }
        System.out.println("Task 3 Done");
    }
}
