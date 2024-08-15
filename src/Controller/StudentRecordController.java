/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Yogendra Rokaya
 */


import Model.StudentRecordModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentRecordController {
    private final StudentRecordModel model;

    public StudentRecordController() {
        this.model = new StudentRecordModel();
    }

    public void populateStudentTable(JTable table) {
        DefaultTableModel tableModel = model.getAllStudents();
        table.setModel(tableModel);
    }

    public void searchStudentByPhone(String phone, JTable table) {
        DefaultTableModel tableModel = model.getStudentsByPhone(phone);
        table.setModel(tableModel);
    }
}
