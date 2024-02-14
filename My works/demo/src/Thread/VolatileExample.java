package Thread;

class SharedResource {
    private volatile int counter = 0;

    public void incrementCounter() {
        for (int i = 0; i < 5; i++) {
            counter++;
            System.out.println("Counter incremented to: " + counter);
            try {
                Thread.sleep(100); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCounter() {
        return counter;
    }
}

class IncrementThread extends Thread {
    private SharedResource sharedResource;

    public IncrementThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.incrementCounter();
    }
}

class ReadThread extends Thread {
    private SharedResource sharedResource;

    public ReadThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (sharedResource.getCounter() < 5) {}
        System.out.println("ReadThread detected that the counter is now 5.");
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        IncrementThread incrementThread = new IncrementThread(sharedResource);
        incrementThread.start();

        ReadThread readThread = new ReadThread(sharedResource);
        readThread.start();
    }
}