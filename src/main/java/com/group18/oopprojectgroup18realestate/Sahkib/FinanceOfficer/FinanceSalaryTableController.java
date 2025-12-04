package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import com.group18.oopprojectgroup18realestate.SalaryRecord;
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

public class FinanceSalaryTableController {

    @FXML
    private TextField employeeIdTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    public void initialize() {
        // nothing required here
    }

    @FXML
    public void recordSalaryOnClick(ActionEvent event) {

        String employeeId = employeeIdTextField.getText();
        String amountStr = amountTextField.getText();

        if (employeeId.isEmpty() || amountStr.isEmpty()) {
            showAlert("Error", "Please fill all fields.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (Exception e) {
            showAlert("Error", "Amount must be a valid number.");
            return;
        }

        SalaryRecord record = new SalaryRecord(employeeId, amount, LocalDate.now().toString());
        FinanceService.addSalary(record);

        showAlert("Success", "Salary record saved successfully.");

        employeeIdTextField.clear();
        amountTextField.clear();
    }

    @FXML
    public void backOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
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
