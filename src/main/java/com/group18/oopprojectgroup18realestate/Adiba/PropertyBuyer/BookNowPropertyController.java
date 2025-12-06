package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;


public class BookNowPropertyController
{
    @javafx.fxml.FXML
    private TextField propertyIdTF;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private ComboBox<String> paymentPlanCB;
    @javafx.fxml.FXML
    private TextField contactTF;
    public ArrayList<bookProperty> bookingList = new ArrayList<>();
    @javafx.fxml.FXML
    private Label outputLabel;


    @javafx.fxml.FXML
    public void initialize() {
        paymentPlanCB.getItems().addAll("Full payment", "Installment");

    }

    @javafx.fxml.FXML
    public void bookNowOA(ActionEvent actionEvent) {
        String name = nameTF.getText();
        String contact = contactTF.getText();
        String propertyID = propertyIdTF.getText();
        String paymentPlan = paymentPlanCB.getValue();


        if(name.isEmpty()|| contact.isEmpty()|| propertyID.isEmpty()||paymentPlan == null){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Validation error");
            a.setHeaderText(null);
            a.setContentText("Please fill all the fields.");
            a.showAndWait();
            return;

        }
        for (bookProperty bp: bookingList){
            if(bp.getPropertyID().equals(propertyID)){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Duplicate Error");
                a.setHeaderText(null);
                a.setContentText("This property ID is already booked!");
                a.showAndWait();
                return;
            }
        }

        bookProperty b = new bookProperty(name, contact, propertyID, paymentPlan);
        bookingList.add(b);
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("booking.bin")
        )) {
            out.writeObject(bookingList);
            outputLabel.setText("booking added and saved successfully");
        } catch (IOException ex) {
            outputLabel.setText("saving failed");

            nameTF.clear();
            contactTF.clear();
            propertyIdTF.clear();
            paymentPlanCB.setValue(null);

        }
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PropertyBuyerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.show();

        }

    @javafx.fxml.FXML
    public void loadOA(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("booking.bin"))){
            bookingList = (ArrayList<bookProperty>) in.readObject();
            outputLabel.setText("Loaded successfully");
        } catch (FileNotFoundException ex) {
            outputLabel.setText("No saved files found");
        } catch (Exception ex) {
            outputLabel.setText("Error loading bookings");

        }
    }
}
