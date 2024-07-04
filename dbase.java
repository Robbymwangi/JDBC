import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbase {
    // Create a JDBC connector method
    public static Connection connect() {
        Connection conn = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establish the connection
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "1234";
            conn = DriverManager.getConnection(url, username, password);
            
            System.out.println("Connected to the database");
        } catch (ClassNotFoundException e) {
                } catch (SQLException e) {
                    System.out.println("Failed to connect to the database");
                }
                return conn;
            }
    public void readFromDatabase() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        conn = connect(); // Assuming connect() is the method you provided earlier
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * tblbooks"); // Replace with your table name

        while(rs.next()) {
            // Get data from the current row and display it
            System.out.println("Column1: " + rs.getString("column1")); // Replace with your column name
            // Repeat for other columns
        }
    } catch (SQLException e) {
        System.out.println("Failed to read from the database");
    } finally {
        // Close resources in reverse order of their creation
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) { /* ignored */}
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) { /* ignored */}
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) { /* ignored */}
        }
    }
}
    public static void main(String[] args) {
        dbase database = new dbase(); // Create an instance of the dbase class
        database.readFromDatabase(); // Call the readFromDatabase() method on the instance
    }
        }
