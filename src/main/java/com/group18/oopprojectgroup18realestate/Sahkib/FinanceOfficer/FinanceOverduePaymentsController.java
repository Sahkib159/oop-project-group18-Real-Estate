package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import com.group18.oopprojectgroup18realestate.Payment;
import com.group18.oopprojectgroup18realestate.FinanceService;
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
import java.util.List;

public class FinanceOverduePaymentsController {

    @javafx.fxml.FXML
    private TableColumn<Payment, String > clientCol;

    @javafx.fxml.FXML
    private TableColumn<Payment, String> amountCol;

    @javafx.fxml.FXML
    private TableColumn<Payment, String> dateCol;

    @javafx.fxml.FXML
    private TableView<Payment> tableView;


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
    }


    @javafx.fxml.FXML
    public void loadOverdueOnClick(ActionEvent event) {

        overdueList.clear();

        // Load all payments from payments.bin
        List<Payment> allPayments = FinanceService.loadPayments();

        LocalDate today = LocalDate.now();

        for (Payment p : allPayments) {

            LocalDate paymentDate = LocalDate.parse(p.getDate());
            long daysOld = ChronoUnit.DAYS.between(paymentDate, today);

            // If payment older than 30 days → overdue
            if (daysOld > 30) {
                overdueList.add(p);
            }
        }

        if (overdueList.isEmpty()) {
            showAlert("Info", "No overdue payments found.");
        }

        tableView.setItems(overdueList);
    }


    @javafx.fxml.FXML
    public void backOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
