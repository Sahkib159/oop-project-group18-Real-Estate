package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class FinanceTaxSummaryController
{
    @javafx.fxml.FXML
    private Label totalTaxLabel;

    // Sample payment data
    private final ObservableList<Payment> paymentList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void calculateTaxOnClick(ActionEvent actionEvent) {
        if (paymentList.isEmpty()) {
            showAlert("Error", "No payments available.");
            return;
        }

        double totalTax = 0;

        for (Payment p : paymentList) {
            totalTax += p.getAmount() * 0.05;   // 5% tax
        }

        totalTaxLabel.setText("Total Tax: " + totalTax + " BDT");
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}