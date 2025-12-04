package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.LogEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.CollationElementIterator;
import java.time.LocalDate;

public class AdminActivityReportController
{
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TextArea reportTextArea;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;

    // In-memory logs (sample data for now)
    private final ObservableList<LogEntry> logList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
//        // SAMPLE LOG DATA
//        logList.add(new LogEntry("2025-01-10", "User admin created a new Finance Officer."));
//        logList.add(new LogEntry("2025-01-12", "Property P102 marked as Rented."));
//        logList.add(new LogEntry("2025-01-15", "Payment C101 recorded."));
//        logList.add(new LogEntry("2025-02-01", "Issue ISS-104 marked as In Progress."));
//        logList.add(new LogEntry("2025-02-10", "Backup created."));
//        logList.add(new LogEntry("2025-02-14", "User finance01 password reset."));


        logList.setAll(LogService.loadLogs());


    }





    @javafx.fxml.FXML
    public void generateReportOnClick(ActionEvent actionEvent) {
        LocalDate start = startDatePicker.getValue();
        LocalDate end = endDatePicker.getValue();

        if (start == null || end == null) {
            showAlert("Error", "Please select both start and end date.");
            return;
        }

        if (end.isBefore(start)) {
            showAlert("Error", "End date cannot be before start date.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== Activity Report ===\n");
        sb.append("From: ").append(start).append("\n");
        sb.append("To: ").append(end).append("\n\n");

        int count = 0;

        // Filter logs
        for (LogEntry log : logList) {
            LocalDate logDate = LocalDate.parse(log.getDate());

            if (!logDate.isBefore(start) && !logDate.isAfter(end)) {
                sb.append(log.getDate())
                        .append(" → ")
                        .append(log.getMessage())
                        .append("\n");
                count++;
            }
        }

        if (count == 0) {
            reportTextArea.setText("No activity found for the selected date range.");
        } else {
            sb.append("\nTotal Activities: ").append(count);
            reportTextArea.setText(sb.toString());
        }
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}