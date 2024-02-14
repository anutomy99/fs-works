package Thread;
class Display
{
    public static synchronized   void wish(String name)
    {
        for(int i=0;i<3;i++)
        {
            System.out.print(Thread.currentThread().getName()+" Good Morning: ");
            System.out.println(name);
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e)
            {
            }
        }
    }
}

class MyThread extends Thread{
    Display d;
    String name;
    MyThread(Display d,String name)
    {
        this.d=d;
        this.name=name;
    }
    public void run()
    {
        d.wish(name);
    }
}

class StaticSynchronizationExample{
    public static void main(String arg[])
    {
        Display d1=new Display();
        Display d2=new Display();

        MyThread t1=new MyThread(d1,"Malu");
        t1.setName("Thread1");
        MyThread t2=new MyThread(d1,"Anu");
        t2.setName("Thread2");
        MyThread t3=new MyThread(d2,"Malu");
        t3.setName("Thread3");
        MyThread t4=new MyThread(d2,"Anu");
        t4.setName("Thread4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}