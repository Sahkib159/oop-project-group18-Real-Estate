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

public class ViewBuyerInquiriesController
{
    @javafx.fxml.FXML
    private TextField typeResponseTF;
    @javafx.fxml.FXML
    private TextField inquiryMessageTF;
    @javafx.fxml.FXML
    private TableColumn<Inquiries, String> messageCol;
    @javafx.fxml.FXML
    private TableView<Inquiries> inquiryTable;
    @javafx.fxml.FXML
    private TableColumn<Inquiries, String> inquiryIdCol;
    @javafx.fxml.FXML
    private TableColumn<Inquiries, String> buyerNameCol;
    @javafx.fxml.FXML
    private TableColumn<Inquiries, String> propertyIdCol;

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