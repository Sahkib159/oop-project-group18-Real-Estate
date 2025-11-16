package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFeedbackController
{
    @javafx.fxml.FXML
    private TableColumn<respondFeedback, String> feedbackCol;
    @javafx.fxml.FXML
    private TextField selectedFeedbackTF;
    @javafx.fxml.FXML
    private TextField enterResponseTF;
    @javafx.fxml.FXML
    private TableColumn<respondFeedback, String> feedbackIdCol;
    @javafx.fxml.FXML
    private TableColumn<respondFeedback, String> buyerNameCol;
    @javafx.fxml.FXML
    private TableView<respondFeedback> feedbackTable;
    @javafx.fxml.FXML
    private TableColumn<respondFeedback, String> propertyIdCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveResponseOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SalesAgentDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }
}