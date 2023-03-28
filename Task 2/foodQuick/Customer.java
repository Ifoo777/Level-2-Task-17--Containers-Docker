//Create a customer class with the following attributes
public class Customer {

    private String customerName;
    private String customerContactDetails;
    private String customerAddress;
    private String customerLocation;
    private String customerEmailAddress;

    // Create a constructor
    // This method is used to initialize the attributes to
    // the values that we specify for each object

    public Customer(String customerName, String customerContactDetails, String customerAddress, String customerLocation,
            String customerEmailAddress) {

        this.customerName = customerName;
        this.customerContactDetails = customerContactDetails;
        this.customerAddress = customerAddress;
        this.customerLocation = customerLocation;
        this.customerEmailAddress = customerEmailAddress;
    }

    // Implementing the applicable getters for the Customer Class

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerContactDetails() {
        return customerContactDetails;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

}
