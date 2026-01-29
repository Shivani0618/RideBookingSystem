// Data Access Object (DAO) Layer
// This class is responsible for performing database operations
// related to the Ride entity (INSERT, UPDATE, DELETE, SELECT).
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RideDB {
//    Inserts a Ride object into the database

    public void createRide(Ride ride) {
        String sql = "INSERT INTO ride(source, destination, total_seats, available_seats, fare) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ride.source);
            ps.setString(2, ride.destination);
            ps.setInt(3, ride.total_seats);
            ps.setInt(4, ride.available_seats);
            ps.setDouble(5, ride.fare);

            // Execute INSERT query
            ps.executeUpdate();
            System.out.println(" Ride saved to database!");

        } catch (Exception e) {
            // Print error details if insertion fails
            e.printStackTrace();
        }
    }
    // Fetch all rides from MySQL
    public List<Ride> getAllRides() {
        List<Ride> rides = new ArrayList<>();
        String sql = "SELECT * FROM ride";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ride ride = new Ride(
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getInt("total_seats"),
                        rs.getInt("available_seats"),
                        rs.getDouble("fare")
                );
                rides.add(ride);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rides;
    }
    // Update seats after booking
    public void updateSeats(String source, String destination, int newSeats) {
        String sql = "UPDATE ride SET available_seats = ? WHERE source = ? AND destination = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, newSeats);
            ps.setString(2, source);
            ps.setString(3, destination);
            ps.executeUpdate();
            System.out.println("Booking confirmed! Seats updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
