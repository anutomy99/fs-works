package OOP2;

public class Address {
    private String state;
    private String city;
    private long pincode;

    public Address(String state, String city, long pincode) {
        this.state = state;
        this.city = city;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
