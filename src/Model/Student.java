/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Yogendra Rokaya
 */

public class Student {
    private static final Set<String> clientIds = new HashSet<>();
    private String clientId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String city;
    private String country;
    private String startDate;
    private String endDate;
    private String category;
    private String status;

    public Student(String clientId, String firstName, String lastName, String email, String phone, String dateOfBirth,  String city, String country, String startDate, String endDate, String category, String string11) {
//        synchronized (clientIds) {
//            if (clientIds.contains(clientId)) {
//                throw new IllegalArgumentException("Client ID must be unique");
//            }
//            clientIds.add(clientId);
//        }
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;        
        this.city = city;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.status = "active"; 
    }


    // Getters and setters for each field
    
     public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        synchronized (clientIds) {
            if (clientIds.contains(clientId)) {
                throw new IllegalArgumentException("Client ID must be unique");
            }
            clientIds.remove(this.clientId);
            this.clientId = clientId;
            clientIds.add(clientId);
        }
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

   


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

 
    
    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

