// Logic (Service) Layer
// This class contains the business logic for creating and managing rides.
// It stores rides temporarily in memory using an ArrayList.

import java.util.ArrayList;
import java.util.List;

public class CreateRideSystem{
    // List to store all rides created during runtime
    // This data is lost when the application stops
    public List<Ride> rideList = new ArrayList<>();
    public void createRide(String source, String destination, int total_seats, int avaliable_seats, double fare){
        // Create a Ride object using provided details
        Ride ride = new Ride(source,destination, total_seats,avaliable_seats,fare);
        // Add the ride to the in-memory list
        rideList.add(ride);
    }
    // Returns the list of all created rides

    public List<Ride> showAllRide() {
        return rideList;
    }



}
