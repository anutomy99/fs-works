package OOP2.Interface;
// Abstraction
interface  OnOffDevice {
    void turnOn();

    void turnOff();
}
// High -level module

class RemoteControl1 {
    private OnOffDevice device;

    public RemoteControl1(OnOffDevice device) {
        this.device = device;
    }

    public void pressOn() {
        device.turnOff();

    }

    public void pressOff() {
        device.turnOn();


    }
}
    class TV1 implements OnOffDevice {

        @Override
        public void turnOn() {
            System.out.println("TV ON");
        }

        @Override
        public void turnOff() {
            System.out.println("TV OFF");
        }
    }

    class Radio implements OnOffDevice {

        @Override
        public void turnOn() {
            System.out.println("Radio On");
        }

        @Override
        public void turnOff() {
            System.out.println("Radio off");
        }
    }

    public class DIPTest1 {
        public static void main(String[] args) {
            OnOffDevice radio = new Radio();
            RemoteControl1 remoteControl1 = new RemoteControl1(radio);
            remoteControl1.pressOff();
            remoteControl1.pressOn();

            OnOffDevice tv = new TV1();
            RemoteControl1 remoteControl11 = new RemoteControl1(tv);
            remoteControl11.pressOn();
            remoteControl11.pressOff();

            TV1 tv1 = new TV1();
            tv1.turnOff();
            tv1.turnOn();
        }
    }


