package M5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static void main(String[] args) {

        // Replace these values with your actual PostgreSQL credentials
        String url = "jdbc:postgresql://localhost:5432/training_db";
        String username = "hzjuy";      // your PostgreSQL username
        String password = "";      // your PostgreSQL password

        try {
            // Try to connect
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully!");

            // Close the connection (good practice)
            conn.close();

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            System.out.println(e.getMessage());
        }
    }
}
