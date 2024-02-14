package Thread;

class DeamonThread extends Thread
{
    String threadName;

    public DeamonThread(String name){
        threadName = name;
    }

    public void run() {
        if(Thread.currentThread().isDaemon())
        {
            System.out.println(threadName + " is Daemon Thread");
        } else{
            System.out.println(threadName + " is User Thread");
        }
    }

    public static void main(String[] args)
    {
       DeamonThread thread1 = new DeamonThread("thread1");
        DeamonThread thread2 = new DeamonThread("thread1");

        // Making thread1 as Daemon
        thread1.setDaemon(true);

        thread1.start();
        thread2.start();
    }
}
