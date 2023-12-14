package web.website.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DATABASE_NAME = "java";
    private static final String JDBC_URL = "jdbc:mysql://192.168.48.133:3306/" + DATABASE_NAME + "?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "@GbmTm321456#";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to establish a database connection.");
        }
    }
}
