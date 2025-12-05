package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class AdminIssueTrackerController {

    @FXML
    private TextArea issueDetailsTextArea;

    @FXML
    private TableView<Issue> tableView;

    @FXML
    private TableColumn<Issue, String> issueIdCol;

    @FXML
    private TableColumn<Issue, String> statusCol;

    private ObservableList<Issue> issueList;

    @FXML
    public void initialize() {

        // Bind Table Columns
        issueIdCol.setCellValueFactory(new PropertyValueFactory<>("issueId"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Load issues from file
        List<Issue> loadedIssues = IssueService.loadIssues();
        issueList = FXCollections.observableArrayList(loadedIssues);

        tableView.setItems(issueList);

        // Show issue details when selecting a row
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                issueDetailsTextArea.setText(newVal.getDetails());
            }
        });
    }

    @FXML
    public void markInProgressOnClick(ActionEvent actionEvent) {

        Issue selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Please select an issue.");
            return;
        }

        selected.setStatus("In Progress");
        saveChanges();
        tableView.refresh();

        LogService.addLog("Issue " + selected.getIssueId() + " marked In Progress.");
        showAlert("Success", "Issue marked as In Progress!");
    }

    @FXML
    public void markResolvedOnClick(ActionEvent actionEvent) {

        Issue selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Please select an issue.");
            return;
        }

        selected.setStatus("Resolved");
        saveChanges();
        tableView.refresh();

        LogService.addLog("Issue " + selected.getIssueId() + " resolved.");
        showAlert("Success", "Issue marked as Resolved!");
    }

    private void saveChanges() {
        IssueService.saveIssues(issueList);
    }

    @FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

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
