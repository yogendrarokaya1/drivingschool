/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Client.View.ChangePassword;
import Model.ChangePasswordModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Yogendra Rokaya
 */


public class ChangePasswordController {

    private final ChangePassword view;
    private final ChangePasswordModel model;

    public ChangePasswordController(ChangePassword view) {
        this.view = view;
        this.model = new ChangePasswordModel();
        initListeners();
    }

    private void initListeners() {
        view.getBtnChangePassword().addActionListener(e -> handleChangePassword());
        // Add other listeners if needed
    }

    private void handleChangePassword() {
        System.out.println("Change password button clicked"); // Debug line

        String email = view.getTxtChangeEmail().getText();
        String oldPassword = new String(view.getTxtOldPassword().getPassword());
        String newPassword = new String(view.getTxtNewPassword().getPassword());
        String confirmPassword = new String(view.getTxtConfirmPassword().getPassword());

        if (newPassword.equals(confirmPassword)) {
            System.out.println("Password change attempt with email: " + email); // Debug line
            boolean success = model.changePassword(email, oldPassword, newPassword);
            if (success) {
                JOptionPane.showMessageDialog(view, "Password changed successfully!");
                view.dispose(); // Close the view if needed
            } else {
                JOptionPane.showMessageDialog(view, "Failed to change password. Please check your details.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "New password and confirmation do not match.");
        }
    }
}
