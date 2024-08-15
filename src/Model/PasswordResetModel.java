/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Yogendra Rokaya
 */






import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.DatabaseConnection; // Adjust import based on your actual DB connection class

public class PasswordResetModel {

    private final Connection connection;

    public PasswordResetModel() {
        connection = DatabaseConnection.getConnection(); // Assuming DatabaseConnection provides a method to get a DB connection
    }

    public boolean changePassword(String email, String newPassword) {
        String query = "UPDATE users SET password = ? WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newPassword); // Set the new password
            stmt.setString(2, email);       // Set the email

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Return true if the update was successful
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error changing password: " + e.getMessage());
            return false;
        }
    }
}
