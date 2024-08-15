/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Yogendra Rokaya
 */




import Client.View.ResetPassword;
import Model.PasswordResetModel;
import javax.swing.JOptionPane;

public class ResetPasswordController {

    private final ResetPassword view;
    private final PasswordResetModel model;

    public ResetPasswordController(ResetPassword view) {
        this.view = view;
        this.model = new PasswordResetModel();
        initListeners();
    }

    private void initListeners() {
        view.getBtnChangePassword().addActionListener(e -> handleChangePassword());
    }

    private void handleChangePassword() {
        String email = view.getTxtChangeEmail().getText();
        String newPassword = new String(view.getTxtNewPassword().getPassword());
        String confirmPassword = new String(view.getTxtConfirmPassword().getPassword());

        if (newPassword.equals(confirmPassword)) {
            boolean success = model.changePassword(email, newPassword);
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
