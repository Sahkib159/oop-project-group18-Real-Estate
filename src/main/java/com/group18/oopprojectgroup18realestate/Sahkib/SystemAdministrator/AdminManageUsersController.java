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

public class AdminManageUsersController {

    @FXML
    private TableView<User1> tableView;

    @FXML
    private TableColumn<User1, String> usernameCol;

    @FXML
    private TableColumn<User1, String> roleCol;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private ComboBox<String> roleComboBox;


    // OLD temporary list
    // private final ArrayList<User1> userList = new ArrayList<>();


    // NEW list connected with file handling
    private ObservableList<User1> userList;


    @FXML
    public void initialize() {

        // Setup Table Columns
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));


        // Role ComboBox
        roleComboBox.getItems().addAll(
                "System Administrator",
                "Finance Officer",
                "Marketing Officer",
                "Customer Support Executive",
                "Property Renter",
                "Property Manager",
                "Property Buyer",
                "Sales Agent"
        );

        // OLD sample data
        /*
        userList.add(new User1("admin", "1234", "System Administrator"));
        userList.add(new User1("finance01", "9999", "Finance Officer"));
        userList.add(new User1("marketing01", "1234", "Marketing Officer"));
        userList.add(new User1("customers01", "1234", "Customer Support Executive"));
        userList.add(new User1("property01", "1234", "Property Renter"));
        userList.add(new User1("property02", "1234", "Property Manager"));
        userList.add(new User1("property03", "1234", "Property Buyer"));
        userList.add(new User1("sales01", "1234", "Sales Agent"));
        tableView.setItems(FXCollections.observableList(userList));
        */

        //NEW: LOAD users from users.bin
        loadUsersIntoTable();

    }


    // Load all users from file into TableView
    private void loadUsersIntoTable() {
        // loads from users.bin
        List<User1> saved = UserService.loadUsers();
        userList = FXCollections.observableArrayList(saved);
        tableView.setItems(userList);
    }



    // ADD USER (now saves into users.bin)
    @FXML
    public void addUserOnClick(ActionEvent event) {

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String role = roleComboBox.getValue();

        if (username.isEmpty() || password.isEmpty() || role == null) {
            showAlert("Error", "Please fill all fields");
            return;
        }

        // Check duplicates
        for (User1 u : userList) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                showAlert("Error", "Username already exists!");
                return;
            }
        }

        User1 newUser = new User1(username, password, role);

        userList.add(newUser);
        // SAVE to file
        UserService.saveUsers(userList);

        tableView.refresh();
        clearFields();

        showAlert("Success", "User added!");

        //I added it later to addLog into logs.bin
        LogService.addLog("User " + username + " created with role " + role + ".");

    }



    // EDIT USER (updates users.bin)
    @FXML
    public void editUserOnClick(ActionEvent event) {

        User1 selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a user to edit!");
            return;
        }

        String newUsername = usernameTextField.getText();
        String newPassword = passwordTextField.getText();
        String newRole = roleComboBox.getValue();

        if (newUsername.isEmpty() || newPassword.isEmpty() || newRole == null) {
            showAlert("Error", "Fill all fields");
            return;
        }

        selected.setUsername(newUsername);
        selected.setPassword(newPassword);
        selected.setRole(newRole);
        // SAVE changes
        UserService.saveUsers(userList);
        tableView.refresh();
        clearFields();

        showAlert("Success", "User updated!");

        //I added it later to ediLog into logs.bin
        LogService.addLog("User " + selected.getUsername() + " updated.");

    }



    // DELETE USER (updates users.bin)
    @FXML
    public void deleteUserOnClick(ActionEvent event) {

        User1 selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a user to delete!");
            return;
        }

        userList.remove(selected);
        // SAVE updated list
        UserService.saveUsers(userList);
        tableView.refresh();

        showAlert("Success", "User deleted!");

        //I added it later to ediLog into logs.bin
        LogService.addLog("User " + selected.getUsername() + " deleted.");

    }


    // Helpers
    private void clearFields() {
        usernameTextField.clear();
        passwordTextField.clear();
        roleComboBox.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setTitle(title);
        a.setContentText(msg);
        a.showAndWait();
    }


    // BACK BUTTON
    @FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
