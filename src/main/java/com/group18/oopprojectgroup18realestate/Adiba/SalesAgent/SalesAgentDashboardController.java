package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SalesAgentDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logoutOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewFeedbackOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("ViewFeedback.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();

    }

    @javafx.fxml.FXML
    public void schedulePropertyVisitOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SchedulePropertyVisit.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @javafx.fxml.FXML
    public void updatePropertyDetailsOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdatePropertyDetails.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @javafx.fxml.FXML
    public void addPropertyOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProperty.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @javafx.fxml.FXML
    public void manageBookingsOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageBookings.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @javafx.fxml.FXML
    public void viewBuyerInquiriesOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewBuyerInquiries.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @javafx.fxml.FXML
    public void propertyStatusUpdatesOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PropertyStatusUpdates.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @javafx.fxml.FXML
    public void recordPaymentOA(ActionEvent actionEvent) throws  IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RecordPayment.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent) {
    }
}