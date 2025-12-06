package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ViewBuyerInquiriesController {
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
    private Label outputLabel;
    private ArrayList<Inquiries> inquiriesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        inquiryIdCol.setCellValueFactory(new PropertyValueFactory<>("inquiryId"));
        buyerNameCol.setCellValueFactory(new PropertyValueFactory<>("buyerName"));
        propertyIdCol.setCellValueFactory(new PropertyValueFactory<>("property"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
        loadInquiries();
        if (inquiryTable.getItems().isEmpty()) {
            addSampleInquiries();
        }
        inquiryTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                inquiryMessageTF.setText(newSel.getMessage());
                typeResponseTF.setText(newSel.getResponse() != null ? newSel.getResponse() : "");
            }
        });

    }

    private void loadInquiries() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("inquiries.bin"))) {
            while (true) {
                Inquiries inq = (Inquiries) in.readObject();
                inquiriesList.add(inq);
            }
        } catch (EOFException e) {
            inquiryTable.getItems().addAll(inquiriesList);
            outputLabel.setText("Inquiries loaded!");
        } catch (FileNotFoundException e) {
            outputLabel.setText("No previous inquiries found.");
        } catch (Exception e) {
            outputLabel.setText("Error loading inquiries: " + e.getMessage());
        }
    }

    private void saveInquiries() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("inquiries.bin"))) {
            for (Inquiries inq : inquiriesList) {
                out.writeObject(inq);
            }
        } catch (Exception e) {
            outputLabel.setText("Error saving inquiries: " + e.getMessage());
        }
    }

    private void addSampleInquiries() {
        Inquiries i1 = new Inquiries("I01", "Karim Ahmed", "P101",
                "Can I schedule a visit for Apartment 3A?", null);
        Inquiries i2 = new Inquiries("I02", "Fatima Rahman", "P205",
                "Is Villa B2 still available?", null);
        Inquiries i3 = new Inquiries("I03", "Hasan Ali", "P312",
                "Please provide more details about Flat 5C.", null);

        inquiriesList.add(i1);
        inquiriesList.add(i2);
        inquiriesList.add(i3);

        inquiryTable.getItems().addAll(inquiriesList);

        saveInquiries();
        outputLabel.setText("Sample inquiries loaded!");
    }


    @javafx.fxml.FXML
    public void saveResponseOA(ActionEvent actionEvent) {
        Inquiries selected = inquiryTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            outputLabel.setText("Select an inquiry first!");
            return;
        }

        String response = typeResponseTF.getText();
        if (response == null || response.isEmpty()) {
            outputLabel.setText("Type a response first!");
            return;
        }

        selected.setResponse(response);
        inquiryTable.refresh();
        saveInquiries();
        outputLabel.setText("Response saved for " + selected.getBuyerName());
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