package com.group18.oopprojectgroup18realestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccountController
{
    @javafx.fxml.FXML
    private TextField newUsernameTextField;
    @javafx.fxml.FXML
    private TextField newPasswordTextField;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> newRoleComboBox;

    @javafx.fxml.FXML
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


    @javafx.fxml.FXML
    public void returnOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/group18/oopprojectgroup18realestate/LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void createNewAccountOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/group18/oopprojectgroup18realestate/LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}