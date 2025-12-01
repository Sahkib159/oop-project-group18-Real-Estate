package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminIssueTrackerController
{
    @javafx.fxml.FXML
    private TextArea issueDetailsTextArea;
    @javafx.fxml.FXML
    private TableColumn<Issue, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Issue, String> issueIdCol;
    @javafx.fxml.FXML
    private TableView<Issue> tableView;



    // In-memory temporary issue list
    private final ObservableList<Issue> issueList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {

        // Bind table columns
        issueIdCol.setCellValueFactory(new PropertyValueFactory<>("issueId"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableView.setItems(issueList);

        // TEMPORARY DATA (remove later)
        issueList.add(new Issue("IS101", "Open", "Customer reports login error."));
        issueList.add(new Issue("IS102", "In Progress", "Payment record mismatch detected."));
        issueList.add(new Issue("IS103", "Open", "Property image upload not working."));
    }

    @javafx.fxml.FXML
    public void markInProgressOnClick(ActionEvent actionEvent) {
        Issue selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Please select an issue.");
            return;
        }

        selected.setStatus("In Progress");
        tableView.refresh();

        showAlert("Success", "Issue marked as In Progress!");
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void markResolvedOnClick(ActionEvent actionEvent) {
        Issue selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Please select an issue.");
            return;
        }

        selected.setStatus("Resolved");
        tableView.refresh();

        showAlert("Success", "Issue marked as Resolved!");
    }
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}