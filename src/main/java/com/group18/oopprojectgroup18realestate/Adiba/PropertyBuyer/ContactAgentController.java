package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ContactAgentController {
    @javafx.fxml.FXML
    private TextField propertyIdTF;
    @javafx.fxml.FXML
    private ComboBox<String> responseMethodCB;
    @javafx.fxml.FXML
    private TextArea yourMessageTF;
    @javafx.fxml.FXML
    private Label outputLabel;
    public ArrayList<contactAgent> requestList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        responseMethodCB.getItems().addAll("Email", "Phone");
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PropertyBuyerDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();

    }

    @javafx.fxml.FXML
    public void sendRequestOA(ActionEvent actionEvent) {
        String propertyID = propertyIdTF.getText();
        String message = yourMessageTF.getText();
        String method = responseMethodCB.getValue();

        if (propertyID.isEmpty() || message.isEmpty() || method == null) {
            outputLabel.setText("Please fill all the fields");
            return;
        }
        for (contactAgent c : requestList) {
            if (c.getPropertyID().equals(propertyID)) {
                outputLabel.setText("Duplicate alert! Has to be an unique PropertyID");
                return;
            }
        }

        contactAgent newReq = new contactAgent(propertyID, message, method);
        requestList.add(newReq);

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("contactRequests.bin")
        )){
                out.writeObject(requestList);
                outputLabel.setText("Request sent and saved successfully");
            } catch (IOException ex) {
            outputLabel.setText("saving failed");
        }
    }


    @javafx.fxml.FXML
    public void loadOA(ActionEvent actionEvent) {
        try(ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("contactRequests.bin")
        )){
            requestList = (ArrayList<contactAgent>) in.readObject();
            outputLabel.setText("requests loaded sucessfully");

        } catch (Exception ex) {
            outputLabel.setText("no saved file found");

        }
    }
}