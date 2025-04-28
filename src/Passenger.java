public class Passenger {

    private String name;
    private String passportNumber;
    private String email;
    private String phoneNumber;

    public Passenger(String name, String passportNumber, String email, String phoneNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}