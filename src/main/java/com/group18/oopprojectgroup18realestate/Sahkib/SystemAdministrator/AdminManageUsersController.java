package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.User1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AdminManageUsersController
{
    @javafx.fxml.FXML
    private TableColumn<User1, String> usernameCol;
    @javafx.fxml.FXML
    private TableView<User1> tableView;
    @javafx.fxml.FXML
    private TableColumn<User1, String> roleCol;
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField usernameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> roleComboBox;

    //Temporary user List
    private final ArrayList<User1> userList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        //TableView
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));

        //ComboBox
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

        //Sample data
        userList.add(new User1("admin", "1234", "System Administrator"));
        userList.add(new User1("finance01", "9999", "Finance Officer"));
        userList.add(new User1("marketing01", "1234", "Marketing Officer"));
        userList.add(new User1("customers01", "1234", "Customer Support Executive"));
        userList.add(new User1("property01", "1234", "Property Renter"));
        userList.add(new User1("property02", "1234", "Property Manager"));
        userList.add(new User1("property03", "1234", "Property Buyer"));
        userList.add(new User1("sales01", "1234", "Sales Agent"));

        tableView.setItems(FXCollections.observableList(userList));

    }

    @javafx.fxml.FXML
    public void editUserOnClick(ActionEvent actionEvent) {

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

        tableView.refresh();
        clearFields();

        showAlert("Success", "User updated!");
    }

    @javafx.fxml.FXML
    public void deleteUserOnClick(ActionEvent actionEvent) {
        User1 selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a user to delete!");
            return;
        }

        userList.remove(selected);
        tableView.refresh();

        showAlert("Success", "User deleted!");
    }





    @javafx.fxml.FXML
    public void addUserOnClick(ActionEvent actionEvent) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String role = roleComboBox.getValue();

        //prevent errors
        if (username.isEmpty() || password.isEmpty() || role == null) {
            showAlert("Error", "Please fill all fields");
            return;
        }

        // prevent duplicates
        for (User1 u : userList) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                showAlert("Error", "Username already exists!");
                return;
            }
        }

        userList.add(new User1(username, password, role));
        tableView.refresh();
        clearFields();

        showAlert("Success", "User added!");
    }




    private void clearFields() {
        usernameTextField.clear();
        passwordTextField.clear();
        roleComboBox.getSelectionModel().clearSelection();
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