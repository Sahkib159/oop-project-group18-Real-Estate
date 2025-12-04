package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    // In-memory payments (sample data)
    private ObservableList<Payment> paymentList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadRevenueOnClick(ActionEvent actionEvent) {
        if (paymentList.isEmpty()) {
            revenueOutputTextArea.setText("No revenue records found.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        double totalRevenue = 0;

        sb.append("==== Sales Revenue Report ====\n\n");

        for (Payment p : paymentList) {
            sb.append("Client: ").append(p.getClientId())
                    .append(" | Amount: ").append(p.getAmount())
                    .append(" | Date: ").append(p.getDate())
                    .append("\n");

            totalRevenue += p.getAmount();
        }

        sb.append("\n-----------------------------\n");
        sb.append("Total Revenue: ").append(totalRevenue).append(" BDT\n");
        sb.append("Total Payments: ").append(paymentList.size()).append("\n");
        sb.append("-----------------------------\n");

        revenueOutputTextArea.setText(sb.toString());
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