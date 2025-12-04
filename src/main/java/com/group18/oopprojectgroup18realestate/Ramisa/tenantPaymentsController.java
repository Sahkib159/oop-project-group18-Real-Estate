package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private ComboBox<String> paymentmethodCB;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,String> statusCol;
    @javafx.fxml.FXML
    private TextField propertyidtextfiled;

    @javafx.fxml.FXML
    public void initialize() {

        //combobox
        paymentmethodCB.getItems().addAll("cash","card","bank transfer","Bkash");

        paymentIDCol.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        amountCOl.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        methodCol.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("Status"));

        //table
        paymenthistoryTV.getItems().clear();
        paymenthistoryTV.getItems().addAll();
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
        outputMessage.setText("paymenthistory downlaod");
        /// download code implement
    }

    @javafx.fxml.FXML
    public void payOnClickButton(ActionEvent actionEvent) {
        String propertyIDText = propertyidtextfiled.getText().strip();
        String amountText = amountTF.getText().strip();
        String method = paymentmethodCB.getValue();

            // Validation
        if (propertyIDText.isEmpty() || amountText.isEmpty() || method == null) {
            outputMessage.setText("Please fillup !");
            return;
        }


        int propertyID;
        double amount;

        try {
            propertyID = Integer.parseInt(propertyIDText);
            amount = Double.parseDouble(amountText);
            } catch (Exception e) {
            outputMessage.setText("Invalid property ID or amount!");
            return;
        }


        }
    }


