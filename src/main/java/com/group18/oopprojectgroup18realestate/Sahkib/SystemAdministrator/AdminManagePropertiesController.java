package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminManagePropertiesController
{
    @javafx.fxml.FXML
    private TextField propertyLocationTextField;
    @javafx.fxml.FXML
    private TableColumn titleCol;
    @javafx.fxml.FXML
    private TableColumn idCol;
    @javafx.fxml.FXML
    private TextField propertyPriceTextField;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private TextField propertyTitleTextField;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TextField propertyIdTextField;
    @javafx.fxml.FXML
    private TableColumn priceCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void editPropertyOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void statusComboBox(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void deletePropertyOnClick(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void addPropertyOnClick(ActionEvent actionEvent) {
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