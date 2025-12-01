package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class tenantPaymentsController
{
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,String> methodCol;
    @javafx.fxml.FXML
    private Label outputMessage;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Double> amountCOl;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Double> paymentIDCol;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableView<RentPaymentRelated> paymenthistoryTV;
    @javafx.fxml.FXML
    private ComboBox<Double> paymentmethodCB;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,String> statusCol;
    @javafx.fxml.FXML
    private TextField propertyidtextfiled;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backbuttonONClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void downloadHistoryOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void payOnClickButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void filterOC(ActionEvent actionEvent) {
    }
}