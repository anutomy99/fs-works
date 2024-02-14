package OOP2;
 class Parent{
     void className(){
        System.out.println("Parent");
    }

}
   class Child extends Parent{

    protected void className(){
        System.out.println("Child1");
    }
}
class GrandChild extends  Child{
    public  final void className(){
        System.out.println("Grand Child");
    }
}

public class InheritanceRunner {
    public static void main(String[] args) {
//        Parent p =new Child();
//        p.className();
          Child c = new GrandChild();
          c.className();
          System.out.println("Java"=="Java");

    }
}
