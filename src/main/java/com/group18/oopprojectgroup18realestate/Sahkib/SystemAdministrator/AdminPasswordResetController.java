//package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;
//
//import com.group18.oopprojectgroup18realestate.User1;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//
//public class AdminPasswordResetController
//{
//    @javafx.fxml.FXML
//    private TableColumn<User1, String> usernameCol;
//    @javafx.fxml.FXML
//    private TextField newPasswordTextField;
//    @javafx.fxml.FXML
//    private TableColumn<User1, String> roleCol;
//    @javafx.fxml.FXML
//    private TableView <User1> TableView;
//
//    // In-memory user list
//    private final ObservableList<User1> userList = FXCollections.observableArrayList();
//
//    @javafx.fxml.FXML
//    public void initialize() {
//        // Table columns binding
//        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
//        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
//        tableView.setItems(userList);
//
//        // Sample data
//        userList.add(new User1("admin", "1234", "System Administrator"));
//        userList.add(new User1("finance01", "9999", "Finance Officer"));
//        userList.add(new User1("support01", "pass22", "Customer Support Executive"));
//    }
//
//    @javafx.fxml.FXML
//    public void resetPasswordOnClick(ActionEvent actionEvent) {
//        User1 selectedUser = tableView.getSelectionModel().getSelectedItem();
//        String newPassword = newPasswordTextField.getText();
//
//        if (selectedUser == null) {
//            showAlert("Error", "Please select a user from the table.");
//            return;
//        }
//
//        if (newPassword.isEmpty()) {
//            showAlert("Error", "Please enter a new password.");
//            return;
//        }
//
//        // Update password
//        selectedUser.setPassword(newPassword);
//
//        tableView.refresh();
//        newPasswordTextField.clear();
//
//        showAlert("Success", "Password updated for: " + selectedUser.getUsername());
//    }
//
//    @javafx.fxml.FXML
//    public void backOnClick(ActionEvent actionEvent) {
//        FXMLLoader fxmlLoader =
//                new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = (Stage) ((Node) actionEvent.getSource())
//                .getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
//    private void showAlert(String title, String msg) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(msg);
//        alert.showAndWait();
//    }
//}