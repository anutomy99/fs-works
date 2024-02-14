package OOP2.Interface;

class RemoteControl{
    private  TV tv = new TV();



    public void pressOn(){
        tv.turnOn();
    }
    public void pressOff(){
        tv.turnOff();
    }


}
class TV {

    public void turnOn() {
        System.out.println("TV is ON");
    }

    public void turnOff() {
        System.out.println("TV is OFF");
    }
}

public class DIPTest {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();
        control.pressOn();
        control.pressOff();
    }
}
