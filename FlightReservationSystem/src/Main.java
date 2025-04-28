import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Flight> flights = new ArrayList<>();
    private static final ArrayList<Reservation> reservations = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedFlights();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> showAvailableFlights();
                case 2 -> bookFlight();
                case 3 -> cancelReservation();
                case 4 -> showAllReservations();
                case 5 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n🌟 Welcome to the Flight Reservation System! 🌟");
        System.out.println("1. Show Available Flights ✈️");
        System.out.println("2. Book a Flight 📃");
        System.out.println("3. Cancel a Reservation ❌");
        System.out.println("4. Show All Reservations 📄");
        System.out.println("5. Exit 🚪");
        System.out.print("Enter your choice: ");
    }

    private static void seedFlights() {
        flights.add(new Flight("AA123", "New York", "Los Angeles", 300.00, 50));
        flights.add(new Flight("DL456", "Chicago", "Miami", 250.00, 30));
        flights.add(new Flight("UA789", "San Francisco", "Seattle", 200.00, 20));
        flights.add(new Flight("SW101", "Boston", "Dallas", 350.00, 15));
    }

    private static void showAvailableFlights() {
        System.out.println("\n📋 Available Flights:");
        for (Flight flight : flights) {
            flight.displayFlightDetails();
        }
    }

    private static void bookFlight() {
        showAvailableFlights();
        System.out.print("\nEnter the flight number you want to book: ");
        String flightNumber = sc.nextLine();

        Flight selectedFlight = findFlight(flightNumber);

        if (selectedFlight != null) {
            if (selectedFlight.getSeatsAvailable() > 0) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                System.out.print("Enter your passport number: ");
                String passportNumber = sc.nextLine();
                System.out.print("Enter your email: ");
                String email = sc.nextLine();
                System.out.print("Enter your phone number: ");
                String phoneNumber = sc.nextLine();

                Passenger passenger = new Passenger(name, passportNumber, email, phoneNumber);
                String reservationNumber = generateReservationNumber();
                Reservation reservation = new Reservation(selectedFlight, passenger, reservationNumber);
                reservations.add(reservation);
                selectedFlight.bookSeat();

                System.out.println("✅ Booking successful! Your reservation number is: " + reservationNumber);
            } else {
                System.out.println("❌ Sorry, no seats available for this flight.");
            }
        } else {
            System.out.println("❌ Flight not found. Please try again.");
        }
    }

    private static void cancelReservation() {
        System.out.print("\nEnter your reservation number to cancel: ");
        String reservationNumber = sc.nextLine();

        Reservation reservation = findReservation(reservationNumber);

        if (reservation != null) {
            reservation.cancelReservation();
            reservations.remove(reservation);
            System.out.println("✅ Reservation canceled successfully.");
        } else {
            System.out.println("❌ Reservation not found. Please try again.");
        }
    }

    private static void showAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("\u001B[31mNo reservations found.\u001B[0m");
        } else {
            System.out.println("\n📋 All Reservations:");
            for (Reservation r : reservations) {
                r.displayReservationDetails();
            }
        }
    }

    private static Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    private static Reservation findReservation(String reservationNumber) {
        for (Reservation r : reservations) {
            if (r.getReservationNumber().equalsIgnoreCase(reservationNumber)) {
                return r;
            }
        }
        return null;
    }

    private static String generateReservationNumber() {
        return "RES" + (reservations.size() + 1);
    }
}
