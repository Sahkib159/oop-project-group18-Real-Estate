package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdatePropertyDetailsController
{
    @javafx.fxml.FXML
    private TableColumn<propertyDetails, String> addressCol;
    @javafx.fxml.FXML
    private TableColumn<propertyDetails, String> availabilityCol;
    @javafx.fxml.FXML
    private TableView<propertyDetails> propertyDetailsTable;
    @javafx.fxml.FXML
    private TextField updateDescriptionTF;
    @javafx.fxml.FXML
    private TextField updatePriceTF;
    @javafx.fxml.FXML
    private ComboBox<String> availabilityStatusCB;
    @javafx.fxml.FXML
    private TableColumn<propertyDetails, Double> priceCol;
    @javafx.fxml.FXML
    private TableColumn<propertyDetails, String> propertyIdCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SalesAgentDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @javafx.fxml.FXML
    public void updateDetailsOA(ActionEvent actionEvent) {
    }
}