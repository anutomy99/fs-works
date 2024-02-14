package JavaDates;
import java.time.*;
public class DateTime {
    public static void main(String[] args) {
        LocalDate l1 = LocalDate.now();
        LocalDateTime l2 = LocalDateTime.now();
        LocalTime l3 = LocalTime.now();
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l2.getDayOfMonth());
        System.out.println(l2.getDayOfWeek());
        System.out.println(l2.getDayOfYear());
//        System.out.println(l2.getSecond());
        while(true){
            System.out.println(LocalTime.now().getSecond()+" seconds");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }






    }
}
