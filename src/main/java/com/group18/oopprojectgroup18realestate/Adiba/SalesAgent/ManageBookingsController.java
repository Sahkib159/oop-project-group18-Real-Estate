package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageBookingsController
{
    @javafx.fxml.FXML
    private TableColumn<addProperty, String> bookingIdCol;
    @javafx.fxml.FXML
    private TableColumn<addProperty, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<addProperty, String> buyerNameCol;
    @javafx.fxml.FXML
    private ComboBox<String> updateStatusCB;
    @javafx.fxml.FXML
    private TableView<addProperty> bookingsTable;
    @javafx.fxml.FXML
    private TableColumn<addProperty, String> propertyIdCol;
    @javafx.fxml.FXML
    private Label outputLabel;

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
    public void updateOA(ActionEvent actionEvent) {
    }
}