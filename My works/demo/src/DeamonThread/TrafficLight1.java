package DeamonThread;

public class TrafficLight1 {
    private String color;
    private int duration;

    public int getDuration() {

        return duration;
    }
    public String getColor() {
        return color;
    }
    public TrafficLight1(String initialColor,int initialDuration) {
        color = initialColor;
        duration=initialDuration;
    }
   public void changeColor(String newColor, int newDuration){

    while (true){
           System.out.println("Current Color: " + newColor);
           for (int duration = newDuration; duration >= 1; duration--) {
               System.out.println("Duration " + duration + " sec");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               this.color = newColor;
           }

           if (newColor.equals("Red")) {
               newColor= "Green";

           } else {
               newColor = "Red";
           }
//           System.out.println("After changing :"+newColor);
       }

   }

    public static void main(String[] args) {
       TrafficLight1 tl = new TrafficLight1("Red",10);
       tl.changeColor(tl.getColor(), tl.getDuration());

    }
}
