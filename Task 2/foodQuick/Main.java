import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    //Create an ArrayList for drivers

    static ArrayList<Driver> drivers = new ArrayList<Driver>();

  
    public static void getDrivers() {

        // Read the text file to pull out driver infomation 

        File driverInformation = new File("./src/driver-info.txt");
        System.out.println(driverInformation.getAbsolutePath());

        // Create scanner object with the specific filename name to read data through driver
        // information given from the source file drivers.txt

        try {
            Scanner scanner = new Scanner(driverInformation);

            while (scanner.hasNextLine()) {

                String[] driverData = scanner.nextLine().split(", ");
                String driverName = driverData[0].trim();
                String driverLocation = driverData[1].trim();

                // If workLoad is equal to 0 take in no data from driver information given

                if (driverData.length == 2) {

                    Driver driver = new Driver(driverName, driverLocation, 0);
                    drivers.add(driver);

                } else 

                // else create a new driver instance that takes in the driver infomation we also
                // parse
                 // in an integer to convert the string to a number
                {
                    Driver driver = new Driver(driverName, driverLocation, Integer.parseInt(driverData[2].trim()));
                    drivers.add(driver);
                }
            }
            //Close the scanner function

            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println(e);
        }
    }

    // Create a method to check for nearest driver and create an array list for
    // workload

    public static String checkNeareastDriver(Customer customer) {

        ArrayList<Integer> workLoadCheck = new ArrayList<Integer>();

        // Iterate through the driver array to check if the driver and customer location
        // match and add a given workload to the driver object

        for (int i = 0; i < drivers.size(); i++) {

            if (drivers.get(i).getDriverLocation().equals(customer.getCustomerLocation())) {

                workLoadCheck.add(drivers.get(i).getWorkLoad());
            }
        }

        // create a variable for the minimum workload

        int minimumWorkload = workLoadCheck.stream().min(Integer::compare).get();

        // iterate through the array find the driver with the smallest load in the
        // customer location

        for (int i = 0; i < drivers.size(); i++) {
            
            if (drivers.get(i).getWorkLoad() == minimumWorkload
                    && customer.getCustomerLocation().equals(drivers.get(i).getDriverLocation())) {
                
                        return (drivers.get(i).getDriverName());
            }
        }
        return "";

    }

    // Create the instance of the customer and restaurant object
    public static void main(String[] args) throws FileNotFoundException {
        getDrivers();

        //Add a image icon to the user prompt dialog box

        ImageIcon icon = new ImageIcon("src/images/imageQuickFood.png");

        // Prompt - Add Customer Name 

        String addCustomerName = (String) JOptionPane.showInputDialog(null, "Name and Surname?",
                "QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, null, "Name Surname");

        // Prompt - Add Customer Contact Number 

        String addCustomerContactNumber = (String) JOptionPane.showInputDialog(null,
                "Please supply a contact number?", "Food QUICK DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon,
                null, "+27 ");

        // Prompt - Add Customer Street address 

        String addStreetAddressOfCustomer = (String) JOptionPane.showInputDialog(null,
                "Address: \nDelivery house number and Street name?", "FOOD QUICK DELIVERIES",
                JOptionPane.QUESTION_MESSAGE, icon, null, "House number - Street name");

        // Prompt - Add Customer Suburb address 

        String addSuburbAddressOfCustomer = (String) JOptionPane.showInputDialog(null,
                "Where is your location?", "FOOD QUICK DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, null,
                null);

        // Prompt - Add Customer email

        String addEmailCustomer = (String) JOptionPane.showInputDialog(null, "What it your email address?",
                "FOOD QUICK DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, null, "example@gmail.com");

        // Prompt - Add Restaurant Name

        String addRestaurantName = (String) JOptionPane.showInputDialog(null, "Name of Restaurant?",
                "FOOD QUICK DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, null, "Nme of Restaurant");

        // Prompt - Add Restaurant Location

        String restaurantLocation = (String) JOptionPane.showInputDialog(null,
                "Restaurant Location", "FOOD QUICK DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon,
                null, "Location ");

        // Prompt - Restaurant contact details

        String restaurantContactDetails = (String) JOptionPane.showInputDialog(null,
                "Address: \nDelivery house number and Street name?", "FOOD QUICK DELIVERIES",
                JOptionPane.QUESTION_MESSAGE, icon, null, "restaurant Contact details");

        Customer addNewCustomer = new Customer(addCustomerName, addCustomerContactNumber, addStreetAddressOfCustomer,
                addSuburbAddressOfCustomer, addEmailCustomer);

        Restaurant addNewRestaurant = new Restaurant(addRestaurantName, restaurantLocation, restaurantContactDetails);

        // Print out Customer output details to string
        System.out.println("Customer name is: " + addCustomerName);
        System.out.println("Customer contact number: " + addCustomerContactNumber);
        System.out.println("Street address: " + addStreetAddressOfCustomer);
        System.out.println("Suburb of customer: " + addSuburbAddressOfCustomer);
        System.out.println("Email address: " + addEmailCustomer);
        
        // Print out Restaurant output details to string

        System.out.println("Restaurant name: " + addRestaurantName);
        System.out.println("Restaurant Location: " + restaurantLocation);
        System.out.println("Restaurant Contact Details: " + restaurantContactDetails);

        boolean driverLocationCheck = drivers.stream()
                .anyMatch(driver -> driver.getDriverLocation().equals(addNewCustomer.getCustomerLocation()));

        // Generate an invoice text file If the customer lives in a location that does
        // not match a
        // driver’s location, the invoice only needs to say:

        try {

            FileWriter generateInvoice = new FileWriter("./src/invoiceDetails.txt");
            if (!driverLocationCheck) {
                generateInvoice
                        .write("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
                generateInvoice.close();
            } 
            
            else {

                String driverName = checkNeareastDriver(addNewCustomer);
                generateInvoice
                        .write("Invoice will be generated and your driver will be. " + driverName);
                generateInvoice.close();
            }

        } catch (IOException e) {
            
            System.out.println(e);
        }
    }
}
