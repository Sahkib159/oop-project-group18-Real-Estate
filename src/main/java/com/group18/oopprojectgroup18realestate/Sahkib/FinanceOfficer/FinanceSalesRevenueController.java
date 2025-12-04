package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import com.group18.oopprojectgroup18realestate.Payment;
import com.group18.oopprojectgroup18realestate.FinanceService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class FinanceSalesRevenueController {

    @FXML
    private TextArea revenueOutputTextArea;

    @FXML
    public void initialize() {

    }

    @FXML
    public void loadRevenueOnClick(ActionEvent event) {

        List<Payment> paymentList = FinanceService.loadPayments();

        if (paymentList.isEmpty()) {
            revenueOutputTextArea.setText("No revenue records found.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        double totalRevenue = 0;

        sb.append("===== Sales Revenue Report =====\n\n");

        for (Payment p : paymentList) {

            sb.append("Client ID: ").append(p.getClientId())
                    .append(" | Amount: ").append(p.getAmount())
                    .append(" | Date: ").append(p.getDate())
                    .append("\n");

            totalRevenue += p.getAmount();
        }

        sb.append("\n--------------------------------\n");
        sb.append("Total Payments: ").append(paymentList.size()).append("\n");
        sb.append("Total Revenue: ").append(totalRevenue).append(" BDT\n");
        sb.append("--------------------------------\n");

        revenueOutputTextArea.setText(sb.toString());
    }

    @FXML
    public void backOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    //Alart
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
