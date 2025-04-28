public class Flight {

    private String FlightNumber;
    private String origin;
    private String destination;
    private double price;
    private int seatsAvailable;


    public Flight(String flightNumber, String origin, String destination, double price, int seatsAvailable ){
        this.FlightNumber =flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.seatsAvailable = seatsAvailable;




    }

    public  String getFlightNumber(){
        return FlightNumber;
    }

    public String getOrigin(){
        return origin;
    }
    
    public String getDestination(){
        return destination;
    }

    public double getPrice(){
        return price;
    }
    
    public int getSeatsAvailable(){
        return seatsAvailable;
    }

    public  void bookSeat(){
        if(seatsAvailable > 0){
            seatsAvailable--;
        }
    }

    public void cancelSeat(){
        seatsAvailable++;
    
}

public void displayFlightDetails(){
    System.out.println("Flight Number: " + FlightNumber);
    System.out.println("Origin: " + origin);
    System.out.println("Destination: " + destination);
    System.out.println("Price: $" + price);
    System.out.println("Seats Available: " + seatsAvailable);
    System.out.println("------------------------------");
}

}