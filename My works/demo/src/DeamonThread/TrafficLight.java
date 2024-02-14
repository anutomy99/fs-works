package DeamonThread;

import java.time.Duration;
import java.time.Instant;

public class TrafficLight {
    private  String color;
    private Instant lastColorChangeTime;
    private Duration duration;

    public String getColor() {
        return color;
    }
    public Duration getDuration() {
        return duration;
    }


    public  TrafficLight(String color, Duration duration){
        this.color=color;
        this.lastColorChangeTime=Instant.now();
        this.duration=duration;
    }

    public void changeColor(){
        if(Duration.between(lastColorChangeTime,Instant.now()).toSeconds()>=20) {
            if (color.equals("red")) {
                color = "green";

            } else {
                color = "red";
            }
            lastColorChangeTime = Instant.now();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        TrafficLight t = new TrafficLight("red", Duration.ofSeconds(20));
        System.out.println("Current color:" + t.getColor());
        System.out.println("Time :" + t.getDuration());
        while (true) {
            t.changeColor();
            System.out.println("Current color: "+t.getColor());
            System.out.println("Remaining Time: " + Duration.between(Instant.now(), t.lastColorChangeTime.plus(t.duration)).toSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }



