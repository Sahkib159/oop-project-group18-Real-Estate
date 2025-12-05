package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class inquirySupportController
{
    @javafx.fxml.FXML
    private TextArea inquiryTA;
    @javafx.fxml.FXML
    private Label inquirymessageTF;

    ArrayList<inquirySupport> inquiryList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        inquirymessageTF.setText("write your question or message");
    }

    @javafx.fxml.FXML
    public void sendinquiryOnClickButton(ActionEvent actionEvent) {
        String message = inquiryTA.getText().strip();

        //validation check
        if(message.isEmpty()){
            inquirymessageTF.setText("please write message first");
            return;
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("inquiries.bin"))) {
            out.writeObject(inquiryList);
            // Event 6: Confirmation message
            inquirymessageTF.setText("Inquiry sent successfully!");
            inquiryTA.clear();
        } catch (Exception e) {
            inquirymessageTF.setText("Failed to send inquiry!");
            e.printStackTrace();
        }


    }

    @javafx.fxml.FXML
    public void backbuttonOC(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}