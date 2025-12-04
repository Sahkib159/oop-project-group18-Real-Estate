package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class tenantMaintenanceController
{
    @javafx.fxml.FXML
    private TextArea issueTA;
    @javafx.fxml.FXML
    private Label outputmessgaelabel;
    @javafx.fxml.FXML
    private TableView<MaintenanceRequest> maintenanceTableview;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,Integer> MIDCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,String> IssuesCol;
    @javafx.fxml.FXML
    private Label selectedIssueIndetailsLabel;
    @javafx.fxml.FXML
    private TextArea managersNoteTA;
    @javafx.fxml.FXML
    private TextField propertyidTF;

    @javafx.fxml.FXML
    public void initialize() {

        // table columns
        MIDCol.setCellValueFactory(new PropertyValueFactory<>("requestID"));
        IssuesCol.setCellValueFactory(new PropertyValueFactory<>("issue"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Show in table
        maintenanceTableview.getItems().clear();
        maintenanceTableview.getItems().addAll();
    }

    @javafx.fxml.FXML
    public void submitOnClickButton(ActionEvent actionEvent) {

        String issue = issueTA.getText().trim();

        // Validation
        if (issue.isEmpty()) {
            outputmessgaelabel.setText("Please describe the issue!");
            return;
        }
    }

    @javafx.fxml.FXML
    public void backbuttonOnClick(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}