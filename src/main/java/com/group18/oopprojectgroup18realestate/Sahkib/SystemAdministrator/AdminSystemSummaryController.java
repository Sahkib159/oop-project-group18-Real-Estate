package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.UserService;
import com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator.PaymentService;
import com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator.PropertyService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminSystemSummaryController {

    @FXML
    private Label totalUsersLabel;
    @FXML
    private Label totalPaymentsLabel;
    @FXML
    private Label totalPropertiesLabel;
    @FXML
    private Label totalLogsLabel;

    @FXML
    public void initialize() {
        loadSummary();
    }

    @FXML
    public void refreshOnClick(ActionEvent actionEvent) {
        loadSummary();
    }

    private void loadSummary() {

        // REAL VALUES
        int totalUsers = UserService.loadUsers().size();
        int totalPayments = PaymentService.loadPayments().size();
        int totalProperties = PropertyService.loadProperties().size();
        int totalLogs = 0;  // CHANGE later if logs.bin exists

        totalUsersLabel.setText(String.valueOf(totalUsers));
        totalPaymentsLabel.setText(String.valueOf(totalPayments));
        totalPropertiesLabel.setText(String.valueOf(totalProperties));
        totalLogsLabel.setText(String.valueOf(totalLogs));
    }

    @FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
