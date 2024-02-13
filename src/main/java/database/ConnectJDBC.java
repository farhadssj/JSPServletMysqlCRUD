package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/expense_db";
    private String username = "root";
    private String password = "bjit1234";

    Connection connection;

    private static final String TAG = ConnectJDBC.class.getSimpleName();

    public ConnectJDBC() {
        connect();
    }

     public void connect() {
         try {
             // Register JDBC driver
             Class.forName("com.mysql.cj.jdbc.Driver");
             // Open a connection
             connection = DriverManager.getConnection(jdbcUrl, username, password);
             System.out.println(TAG + ">>Connected to the database successfully");
         } catch (SQLException | ClassNotFoundException e) {
             System.out.println(TAG + ">>Failed to connect database");
             e.printStackTrace();
             throw new RuntimeException(e);
         } finally {
         }
     }

    public Connection getConnection() {
        return connection;
    }
}
