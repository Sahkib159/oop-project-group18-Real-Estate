package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class
SearchPropertiesController
{
    @javafx.fxml.FXML
    private TableColumn<Property, String> locationCol;
    @javafx.fxml.FXML
    private TableColumn<Property, Double> sizeCol;
    @javafx.fxml.FXML
    private TableColumn<Property, String> typeCol;
    @javafx.fxml.FXML
    private TextField locationTF;
    @javafx.fxml.FXML
    private ComboBox<String> typeCB;
    @javafx.fxml.FXML
    private TextField propertyInfoTF;
    @javafx.fxml.FXML
    private TableColumn<Property, String> nameCol;
    @javafx.fxml.FXML
    private TableView<Property> availablePropertiesTable;
    @javafx.fxml.FXML
    private TextField sizeTF;
    @javafx.fxml.FXML
    private TableColumn<Property, Double> priceCol;
    @javafx.fxml.FXML
    private TextField priceTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void selectThePropertyOA(ActionEvent actionEvent) {
    }



    @javafx.fxml.FXML
    public void searchOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void savedPropertiesOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SavedProperties.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PropertyBuyerDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }
}