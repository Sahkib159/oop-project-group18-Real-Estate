package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.User1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AdminAssignRolesController {
    @javafx.fxml.FXML
    private TableColumn<User1, String> usernameCol;
    @javafx.fxml.FXML
    private TableView<User1> tableView;
    @javafx.fxml.FXML
    private TableColumn<User1, String> currentRoleCol;
    @javafx.fxml.FXML
    private ComboBox<String> newRoleComboBox;


    private ObservableList<User1> userList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        //TableView
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        currentRoleCol.setCellValueFactory(new PropertyValueFactory<>("currentRole"));

        //ComboBox
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
        //Sample Data
        userList.add(new User1("admin", "1234", "System Administrator"));
        userList.add(new User1("finance01", "9999", "Finance Officer"));
        userList.add(new User1("support01", "abcd", "Customer Support Executive"));
        

        tableView.setItems(userList);
    }

    @javafx.fxml.FXML
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

        // Update role
        selectedUser.setRole(newRole);
        tableView.refresh();

        showAlert("Success", "Role updated for user: " + selectedUser.getUsername());
    }





    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }



    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}