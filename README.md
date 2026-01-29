# RideBookingSystem 🚗

A console-based Java application for managing and booking rides, integrated with a PostgreSQL database for persistent storage.

## 🌟 Features
- **Create Rides:** Users can offer rides by entering source, destination, seats, and fare.
- **Real-time Booking:** View available rides and book seats.
- **Database Persistence:** All ride data is saved in a PostgreSQL database, ensuring data isn't lost when the app closes.
- **Seat Management:** Automatically updates and tracks available seats.

## 🛠️ Tech Stack
| Component | Technology |
| :--- | :--- |
| **Language** | Java (JDK 23) |
| **Database** | PostgreSQL |
| **Driver** | JDBC (Postgres Connector) |
| **IDE** | IntelliJ IDEA |

## 📂 Project Structure
- `Main.java`: The entry point with the user menu loop.
- `Ride.java`: The data model for ride objects.
- `User.java`: The data model for user profiles.
- `RideDB.java`: DAO (Data Access Object) handling all SQL queries.
- `DBConnection.java`: Manages the connection to the PostgreSQL server.
- `CreateRideSystem.java`: Manages in-memory logic for rides.

## 🚀 Setup Instructions

### 1. Database Setup
Create the `ride_booking` database and table in your PostgreSQL terminal:

```sql
CREATE DATABASE ride_booking;

\c ride_booking

CREATE TABLE ride (
    id SERIAL PRIMARY KEY,
    source VARCHAR(255),
    destination VARCHAR(255),
    total_seats INT,
    available_seats INT,
    fare DOUBLE PRECISION,
    created_by VARCHAR(255)
);

```
### 2. Database Credentials
Before running the application, you must update the `DBConnection.java` file with your local PostgreSQL credentials:

* **URL:** `jdbc:postgresql://localhost:5432/ride_booking`
* **User:** `your_username` (Replace with your PostgreSQL username)
* **Password:** `your_password` (Replace with your PostgreSQL password)

### 3. Dependencies
To allow Java to communicate with PostgreSQL, you must include the JDBC driver in your project:

* **Driver:** `postgresql-42.7.8.jar`
* **Installation:**  
  1. Download the JAR from the [PostgreSQL JDBC site](https://jdbc.postgresql.org/download/).
  2.  In IntelliJ, go to **File > Project Structure > Libraries**.
     3.  Click the **+** icon and select the downloaded `.jar` file.
     4.  Click **Apply** and **OK**.

