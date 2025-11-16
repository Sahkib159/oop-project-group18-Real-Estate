package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PropertyStatusUpdatesController
{

    @javafx.fxml.FXML
    private TableColumn<bookings, String> phoneCol;
    @javafx.fxml.FXML
    private TableView<bookings> buyersTable;
    @javafx.fxml.FXML
    private TableColumn<bookings, String> emailCol;
    @javafx.fxml.FXML
    private TextArea writeMessageTF;
    @javafx.fxml.FXML
    private TableColumn<bookings, String> buyerNameCol;
    @javafx.fxml.FXML
    private ComboBox<bookings> selectPropertyCB;

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
    public void sendUpdateOA(ActionEvent actionEvent) {
    }
}