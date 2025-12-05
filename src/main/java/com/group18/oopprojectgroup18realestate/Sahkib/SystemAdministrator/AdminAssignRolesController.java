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
import java.util.List;

public class AdminAssignRolesController {

    @FXML
    private TableView<User1> tableView;

    @FXML
    private TableColumn<User1, String> usernameCol;

    @FXML
    private TableColumn<User1, String> currentRoleCol;

    @FXML
    private ComboBox<String> newRoleComboBox;

    private ObservableList<User1> userList;

    @FXML
    public void initialize() {

        // Setup columns
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        currentRoleCol.setCellValueFactory(new PropertyValueFactory<>("role"));

        // ComboBox
        newRoleComboBox.getItems().addAll(
                "System Administrator",
                "Finance Officer",
                "Marketing Officer",
                "Customer Support Executive",
                "Property Renter",
                "Property Manager",
                "Property Buyer",
                "Sales Agent"
        );

        // Old sample data
        /*
        userList.add(new User1("admin", "1234", "System Administrator"));
        userList.add(new User1("finance01", "9999", "Finance Officer"));
        userList.add(new User1("support01", "abcd", "Customer Support Executive"));
        tableView.setItems(userList);
        */

        // NEW: Load from users.bin
        List<User1> loadedUsers = UserService.loadUsers();
        userList = FXCollections.observableArrayList(loadedUsers);
        tableView.setItems(userList);
    }

    @FXML
    public void updateRoleOnClick(ActionEvent actionEvent) {

        User1 selectedUser = tableView.getSelectionModel().getSelectedItem();

        if (selectedUser == null) {
            showAlert("Error", "Please select a user.");
            return;
        }

        String newRole = newRoleComboBox.getValue();

        if (newRole == null) {
            showAlert("Error", "Please choose a role.");
            return;
        }

        // Update role in memory
        selectedUser.setRole(newRole);

        // Refresh table
        tableView.refresh();

        // SAVE UPDATED USER LIST TO users.bin
        UserService.saveUsers(userList);

        showAlert("Success", "Role updated for " + selectedUser.getUsername());
///I added it later to addLog into logs.bin
        LogService.addLog("Role changed for " + selectedUser.getUsername() + " to " + newRole);

    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setTitle(title);
        a.setContentText(msg);
        a.showAndWait();
    }

    @FXML
    public void backOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
