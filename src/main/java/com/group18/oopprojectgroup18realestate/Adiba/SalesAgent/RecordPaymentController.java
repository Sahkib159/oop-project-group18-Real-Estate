package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RecordPaymentController
{
    @javafx.fxml.FXML
    private TextField propertyIdTF;
    @javafx.fxml.FXML
    private TextArea updatedBalanceTF;
    @javafx.fxml.FXML
    private TextField buyerNameTF;
    @javafx.fxml.FXML
    private TextField installmentAmountTF;
    @javafx.fxml.FXML
    private TextField bookingAmountTF;
    @javafx.fxml.FXML
    private TextField paymentMethodTF;
    @javafx.fxml.FXML
    private TextField remainingBalanceTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void confirmPaymentOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SalesAgentDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }
}