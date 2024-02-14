package OOP2.Interface;
interface Interface1{
     int i =10;
     int j=i;
     void run();
     void stop();

}
interface Interfce2 extends  Interface1{
    @Override
    void run();
}
abstract class  ClassA implements Interfce2{

    @Override
    public void stop() {

    }

}
public class InterfaceRunner {
    public static void main(String[] args) {

    }
}
