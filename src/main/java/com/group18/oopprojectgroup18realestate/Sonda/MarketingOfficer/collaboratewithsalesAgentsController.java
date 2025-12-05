package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class collaboratewithsalesAgentsController {

    @FXML
    private TableColumn<Collaboratewithsalesagents, String> agentcolumn;

    @FXML
    private ComboBox<?> agentcombobox;

    @FXML
    private TableColumn<Collaboratewithsalesagents, String> datecolumn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TableColumn<Collaboratewithsalesagents, String> materialcolumn;

    @FXML
    private TextField materialtextfield;

    @FXML
    public void backbutton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MarketingOfficerDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();

    }

    @FXML
    void clearbutton(ActionEvent event) {

    }

    @FXML
    void sharebutton(ActionEvent event) {

    }

}
