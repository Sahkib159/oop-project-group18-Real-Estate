package com.group18.oopprojectgroup18realestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CreateAccountController {

    @FXML
    private TextField newUsernameTextField;

    @FXML
    private TextField newPasswordTextField;

    @FXML
    private ComboBox<String> newRoleComboBox;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        newRoleComboBox.getItems().addAll(
                "System Administrator",
                "Finance Officer",
                "Marketing Officer",
                "Customer Support Executive",
                "Property Renter",
                "Property Manager",
                "Property buyer",
                "Sales Agent"
        );
    }

    @FXML
    public void createNewAccountOnClick(ActionEvent event) throws IOException {

        String username = newUsernameTextField.getText();
        String password = newPasswordTextField.getText();
        String role = newRoleComboBox.getValue();

        if (username.isEmpty() || password.isEmpty() || role == null) {
            statusLabel.setText("Please fill all fields!");
            return;
        }
        //Loads existing users from users.bin
        List<User1> users = UserService.loadUsers();

        // Check for duplicate username
        for (User1 u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                statusLabel.setText("Username already exists!");
                return;
            }
        }

        // Create new user
        User1 newUser = new User1(username, password, role);

        // Save to users.bin
        UserService.addUser(newUser);

        statusLabel.setText("Account created successfully!");

        // Switch to login page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/group18/oopprojectgroup18realestate/LogIn.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void returnOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/group18/oopprojectgroup18realestate/LogIn.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void RoleComboBoxOnClick(ActionEvent event) {

    }
}
