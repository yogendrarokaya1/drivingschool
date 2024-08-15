/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;




import Model.PersonalDetailModel;
import Model.Student;
import Client.View.PersonalDetail;

public class PersonalDetailController {
    private final PersonalDetail view;
    private final PersonalDetailModel model;

    public PersonalDetailController(PersonalDetail view) {
        this.view = view;
        this.model = new PersonalDetailModel(); // Initialize model
    }

    public void loadStudentDetails(String clientId) {
        try {
            Student student = model.getStudentById(clientId);
            if (student != null) {
                view.setStudentDetails(student);
            } else {
                System.out.println("Student with clientId " + clientId + " not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading student details");
        }
    }
    
}
