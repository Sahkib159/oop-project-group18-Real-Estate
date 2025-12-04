package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import com.group18.oopprojectgroup18realestate.Payment;
import com.group18.oopprojectgroup18realestate.FinanceService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class FinanceRecordPaymentController {

    @FXML
    private TextField clientIdTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    public void initialize() {

    }

    @FXML
    public void backOnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void savePaymentOnClick(ActionEvent event) {

        String clientId = clientIdTextField.getText();
        String amountStr = amountTextField.getText();

        // Validation
        if (clientId.isEmpty() || amountStr.isEmpty()) {
            showAlert("Error", "Please fill all fields.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (Exception e) {
            showAlert("Error", "Amount must be a number.");
            return;
        }

        // Create Payment object
        Payment payment = new Payment(clientId, amount, LocalDate.now().toString());

        // Save into payments.bin using FinanceService
        FinanceService.addPayment(payment);

        showAlert("Success", "Payment recorded successfully!");

        // Clear fields
        clientIdTextField.clear();
        amountTextField.clear();
    }


    //Alert
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
