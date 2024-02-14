package Thread;

class MyTask extends Thread {
    private int count;

    MyTask(String name, int count) {
        super(name);
        this.count = count;
    }

    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(300); // Simulate some work being done
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class JoinExample {
    public static void main(String[] args) {
        MyTask task1 = new MyTask("Thread-A", 3);
        MyTask task2 = new MyTask("Thread-B", 5);

        task1.start();
        try {
            task1.join();
            task2.join();// Main thread waits for task1 to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task2.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(300); // Simulate some work being done
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}