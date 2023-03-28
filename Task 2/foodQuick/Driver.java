//Create a driver class with the following attributes:
public class Driver {

    private String driverName;
    private String driverLocation;
    private int workLoad;

    // Create a constructor
    // This method is used to initialize the attributes to
    // the values that we specify for each object

    public Driver(String driverName, String driverLocation, int workLoad) {
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.workLoad = workLoad;
    }

    // Implementing the applicable getters for the Driver class

    public String getDriverName() {
        return driverName;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public int getWorkLoad() {
        return workLoad;
    }
}
