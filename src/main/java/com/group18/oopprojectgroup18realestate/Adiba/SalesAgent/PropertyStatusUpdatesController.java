package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class PropertyStatusUpdatesController {

    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField propertyIdTF;
    @javafx.fxml.FXML
    private TextField buyerNameTF;
    @javafx.fxml.FXML
    private TextField writeMessageTF;
    private ArrayList<notificationAgent> notificationList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SalesAgentDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }


    @javafx.fxml.FXML
    public void sendUpdateOA(ActionEvent actionEvent) {
        String propertyID = propertyIdTF.getText();
        String buyerName = buyerNameTF.getText();
        String writeMessage = writeMessageTF.getText();

        if (propertyID.isEmpty() || buyerName.isEmpty() || writeMessage.isEmpty()) {
            outputLabel.setText("All fields must be filled");
            return;
        }
        notificationAgent na = new notificationAgent(propertyID, buyerName, writeMessage);
        notificationList.add(na);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("notificationAgent.bin"))) {
            out.writeObject(notificationList);
            outputLabel.setText("Update sent successfully");

        } catch (IOException e) {
            outputLabel.setText("error saving");
            e.printStackTrace();
        }
        propertyIdTF.clear();
        buyerNameTF.clear();
        writeMessageTF.clear();
    }

    @javafx.fxml.FXML
    public void loadNotificationsOA(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("notificationAgent.bin"))) {
            notificationList = (ArrayList<notificationAgent>) in.readObject();
            outputLabel.setText("Loaded successfully!");
        } catch (Exception e) {
            outputLabel.setText("No saved notifications found!");
        }
    }
}