package sampleprojects;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class User {
    int userId;
    String bookedFlightNumber;

    int bookedHotelId;

    public User(int userId, String bookedFlightNumber) {
        this.userId = userId;
        this.bookedFlightNumber = bookedFlightNumber;

    }

    public User(int userId, int bookedHotelId) {
        this.userId = userId;
        this.bookedHotelId = bookedHotelId;
    }

    public int getUserId() {
        return userId;
    }

    public String getBookedFlightNumber() {
        return bookedFlightNumber;
    }

    public int getBookedHotelId() {
        return bookedHotelId;
    }
}

class FlightDetails {
    String flightNumber;
    String flightName;
    String origin;
    String destination;
    String date;
    int totalSeats;
    int availableSeats;

    public FlightDetails(String flightNumber, String flightName, String origin, String destination, String date, int totalSeats) {
        this.flightNumber = flightNumber;
        this.flightName = flightName;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

}

    class BookFlight {
        public static void bookFlight(Scanner s, Map<String, FlightDetails> flightMap, Map<Integer, User> userMap, int userIdCounter) {
            int userId;
            User existingUser;
            do {
                userId = userIdCounter++;
                existingUser = userMap.get(userId);
            } while (existingUser != null);
            System.out.print("Enter flight number : ");
            String flightNumber = s.next();
            FlightDetails flight = flightMap.get(flightNumber);
            if (flight != null && flight.availableSeats > 0) {
                System.out.print("Enter number of seats to book : ");
                int seatsToBook = s.nextInt();
                if (seatsToBook <= flight.availableSeats) {
                    String bookedFlightNumber = flight.flightNumber;
                    flight.availableSeats -= seatsToBook;
                    User user = new User(userId, bookedFlightNumber);
                    userMap.put(userId, user);
                    System.out.println("Booking successfull user id is " + userId);
                    System.out.println("Do you Want to print the details ");
                    System.out.println(" 1.Yes \n 2.No");
                    System.out.print("Enter option : ");
                    int choice = s.nextInt();
                    boolean exit = false;
                    switch (choice) {
                        case 1:
                            System.out.println("------------------------------------------");
                            System.out.println(" User Id :" + userId + "\n Flight Number : " + flightNumber + "\n Flight Name : " + flight.flightName + "\n From : " + flight.origin + "\n To  : " + flight.destination + "\n No of seats booked : " + seatsToBook);
                            System.out.println("------------------------------------------");
                            break;
                        case 2:
                            exit = true;
                            System.out.println("Bye...Bye");
                            break;
                    }
                } else {
                    System.out.println("Booking faild no matching flights or Insufficent seats");
                }

            }
        }
    }
    class SearchFlight {

        public static void searchFlight(Scanner s, Map<String, FlightDetails> flightMap) {
            System.out.print("Enter Date for search : ");
            String searchDate = s.next();
            boolean found = false;
            System.out.println("-----Matching Results-------");
            for (FlightDetails flight : flightMap.values()) {
                if (flight.date.equals(searchDate)) {
                    System.out.println("Flight number " + flight.flightNumber + " " + flight.flightName + " From " + flight.origin + " To " + flight.destination + " Total seats " + flight.totalSeats + " available seats " + flight.availableSeats);
                    found = true;
                }

            }
            if (!found) {
                System.out.println("No flight found in this date");
            }

        }

    }
    class CancelFlight {
      public static void cancelFlight(Scanner s, Map<String, FlightDetails> flightMap, Map<Integer, User> userMap) {
            System.out.print("Enter user Id : ");
            int userIdToCancel = s.nextInt();
            User cancelingUser = userMap.get(userIdToCancel);
            if (cancelingUser != null) {
                FlightDetails bookedFlight = flightMap.get(cancelingUser.bookedFlightNumber);
                if (bookedFlight != null) {
                    if (userIdToCancel == cancelingUser.userId) {
                        System.out.print("Enter number of seats to cancel : ");
                        int seatsToCancel = s.nextInt();
                        if (seatsToCancel <= bookedFlight.totalSeats - bookedFlight.availableSeats) {
                            bookedFlight.availableSeats += seatsToCancel;
                            System.out.println("Cancellation successfull remaing seats : " + bookedFlight.availableSeats);
                        } else {
                            System.out.println("Cancellation faild.Cannot cancel seats more than u booked");
                        }
                    }else{
                        System.out.println("You cant cancel this.");
                    }
                }else{
                    System.out.println("Flight not found");
                }
            }else{
                System.out.println("User no found!");
            }
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------------

    class  HotelDetails {
        int hotelId;
        String hotelName;
        String place;
        int totalRooms;
        int availableRooms;


        public HotelDetails(int hotelId, String hotelName, String place, int totalRooms) {
            this.hotelId = hotelId;
            this.hotelName = hotelName;
            this.place = place;

            this.totalRooms = totalRooms;
            this.availableRooms = totalRooms;
        }

    }
        class BookHotel {
            public static void bookHotel(Scanner s, Map<Integer, HotelDetails> hotelMap, Map<Integer, User> userMap, int userIdCounter) {
                int userId;
                User existingUser;
                do {
                    userId = userIdCounter++;
                    existingUser = userMap.get(userId);
                } while (existingUser != null);
                System.out.print("Enter HotelId : ");
                int hotelId = s.nextInt();
                HotelDetails hotel = hotelMap.get(hotelId);
                if (hotel != null && hotel.availableRooms > 0) {
                    System.out.print("Enter number of rooms to book : ");
                    int roomsToBook = s.nextInt();
                    if (roomsToBook <= hotel.availableRooms) {
                        int bookedHotelId = hotel.hotelId;
                        hotel.availableRooms -= roomsToBook;
                        User user = new User(userId, bookedHotelId);
                        userMap.put(userId, user);
                        System.out.println("Booking successfull user id is " + userId);
                        System.out.println("Do you Want to print the details ");
                        System.out.println(" 1.Yes \n 2.No");
                        System.out.print("Enter option : ");
                        int choice = s.nextInt();
                        boolean exit = false;
                        switch (choice){
                            case 1 :
                                System.out.println(" User Id :"+userId+"\n Hotel Id : "+hotelId+"\n Hotel Name : "+hotel.hotelName+"\n Place : "+hotel.place+"\n No of rooms booked : "+roomsToBook);
                                System.out.println("-----------------------------------------------------------");
                                break;
                            case  2 :
                                exit =true;
                                System.out.println("Bye...Bye");
                                break;
                        }
                    } else {
                        System.out.println("Booking faild.Insufficent rooms");
                    }
                } else {
                    System.out.println("Booking faild no matching hotels or Insufficent rooms");
                }

            }
        }

        class SearchHotel {
            public static void searchHotel(Scanner s, Map<Integer, HotelDetails> hotelMap) {
                System.out.print("Enter place for search : ");
                String searchPlace = s.next();
                boolean found = false;
                System.out.println("-----Matching Results-------");
                for (HotelDetails hotel : hotelMap.values()) {
                    if (hotel.place.equals(searchPlace)) {
                        System.out.println("Hotel id " + hotel.hotelId + " " + hotel.hotelName + " Place " + hotel.place + " Total rooms " + hotel.totalRooms + " available rooms " + hotel.availableRooms);
                        found = true;
                    }

                }
                if (!found) {
                    System.out.println("No hotels available in this place");
                }
            }
        }

        class CancelHotel {

            public static void cancelHotel(Scanner s, Map<Integer, HotelDetails> hotelMap, Map<Integer, User> userMap) {
                System.out.print("Enter user Id : ");
                int userIdToCancel = s.nextInt();
                User cancelingUser = userMap.get(userIdToCancel);
                if (cancelingUser != null) {
                    HotelDetails bookedHotel = hotelMap.get(cancelingUser.bookedHotelId);
                    if (bookedHotel != null) {
                        if (userIdToCancel == cancelingUser.userId) {
                            System.out.print("Enter number of rooms to cancel : ");
                            int roomsToCancel = s.nextInt();
                            if (roomsToCancel <= bookedHotel.totalRooms - bookedHotel.availableRooms) {
                                bookedHotel.availableRooms += roomsToCancel;
                                System.out.println("Cancellation successfull remaing rooms : " + bookedHotel.availableRooms);
                            } else {
                                System.out.println("Cancellation faild.Cannot cancel rooms more than you booked");
                            }
                        } else {
                            System.out.println("You cant cancel this.");
                        }
                    } else {
                        System.out.println("Wrong UserID");
                    }
                } else {
                    System.out.println("User no found!");
                }
            }
        }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
        class BookingSystem1 {
            public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
                Map<String, FlightDetails> flightMap = new HashMap<>();
                FlightDetails flight1 = new FlightDetails("101A","FlightA","CityA","cityB","22/11/2023",20);
                FlightDetails flight2 = new FlightDetails("101B","FlightB","CityA","cityB","22/11/2023",20);
                FlightDetails flight3 = new FlightDetails("101C","FlightC","CityA","cityB","22/11/2023",20);

                flightMap.put(flight1.flightNumber, flight1);
                flightMap.put(flight2.flightNumber, flight2);
                flightMap.put(flight3.flightNumber, flight3);

                Map<Integer, HotelDetails> hotelMap = new HashMap<>();
                HotelDetails hotel1 = new HotelDetails(101, "Hotel-A", "CityA", 25);
                HotelDetails hotel2 = new HotelDetails(102, "Hotel-B", "CityA", 20);
                HotelDetails hotel3 = new HotelDetails(103, "Hotel-C", "CityB", 30);
                hotelMap.put(hotel1.hotelId, hotel1);
                hotelMap.put(hotel2.hotelId, hotel2);
                hotelMap.put(hotel3.hotelId, hotel3);

                Map<Integer, User> userMap = new HashMap<>();
                int userIdCounter = 1;
                System.out.println("Welcome to Booking system");
                int choice;
                while (true) {
                    System.out.println(" 1.Search Flight\n 2.Book Flight\n 3.Cancel Flight \n 4.Search Hotel \n 5.Book Hotel \n 6.Cancel Hotel");
                    System.out.print("Enter your choice : ");
                    choice = s.nextInt();
                    switch (choice) {
                        case 1:
                            SearchFlight.searchFlight(s, flightMap);
                            break;
                        case 2:
                            BookFlight.bookFlight(s, flightMap, userMap, userIdCounter);
                            break;
                        case 3:
                            CancelFlight.cancelFlight(s, flightMap, userMap);
                            break;
                        case 4:
                            SearchHotel.searchHotel(s, hotelMap);
                            break;
                        case 5:
                            BookHotel.bookHotel(s, hotelMap, userMap, userIdCounter);
                            break;
                        case 6:
                            CancelHotel.cancelHotel(s, hotelMap, userMap);
                            break;
                        default :
                            System.out.println("Invalid choice");
                    }
                }
            }
        }


