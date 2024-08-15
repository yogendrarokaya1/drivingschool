/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Yogendra Rokaya
 */



import Model.Student;
import Model.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentController {
    
    private Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse(dateString);
        return new Date(parsed.getTime());
    }

    private String determineStatus(Date endDate) {
        Date currentDate = new Date(System.currentTimeMillis());
        return endDate.before(currentDate) ? "inactive" : "active";
    }

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (client_id, first_name, last_name, email, phone, date_of_birth, city, country, start_date, end_date, category, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
             
            pstmt.setString(1, student.getClientId());
            pstmt.setString(2, student.getFirstName());
            pstmt.setString(3, student.getLastName());
            pstmt.setString(4, student.getEmail());
            pstmt.setString(5, student.getPhone());
            pstmt.setDate(6, convertStringToDate(student.getDateOfBirth()));
            pstmt.setString(7, student.getCity());
            pstmt.setString(8, student.getCountry());
            pstmt.setDate(9, convertStringToDate(student.getStartDate()));
            pstmt.setDate(10, convertStringToDate(student.getEndDate()));
            pstmt.setString(11, student.getCategory());
            pstmt.setString(12, determineStatus(convertStringToDate(student.getEndDate())));

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(String clientId) {
        String query = "DELETE FROM students WHERE client_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setString(1, clientId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET first_name = ?, last_name = ?, email = ?, phone = ?, date_of_birth = ?, city = ?, country = ?, start_date = ?, end_date = ?, category = ?, status = ? WHERE client_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getPhone());
            pstmt.setDate(5, convertStringToDate(student.getDateOfBirth()));
            pstmt.setString(6, student.getCity());
            pstmt.setString(7, student.getCountry());
            pstmt.setDate(8, convertStringToDate(student.getStartDate()));
            pstmt.setDate(9, convertStringToDate(student.getEndDate()));
            pstmt.setString(10, student.getCategory());
            pstmt.setString(11, determineStatus(convertStringToDate(student.getEndDate())));
            pstmt.setString(12, student.getClientId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
