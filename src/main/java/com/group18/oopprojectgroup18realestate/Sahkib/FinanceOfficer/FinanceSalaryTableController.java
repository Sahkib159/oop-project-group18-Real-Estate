package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class FinanceSalaryTableController
{
    @javafx.fxml.FXML
    private TableColumn<SalaryRecord, String> salaryCol;
    @javafx.fxml.FXML
    private TableView<SalaryRecord> tableView;
    @javafx.fxml.FXML
    private TableColumn<SalaryRecord, String> employeeCol;
    @javafx.fxml.FXML
    private Label totalLabel;

    // Temporary employee salary list
    private final ObservableList<SalaryRecord> salaryList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void calculateTotalOnClick(ActionEvent actionEvent) {
        double total = 0;

        for (SalaryRecord s : salaryList) {
            total += s.getSalary();
        }

        totalLabel.setText("Total: " + total + " BDT");
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