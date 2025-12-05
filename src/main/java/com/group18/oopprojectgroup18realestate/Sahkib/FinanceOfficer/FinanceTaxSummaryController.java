package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import com.group18.oopprojectgroup18realestate.Payment;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class FinanceTaxSummaryController {

    @javafx.fxml.FXML
    private Label totalTaxLabel;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void calculateTaxOnClick(ActionEvent actionEvent) {

        // Load payments from payments.bin
        List<Payment> payments = FinanceService.loadPayments();

        if (payments.isEmpty()) {
            showAlert("Error", "No payments available.");
            totalTaxLabel.setText("Total Tax: 0 BDT");
            return;
        }

        double totalTax = 0;

        // 5% tax on each payment
        for (Payment p : payments) {
            totalTax += p.getAmount() * 0.05;
        }

        totalTaxLabel.setText("Total Tax: " + totalTax + " BDT");
    }


    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
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
