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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class StudentRecordModel {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:mysql://localhost:3306/driving_db"; // Update with your database URL
        String user = "root"; // Update with your database username
        String password = "M@yogesh4165"; // Update with your database password
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public DefaultTableModel getAllStudents() {
        String[] columnNames = {"Client ID", "First Name", "Last Name", "Email", "Phone", "Date of Birth", "City", "Country", "Start Date", "End Date", "Category", "status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        String sql = "SELECT * FROM students";
        
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String clientId = rs.getString("client_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String dob = rs.getString("date_of_birth");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String category = rs.getString("category");
                String status = rs.getString("status");
                Object[] row = {clientId, firstName, lastName, email, phone, dob, city, country, startDate, endDate, category, status};
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return model;
    }

    // New method to search for students by phone number
    public DefaultTableModel getStudentsByPhone(String phone) {
        String[] columnNames = {"Client ID", "First Name", "Last Name", "Email", "Phone", "Date of Birth", "City", "Country", "Start Date", "End Date", "Category", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        String sql = "SELECT * FROM students WHERE phone = '" + phone + "'";
        
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String clientId = rs.getString("client_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String dob = rs.getString("date_of_birth");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String category = rs.getString("category");
                String status = rs.getString("status");
                Object[] row = {clientId, firstName, lastName, email, phone, dob, city, country, startDate, endDate, category, status};
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return model;
    }
}
