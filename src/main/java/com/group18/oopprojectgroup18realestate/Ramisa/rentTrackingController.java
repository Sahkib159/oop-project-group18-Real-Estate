package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class rentTrackingController
{
    @javafx.fxml.FXML
    private ComboBox<Integer> YearCB;
    @javafx.fxml.FXML
    private TableView<RentPaymentRelated> rentTrackTableview;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Double> paidCol;
    @javafx.fxml.FXML
    private Label pendingrentL;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Integer> tenantCOl;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Double> rentamountCol;
    @javafx.fxml.FXML
    private ComboBox<String> monthCB;
    @javafx.fxml.FXML
    private Label totalexpectedL;
    @javafx.fxml.FXML
    private Label messageL;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Double> pendingCol;
    @javafx.fxml.FXML
    private Label collectrentL;

    private ArrayList<RentPaymentRelated> RentpaymentList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        monthCB.getItems().addAll("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");

        for (int year = 2020; year <= 2026; year++) {
            YearCB.getItems().add(year);}

        idCol.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        tenantCOl.setCellValueFactory(new PropertyValueFactory<>("tenantID"));
        rentamountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paidCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        LoadOC(null);
    }

    @javafx.fxml.FXML
    public void LoadOC(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("payments.bin"))) {
            RentpaymentList = (ArrayList<RentPaymentRelated>) in.readObject();

            rentTrackTableview.getItems().clear();
            for (RentPaymentRelated p : RentpaymentList) {
                rentTrackTableview.getItems().add(p);
            }
            messageL.setText("Loaded  payment records!");

            double totalCollected = 0;
            double totalExpected = 0;

            for (RentPaymentRelated p : RentpaymentList) {
                totalExpected += p.getAmount(); // Total expected

                if (p.getStatus().equals("Paid")) {
                    totalCollected += p.getPaid(); // Total collected
                }
            }

            double pending = totalExpected - totalCollected;

            // Display summary
            totalexpectedL.setText("BDT " + String.format("%.2f", totalExpected));
            collectrentL.setText("BDT " + String.format("%.2f", totalCollected));
            pendingrentL.setText("BDT " + String.format("%.2f", pending));

        } catch (FileNotFoundException e) {
            messageL.setText("No payment data file found!");
            totalexpectedL.setText("BDT 0");
            collectrentL.setText("BDT 0");
            pendingrentL.setText("BDT 0");
        } catch (Exception e) {
            messageL.setText("Error ");
            e.printStackTrace();
        }
    }

    private int getMonthNumber(String month) {
        String[] months = {"January","February","March","April","May","June",
                "July","August","September","October","November","December"};
        for(int i=0; i<months.length; i++) {
            if(months[i].equals(month)) return i+1;
        }
        return 1;
    }

    @javafx.fxml.FXML
    public void generateOC(ActionEvent actionEvent) {
        String month = monthCB.getValue();
        Integer year = YearCB.getValue();

        if (month == null || year == null) {
            messageL.setText("Please select month and year!");
            return;
        }
        ArrayList<RentPaymentRelated> filtered = new ArrayList<>();
        for (RentPaymentRelated p : RentpaymentList) {
            if (p.getDate().getMonthValue() == getMonthNumber(month) &&
                    p.getDate().getYear() == year) {
                filtered.add(p);
            }
        }
        rentTrackTableview.getItems().clear();
        rentTrackTableview.getItems().addAll(filtered);
        messageL.setText("Report for payments");


    }


    @javafx.fxml.FXML
    public void backbutton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjectManagerDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void refreshOC(ActionEvent actionEvent) {
        LoadOC(null);
    }


}