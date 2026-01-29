// make normal app like bla bla
// Ride class represents a single ride in the application
public class Ride {
    String source;   //starting location
    String destination;    //destination location
    int total_seats;    //total seats available
    int available_seats;    //seats available
    double fare;    //fare per seat
    User created_by;    //user who offered this ride

    public Ride(String source, String destination, int total_seats, int available_seats, double fare) {
        // Assign constructor parameters to class variables
        this.source = source;
        this.destination = destination;
        this.total_seats = total_seats;
        this.available_seats = available_seats;
        this.fare = fare;

    }
    /**
     * Converts the Ride object into a readable string format
     * This method is automatically called when we print the object
     */
    public String toString() {
        return "Ride{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", total_seats=" + total_seats +
                ", avaliable_seats=" + available_seats +
                ", fare=₹" + fare +
                ", created_by=" + (created_by != null ? created_by.name : "null") +
                '}';

    }

}
