//Create a restaurant class with the following attributes
public class Restaurant {

    public String restaurantName;
    public String restaurantLocation;
    public String restaurantContactDetails;

    // Create a constructor
    // This method is used to initialize the attributes to
    // the values that we specify for each object
    public Restaurant(String restaurantName, String restaurantLocation, String restaurantContactDetails) {
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.restaurantContactDetails = restaurantLocation;
    }
    // Implementing the applicable getters for this class

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public String getRestaurantContactDetails() {
        return restaurantContactDetails;
    }
}
