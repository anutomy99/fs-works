//package Thread;
//class SharedResource {
//    private boolean resourceReady = false;
//
//    public synchronized void waitForResource() {
//        while (!resourceReady) {
//            try {
//                wait(); // Release the lock and wait for a notification
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("Resource is ready. Performing operation...");
//    }
//
//    public synchronized void prepareResource() {
//        // Some logic to prepare the resource
//        System.out.println("Preparing the resource...");
//        resourceReady = true;
//        notify(); // Notify the waiting thread that the resource is ready
//    }
//}
//
//public class ThreadClassRunner{
//    public static void main(String[] args) {
//        SharedResource sharedResource = new SharedResource();
//
//        Thread waitingThread = new Thread(() -> sharedResource.waitForResource(), "WaitingThread");
//        Thread preparingThread = new Thread(() -> sharedResource.prepareResource(), "PreparingThread");
//
//        waitingThread.start();
//        preparingThread.start();
//    }
//}