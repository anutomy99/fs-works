package Thread.synchronization;

class book {

    static int tickets = 1;

     synchronized  void book(int request, String name)
    {

        if (tickets >= request) {
            System.out.println(name + " booked " + request
                    + " ticket.");
            tickets = tickets - 1;
            System.out.println("Tickets left: " + tickets);
        }
        else {
            System.out.println("No tickets are available.");
        }
    }
}

class myThread extends Thread {
    book obj;
    int n;
    String name;
    myThread(book obj, String name, int n)
    {
        this.obj = obj;
        this.n = n;
        this.name = name;
    }

    public void run() {
        obj.book(n, name); }
}

public class MovieTickets2 {

    public static void main(String[] args)
    {

        book obj1 = new book();
        book obj2 = new book();
        myThread t1 = new myThread(obj1, "Anu", 1);
        myThread t2 = new myThread(obj2, "Malu", 1);

        t1.start();
        t2.start();
    }
}


