package OOP2;

public class CustomerTest {
    public static void main(String[] args) {
        Address homeAddress = new Address("Kerla","Kannur",670582);
        Customer customer = new Customer("Anu",homeAddress);
        Address workAddress = new Address("Kerala","Kaloor",682017);
        customer.setWorkAddress(workAddress);
        System.out.println(customer);
    }
}
