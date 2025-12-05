package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class tenantPaymentsController
{
    @javafx.fxml.FXML
    private TableColumn<PaymentData, String> methodCol;
    @javafx.fxml.FXML
    private Label outputMessage;
    @javafx.fxml.FXML
    private TableColumn<PaymentData, Double> amountCOl;
    @javafx.fxml.FXML
    private TableColumn<PaymentData, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<PaymentData, String>  statusCol;
    @javafx.fxml.FXML
    private TableColumn<PaymentData, String> paymentIDCol;
    @javafx.fxml.FXML
    private TextField propertyidtextfiled;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableView<PaymentData>  paymenthistoryTV;
    @javafx.fxml.FXML
    private ComboBox<String>  paymentmethodCB;

    private ArrayList<PaymentData> paymentList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        paymentmethodCB.getItems().addAll("Cash", "bKash", "Nagad", "Bank Transfer", "Card");


        paymentIDCol.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        amountCOl.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        methodCol.setCellValueFactory(new PropertyValueFactory<>("method"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadOC(null);
    }


    @javafx.fxml.FXML
    public void backbuttonONClick(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void payOnClickButton(ActionEvent actionEvent) {
        String propertyID = propertyidtextfiled.getText().strip();
        String amountText = amountTF.getText().strip();
        String method = paymentmethodCB.getValue();

        // Validation
        if (propertyID.isEmpty() || amountText.isEmpty() || method == null) {
            outputMessage.setText("Please fill all fields!");
            return;
        }

        // Amount validation
        double amount;
        try {
            amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                outputMessage.setText("Amount should be positive!");
                return;
            }
        } catch (NumberFormatException e) {
            outputMessage.setText("Invalid amount!");
            return;
        }


       // PaymentData payment = new PaymentData();

        //paymentList.add(payment);


        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("payments.bin"))) {
            out.writeObject(paymentList);
            outputMessage.setText("Payment successful!");


            paymenthistoryTV.getItems().clear();
            paymenthistoryTV.getItems().addAll(paymentList);


            propertyidtextfiled.clear();
            amountTF.clear();
        } catch (IOException e) {
            outputMessage.setText("Payment failed!");
        }
    }


    @javafx.fxml.FXML
    public void loadOC(ActionEvent actionEvent)  {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("payments.bin"))) {
            paymentList = (ArrayList<PaymentData>) in.readObject();

            paymenthistoryTV.getItems().clear();
            for (PaymentData p : paymentList) {
                paymenthistoryTV.getItems().add(p);
            }
            outputMessage.setText("Loaded");
        } catch (FileNotFoundException e) {
            outputMessage.setText("No payment history found!");
        } catch (Exception e) {
            outputMessage.setText("Error!");
        }
    }
}