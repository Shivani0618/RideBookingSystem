// Entry Point of the Application (Controller Layer)
// This is a Ride-Sharing Console Application
// It allows users to:
// 1. Create ride listings using terminal input
// 2. Store ride data in memory (ArrayList)
// 3. Persist ride data into the database using DAO
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        // Counter used to access newly added ride from rideList
        int count =0;

        // Logic layer object (handles in-memory ride creation)
        CreateRideSystem rideBookingSystem = new CreateRideSystem();
//        rideBookingSystem.createRide("delhi","jaipur",5,3,700.00);
//        rideBookingSystem.createRide("lucknow" ,"kanpur",5,3,400.00);
//        Ride r1 = new Ride("delhi", "Kota", 4, 4, 450);
//        Ride r2 = new Ride("mumbai", "Kota", 4, 4, 450);
//        Ride r3 = new Ride("rajasthan", "Kota", 4, 4, 450);

        // DAO layer object (handles database operations)
        RideDB db = new RideDB();
//        db.createRide(r1);
//        db.createRide(r2);
//        db.createRide(r3);

        // creting switch case provide user the option while they need  to create ride or book the ride and one
        // user can create multipee ride

        // Scanner object to take user input from terminal
        Scanner sc = new Scanner(System.in);

        // Infinite loop to keep showing menu until user exits
        while(true){
            System.out.println("press 1 for create ride");
            System.out.println("press 2 for book ride");
            System.out.println("press any other key for exit\n");

            // Read user choice
            int option = sc.nextInt();
            // it is used to nextLine and read enter
            sc.nextLine();
            switch(option){
                case 1:
                        //create ride
                        System.out.println("Enter source location:");
                        String source = sc.nextLine();

                        System.out.println("Enter destination:");
                        String destination = sc.nextLine();

                        System.out.println("Enter total seats:");
                        int total_seats = sc.nextInt();

                        System.out.println("Seat available");
                        int available_seats = sc.nextInt();

                        System.out.println("Total fare");
                        int fare = sc.nextInt();

                    // Create ride in memory (ArrayList)
                        rideBookingSystem.createRide(
                                source,
                                destination,
                                total_seats,
                                available_seats,
                                fare);
                    // Save the newly created ride to database
                        db.createRide(rideBookingSystem.rideList.get(count));
                    // Increment counter for next ride
                        count+=1;

                        break;
                case 2:
                    //1. Show all available rides from DB
                    List<Ride> allRides = db.getAllRides();
                    if (allRides.isEmpty()) {
                        System.out.println("No rides available!");
                        break;
                    }

                    System.out.println("\n--- Available Rides ---");
                    for (int i = 0; i < allRides.size(); i++) {
                        System.out.println((i + 1) + ". " + allRides.get(i));
                    }

                    // 2. Let user pick a ride
                    System.out.println("\nEnter the number of the ride you want to book:");
                    int rideChoice = sc.nextInt();

                    if (rideChoice > 0 && rideChoice <= allRides.size()) {
                        Ride selectedRide = allRides.get(rideChoice - 1);

                        if (selectedRide.available_seats > 0) {
                            // 3. Logic: Reduce seat count
                            selectedRide.available_seats -= 1;
                            // 4. Update the DB
                            db.updateSeats(selectedRide.source, selectedRide.destination, selectedRide.available_seats);
                        } else {
                            System.out.println("Sorry, this ride is full!");
                        }
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;
                default:
                    // Exit the application
                    System.out.println("Exiting application...");
                    return;
            }
        }
    }
}






