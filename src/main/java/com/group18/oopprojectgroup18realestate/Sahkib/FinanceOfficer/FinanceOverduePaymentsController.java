package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FinanceOverduePaymentsController
{
    @javafx.fxml.FXML
    private TableColumn<Payment, String > clientCol;
    @javafx.fxml.FXML
    private TableColumn<Payment, String> amountCol;
    @javafx.fxml.FXML
    private TableColumn<Payment, String> dateCol;
    @javafx.fxml.FXML
    private TableView<Payment> tableView;

    // Sample payment list
    private final ObservableList<Payment> paymentList = FXCollections.observableArrayList();

    // Overdue result list
    private final ObservableList<Payment> overdueList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {



        // Bind columns
        clientCol.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getClientId())
        );

        amountCol.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getAmount()))
        );

        dateCol.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDate())
        );

        // Add sample data
        paymentList.add(new Payment("C101", 50000, "2025-01-01"));
        paymentList.add(new Payment("C102", 30000, "2024-12-10"));
        paymentList.add(new Payment("C103", 25000, "2025-02-01"));
        paymentList.add(new Payment("C104", 45000, "2024-11-20"));
        paymentList.add(new Payment("C105", 60000, "2025-01-25"));
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
    public void loadOverdueOnClick(ActionEvent actionEvent) {
        overdueList.clear();
        LocalDate today = LocalDate.now();

        for (Payment p : paymentList) {

            LocalDate date = LocalDate.parse(p.getDate());
            long daysOld = ChronoUnit.DAYS.between(date, today);

            // Overdue if older than 30 days
            if (daysOld > 30) {
                overdueList.add(p);
            }
        }

        if (overdueList.isEmpty()) {
            showAlert("Info", "No overdue payments found.");
        }

        tableView.setItems(overdueList);
    }
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }


}