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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonalDetailModel {

    private Connection connect() {
        // Connect to your database here
        String url = "jdbc:mysql://localhost:3306/driving_db";
        String user = "root";
        String password = "M@yogesh4165";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Student getStudentById(String clientId) {
        String query = "SELECT * FROM students WHERE client_id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connect();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, clientId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                // Calculate the status based on end_date
                LocalDate endDate = rs.getDate("end_date").toLocalDate();
                LocalDate currentDate = LocalDate.now();
                String status = endDate.isBefore(currentDate) ? "inactive" : "active";

                return new Student(
                    rs.getString("client_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("date_of_birth"),
                    rs.getString("city"),
                    rs.getString("country"),
                    rs.getString("start_date"),
                    rs.getString("end_date"),
                    rs.getString("category"),
                    status // Set the calculated status
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
