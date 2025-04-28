public class Reservation {

    private Flight flight;
    private Passenger passenger;
    private String reservationNumber;
    private boolean isCancelled;

    public Reservation(Flight flight, Passenger passenger, String reservationNumber) {
        this.flight = flight;
        this.passenger = passenger;
        this.reservationNumber = reservationNumber;
        this.isCancelled = false;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void cancelReservation() {
        if (!isCancelled) {
            flight.cancelSeat();
            isCancelled = true;
            System.out.println("Reservation " + reservationNumber + " has been cancelled.");
        } else {
            System.out.println("Reservation " + reservationNumber + " is already cancelled.");
        }
    }

    public void displayReservationDetails() {
        System.out.println("=== Reservation Details ===");
        System.out.println("Reservation Number: " + reservationNumber);
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Passport: " + passenger.getPassportNumber());
        System.out.println("Passenger Email: " + passenger.getEmail());
        System.out.println("Passenger Phone: " + passenger.getPhoneNumber());
        System.out.println("Flight Number: " + flight.getFlightNumber());
        System.out.println("Flight Status: " + (isCancelled ? "Cancelled ❌" : "Active ✅"));
        System.out.println("============================\n");
    }
}
