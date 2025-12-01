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

public class FinanceVendorPaymentController
{
    @javafx.fxml.FXML
    private TextField vendorIdTextField;
    @javafx.fxml.FXML
    private TextField amountTextField;

    // In-memory vendor payment list
    private ObservableList<VendorPayment> vendorPaymentList = FXCollections.observableArrayList();

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
    public void submitPaymentOnClick(ActionEvent actionEvent) {
        String vendorId = vendorIdTextField.getText();
        String amountStr = amountTextField.getText();

        // Validation
        if (vendorId.isEmpty() || amountStr.isEmpty()) {
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

        VendorPayment vp = new VendorPayment(vendorId, amount, LocalDate.now().toString());
        vendorPaymentList.add(vp);

        showAlert("Success", "Vendor payment recorded!");

        // Clear fields
        vendorIdTextField.clear();
        amountTextField.clear();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}