package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class FinanceRecordPaymentController
{
    @javafx.fxml.FXML
    private TextField clientIdTextField;
    @javafx.fxml.FXML
    private TextField amountTextField;

    // In-memory list of payments
    private ObservableList<Payment> paymentList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void savePaymentOnClick(ActionEvent actionEvent) {
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

        // Create payment object
        Payment payment = new Payment(clientId, amount, LocalDate.now().toString());
        paymentList.add(payment);

        showAlert("Success", "Payment recorded successfully!");

        // Clear fields
        clientIdTextField.clear();
        amountTextField.clear();

    }
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}