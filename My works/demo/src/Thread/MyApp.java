package Thread;

interface Callback {
    void onComplete();
}



 class Worker {
    public void doWork(Callback callback) {
        System.out.println("hello");
        // Do some work
        callback.onComplete();
    }
}

public class MyApp {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.doWork(new Callback() {
            @Override
            public void onComplete() {
                System.out.println("Work completed!");
            }
        });
    }
}
