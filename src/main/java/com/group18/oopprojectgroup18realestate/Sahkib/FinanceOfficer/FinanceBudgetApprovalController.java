package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer.BudgetRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

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

    private ObservableList<BudgetRecord> budgetList;

    @javafx.fxml.FXML
    public void initialize() {

        // Bind columns
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // ComboBox options
        decisionComboBox.getItems().addAll("Approved", "Rejected");

        // Load budgets from file
        List<BudgetRecord> loadedBudgets = FinanceService.loadBudgets();
        budgetList = FXCollections.observableArrayList(loadedBudgets);

        tableView.setItems(budgetList);
    }

    @javafx.fxml.FXML
    public void confirmDecisionOnClick(ActionEvent event) {

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

        // Update budget status
        selected.setStatus(decision);
        tableView.refresh();

        // Save updated list back to file
        FinanceService.saveBudgets(budgetList);

        showAlert("Success",
                "Budget request for '" + selected.getDepartment() +
                        "' updated to: " + decision);
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
