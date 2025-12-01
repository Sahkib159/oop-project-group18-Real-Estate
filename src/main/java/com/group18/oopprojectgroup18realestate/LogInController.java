package com.group18.oopprojectgroup18realestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController
{
    @javafx.fxml.FXML
    private TextField usernameField;
    @javafx.fxml.FXML
    private TextField passwordField;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private ComboBox<String> roleComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        roleComboBox.getItems().addAll("System Administrator", "Finance Officer","Marketing Officer","Customer Support Executive","Property Renter","Property Manager", "Property buyer","Sales Agent");
    }

    @javafx.fxml.FXML
    public void logInOnClick(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void createAccountOnClick(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create_account.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}