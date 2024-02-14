package sampleprojects;

public   interface view {
    default  void print(){
        System.out.println("Hi from interface....");
    }
    public  static void show(){
        System.out.println("Showing interface details");
    }
   void  message();

}
class  display implements view{
    public  void  message(){
        System.out.println("Hello from class.....");
    }

    public static void main(String[] args) {
        view v = new display();
        view.show();
        v.print();
        v.message();


    }
}
