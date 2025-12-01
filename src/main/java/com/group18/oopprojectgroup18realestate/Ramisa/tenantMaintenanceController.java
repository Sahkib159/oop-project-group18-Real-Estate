package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    }

    @javafx.fxml.FXML
    public void submitOnClickButton(ActionEvent actionEvent) {
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