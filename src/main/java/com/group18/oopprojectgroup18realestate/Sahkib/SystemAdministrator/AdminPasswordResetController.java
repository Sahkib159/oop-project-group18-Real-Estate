package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.User1;
import com.group18.oopprojectgroup18realestate.UserService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminPasswordResetController {

    @FXML
    private TableView<User1> tableView;

    @FXML
    private TableColumn<User1, String> usernameCol;

    @FXML
    private TableColumn<User1, String> roleCol;

    @FXML
    private TextField newPasswordTextField;

    private ObservableList<User1> userList;

    @FXML
    public void initialize() {

        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));

        List<User1> loadedUsers = UserService.loadUsers();
        userList = FXCollections.observableArrayList(loadedUsers);

        tableView.setItems(userList);
    }

    @FXML
    public void resetPasswordOnClick(ActionEvent event) {

        User1 selectedUser = tableView.getSelectionModel().getSelectedItem();
        String newPassword = newPasswordTextField.getText();

        if (selectedUser == null) {
            showAlert("Error", "Please select a user from the table.");
            return;
        }

        if (newPassword.isEmpty()) {
            showAlert("Error", "Please enter a new password.");
            return;
        }

        // Update password
        selectedUser.setPassword(newPassword);

        // Save fix → convert ObservableList → ArrayList
        UserService.saveUsers(new ArrayList<>(userList));

        tableView.refresh();
        newPasswordTextField.clear();

        showAlert("Success", "Password updated for user: " + selectedUser.getUsername());

        try {
            LogService.addLog("Password reset for user: " + selectedUser.getUsername());
        } catch (Exception e) {
            System.out.println("LogService error: " + e.getMessage());
        }
    }

    @FXML
    public void backOnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
