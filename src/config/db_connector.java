package config;

import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class db_connector implements AutoCloseable {
    private Connection conn;

    // Constructor - Establishes Database Connection
    public db_connector() {
        String url = "jdbc:mysql://localhost:3306/carrental";
        String user = "root";
        String password = "";

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Can't Connect to Database: " + e.getMessage());
        }
    }

    // Get the current connection
    public Connection getConnection() {
        return conn;
    }

    // Retrieve data without parameters
    public ResultSet getData(String sql) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql);
        return stmt.executeQuery();
    }

    // Retrieve data with parameters
    public ResultSet getDataWithParams(String sql, Object... params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
        return stmt.executeQuery();
    }

    // Insert data
    public int insertData(String sql, Object... values) {
        int result = 0;
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            for (int i = 0; i < values.length; i++) {
                pst.setObject(i + 1, values[i]);
            }
            result = pst.executeUpdate();
            System.out.println("Inserted Successfully!");
        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    // Update data
    public int updateData(String sql, Object... params) throws SQLException {
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            return pst.executeUpdate();
        }
    }

    // Check if a field exists
    public boolean fieldExists(String tableName, String fieldName, String value) throws SQLException {
        String sql = "SELECT 1 FROM " + tableName + " WHERE " + fieldName + " = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, value);
            try (ResultSet result = pstmt.executeQuery()) {
                return result.next();
            }
        }
    }

    // Check for duplicates excluding current ID
    public boolean duplicateCheckExcludingCurrent(String tableName, String columnName, String value, String idColumn, String idValue) {
        String sql = "SELECT 1 FROM " + tableName + " WHERE " + columnName + " = ? AND " + idColumn + " <> ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, value);
            pstmt.setString(2, idValue);
            try (ResultSet result = pstmt.executeQuery()) {
                return result.next();
            }
        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    // Secure login validation
    public String validateLogin(String username, String password) throws SQLException, NoSuchAlgorithmException {
        String query = "SELECT usertype, password FROM users WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");
                // Make sure passwordHasher.checkPassword is implemented elsewhere
                if (passwordHasher.checkPassword(password, storedHashedPassword)) {
                    return rs.getString("usertype");
                }
            }
        }
        return null;  // Login failed
    }

    // Close connection
    @Override
    public void close() {
        closeConnection();
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException ex) {
            System.out.println("Error closing connection: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // Retrieve data with a single String parameter
public ResultSet getData(String sql, String param) throws SQLException {
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, param);
    return stmt.executeQuery();
}

}
