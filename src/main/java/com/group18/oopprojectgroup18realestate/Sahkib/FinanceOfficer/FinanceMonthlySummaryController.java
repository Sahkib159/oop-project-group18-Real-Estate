package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import com.group18.oopprojectgroup18realestate.Payment;
import com.group18.oopprojectgroup18realestate.FinanceService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FinanceMonthlySummaryController {

    @FXML
    private ComboBox<String> monthComboBox;

    @FXML
    private ComboBox<String> yearComboBox;

    @FXML
    private TextArea summaryOutputTextArea;


    @FXML
    public void initialize() {

        // Month list
        monthComboBox.getItems().addAll(
                "01","02","03","04","05","06",
                "07","08","09","10","11","12"
        );

        // Year list
        yearComboBox.getItems().addAll("2024", "2025", "2026");
    }


    @FXML
    public void loadSummaryOnClick(ActionEvent event) {

        String month = monthComboBox.getValue();
        String year  = yearComboBox.getValue();

        if (month == null || year == null) {
            showAlert("Error", "Please select both Month and Year.");
            return;
        }

        List<Payment> paymentList = FinanceService.loadPayments();

        if (paymentList.isEmpty()) {
            summaryOutputTextArea.setText("No payments recorded.");
            return;
        }

        double totalAmount = 0;
        int count = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("==== Monthly Summary ====\n");
        sb.append("Month: ").append(month).append("/").append(year).append("\n\n");

        for (Payment p : paymentList) {

            LocalDate date = LocalDate.parse(p.getDate());

            if (date.getMonthValue() == Integer.parseInt(month)
                    && date.getYear() == Integer.parseInt(year)) {

                sb.append("Client ID: ").append(p.getClientId())
                        .append(" | Amount: ").append(p.getAmount())
                        .append(" | Date: ").append(p.getDate())
                        .append("\n");

                totalAmount += p.getAmount();
                count++;
            }
        }

        if (count == 0) {
            summaryOutputTextArea.setText("No payments found for " + month + "/" + year);
            return;
        }

        sb.append("\n-------------------------------\n");
        sb.append("Total Payments: ").append(count).append("\n");
        sb.append("Total Revenue : ").append(totalAmount).append(" BDT\n");
        sb.append("-------------------------------");

        summaryOutputTextArea.setText(sb.toString());
    }


    @FXML
    public void backOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //alert
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}