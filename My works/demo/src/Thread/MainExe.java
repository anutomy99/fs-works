package Thread;
class TestThread extends  Thread{
    @Override
    public void run(){
        System.out.println("Hello");

    }
}

public class MainExe {
    public static void main(String[] args) throws InterruptedException {
        TestThread testThread = new TestThread();
        TestThread testThread2 = new TestThread();
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        testThread.start();

        testThread2.start();
    }
}
