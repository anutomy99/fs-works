package OOP2.Interface;
class Bird1{
    void fly1(){
         System.out.println("Bird can fly");
     }
}
class Sparrow extends Bird1{
     void chirp(){
         System.out.println("Sparrow  is chirpping");

     }

}
class Ostrich extends  Bird1{
    void hideHead(){
        System.out.println("Ostrich  is hiding head");
    }

}


public class LSPExample {
    public static void main(String[] args) {
        Bird1  sparrow= new Sparrow();
        sparrow.fly1();
        Bird1 ostrich =new Ostrich();
        ostrich.fly1();
    }
}
