package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ContactAgentController
{
    @javafx.fxml.FXML
    private TextField propertyIdTF;
    @javafx.fxml.FXML
    private ComboBox<String> responseMethodCB;
    @javafx.fxml.FXML
    private TextArea yourMessageTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PropertyBuyerDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();

    }

    @javafx.fxml.FXML
    public void sendRequestOA(ActionEvent actionEvent) {
    }
}
