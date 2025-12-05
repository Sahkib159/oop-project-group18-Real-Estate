package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class SchedulePropertyVisitController
{
    @javafx.fxml.FXML
    private TableColumn<scheduleVisit, String> timeslotCol;
    @javafx.fxml.FXML
    private TableView<scheduleVisit> visitTable;
    @javafx.fxml.FXML
    private TableColumn<scheduleVisit, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<scheduleVisit, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<scheduleVisit, String> buyerCol;
    @javafx.fxml.FXML
    private DatePicker selectDateDP;
    @javafx.fxml.FXML
    private TableColumn<scheduleVisit, String> propertyIdCol;
    @javafx.fxml.FXML
    private ComboBox<String> timeslotCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void cancelVisitOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SalesAgentDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @javafx.fxml.FXML
    public void loadVisitsOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void scheduleVisitOA(ActionEvent actionEvent) {
    }
}