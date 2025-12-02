package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class FinanceSalesRevenueController
{
    @javafx.fxml.FXML
    private TextArea revenueOutputTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadRevenueOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}