package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer.SalaryRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class FinanceSalaryTableController {

    @FXML
    private TextField employeeIdTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private TableView<SalaryRecord> tableView;

    @FXML
    private TableColumn<SalaryRecord, String> employeeCol;

    @FXML
    private TableColumn<SalaryRecord, String> salaryCol;

    @FXML
    private Label totalLabel;

    private ObservableList<SalaryRecord> salaryList;

    @FXML
    public void initialize() {

        // Load saved salaries
        salaryList = FXCollections.observableArrayList(FinanceService.loadSalaries());
        tableView.setItems(salaryList);

        // Bind table columns
        employeeCol.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
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
        // Save to file
        FinanceService.addSalary(record);
        // Add to table
        salaryList.add(record);
        tableView.refresh();

        showAlert("Success", "Salary record saved successfully.");

        employeeIdTextField.clear();
        amountTextField.clear();
    }


    @FXML
    public void calculateTotalOnClick(ActionEvent event) {

        double total = 0;

        for (SalaryRecord s : FinanceService.loadSalaries()) {
            total += s.getAmount();
        }

        totalLabel.setText("Total: " + total + " BDT");
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
