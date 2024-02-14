package DeamonThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight{
    private  static List<Flight> flights = new ArrayList<>();
    private int flightNumber;
    private String flightName;
    private String origin;
    private String destination;
    private String date;
    private int totalSeats;
    private int availableSeats;

    public Flight(int flightNumber, String flightName, String origin, String destination, String date, int totalSeats) {
        this.flightNumber = flightNumber;
        this.flightName = flightName;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }


    public int getFlightNumber() {
        return flightNumber;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }


    public int getAvailableSeats() {
        return availableSeats;
    }
    public static void addFlight(Flight flight) {
        flights.add(flight);
    }
    public boolean bookFlight(int seatcount) {
        if(availableSeats >=seatcount){
            availableSeats -=seatcount;
            System.out.println("Flight booked successfully! Remaing seats "+availableSeats);
            return true;
        }else {
            System.out.println("Not available");
            return false;
        }
    }
    public static List<Flight> searchFlights(String searchDate, String searchOrigin, String searchDestination) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight: flights
        ) {
            if(flight.getDate().equals(searchDate)&&flight.getOrigin().equals(searchOrigin)&&flight.getDestination().equals(searchDestination)){
                result.add(flight);
            }
        }
        return  result;
    }

    public static Flight searchFlights(int FlightNumber) {
        for (Flight flight : flights
        ) {
            if(flight.getFlightNumber()==FlightNumber){
                return flight;
            }
        }
        return  null;
    }
    public boolean cancelReservation(int cancelSeatCount) {
        if(cancelSeatCount <= totalSeats-availableSeats){
            availableSeats += cancelSeatCount;
            System.out.println("Reservation cancelled successfully");
            return  true;
        }else {
            System.out.println("Invalid number of seats to cancel");
            return false;
        }
    }

}

//--------------------------------------------------------------------------------------------------
class BookingSystem{
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println(" 1.Add flight \n 2.Search Flights \n 3.Book Flight \n 4.Cancel Reservation \n");
            System.out.print("Enter your choice : ");
            int choice =s.nextInt();
            switch (choice){
                case  1 :
                    System.out.print("Enter flight number : ");
                    int flightNumber = s.nextInt();
                    System.out.print("Enter flight name : ");
                    String flightName = s.next();
                    System.out.print("Enter origin : ");
                    String origin = s.next();
                    System.out.print("Enter destination : ");
                    String destination = s.next();
                    System.out.print("Enter date : ");
                    String date = s.next();
                    System.out.print("Enter total seats : ");
                    int totalseats = s.nextInt();
                    Flight.addFlight(new Flight(flightNumber,flightName,origin,destination,date,totalseats));
                    System.out.println("-------Flight added successfully------");
                    break;
                case 2 :
                    System.out.print("Enter date for search: ");
                    String searchDate = s.next();
                    System.out.print("Enter origin for search : ");
                    String searchOrigin = s.next();
                    System.out.print("Enter destination for search : ");
                    String searchDestination = s.next();
                    List<Flight> searchResult = Flight.searchFlights(searchDate,searchOrigin,searchDestination);
                    if(!searchResult.isEmpty()){
                        System.out.println("----------------Matching results---------------");
                        for (Flight flight: searchResult
                             ) {
                            System.out.println("Flight number "+flight.getFlightNumber()+"  "+flight.getFlightName()+"  From  "+flight.getOrigin()+" To "+flight.getDestination()+" "+flight.getAvailableSeats()+" seats available");
                        }
                    }else {
                        System.out.println("No matching results");
                    }
                    break;
                case 3 :
                    System.out.print("Enter flight number to book : ");
                    int bookFlightNumber = s.nextInt();
                    System.out.print("Enter number of seats to book : ");
                    int seatsToBook = s.nextInt();
                    Flight bookResult = Flight.searchFlights(bookFlightNumber);
                    if(bookResult !=null){
                        bookResult.bookFlight(seatsToBook);

                    }else {
                        System.out.println("Flight not found");
                    }
                    break;
                case 4 :
                    System.out.print("Enter flight number for cancellation : ");
                    int cancelFlightNumber = s.nextInt();
                    System.out.print("Enter number of seats to cancel : ");
                    int cancelSeats = s.nextInt();
                    Flight cancelResult = Flight.searchFlights(cancelFlightNumber);
                    if(cancelResult != null){
                        cancelResult.cancelReservation(cancelSeats);
                    }else{
                        System.out.println("Flight not found.Cannot cancel reservation");
                    }
                default:
                    System.out.println("Invalid Choice");
            }

        }
    }
}

