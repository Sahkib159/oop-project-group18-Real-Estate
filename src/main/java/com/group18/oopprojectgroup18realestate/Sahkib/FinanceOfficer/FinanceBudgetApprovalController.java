package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class FinanceBudgetApprovalController {
    @javafx.fxml.FXML
    private TableColumn<BudgetRecord, String> departmentCol;
    @javafx.fxml.FXML
    private TableColumn<BudgetRecord, String> amountCol;
    @javafx.fxml.FXML
    private TableColumn<BudgetRecord, String> statusCol;
    @javafx.fxml.FXML
    private TableView<BudgetRecord> tableView;
    @javafx.fxml.FXML
    private ComboBox<String> decisionComboBox;

    // In-memory budget list
    private final ObservableList<BudgetRecord> budgetList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Bind columns
        departmentCol.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().getDepartment()
                )
        );

        amountCol.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        String.valueOf(cell.getValue().getAmount())
                )
        );

        statusCol.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().getStatus()
                )
        );

        // Add choices
        decisionComboBox.getItems().addAll("Approve", "Reject");

        // Sample data
        budgetList.add(new BudgetRecord("Marketing", 150000, "Pending"));
        budgetList.add(new BudgetRecord("Maintenance", 90000, "Pending"));
        budgetList.add(new BudgetRecord("IT Department", 120000, "Pending"));
        budgetList.add(new BudgetRecord("Security", 60000, "Pending"));

        tableView.setItems(budgetList);
    }

    @javafx.fxml.FXML
    public void confirmDecisionOnClick(ActionEvent actionEvent) {
        BudgetRecord selected = tableView.getSelectionModel().getSelectedItem();
        String decision = decisionComboBox.getValue();

        if (selected == null) {
            showAlert("Error", "Please select a budget request.");
            return;
        }

        if (decision == null) {
            showAlert("Error", "Please choose Approve or Reject.");
            return;
        }

        selected.setStatus(decision);
        tableView.refresh();

        showAlert("Success",
                "Budget request for '" + selected.getDepartment() +
                        "' updated to: " + decision);
    }


    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
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