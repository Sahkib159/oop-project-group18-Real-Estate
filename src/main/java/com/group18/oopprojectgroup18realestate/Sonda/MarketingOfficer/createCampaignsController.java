package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class createCampaignsController {

    @FXML
    private TableColumn<Createcampaigns, String> EndDateColumn;

    @FXML
    private DatePicker EndDatePicker;

    @FXML
    private TextField campaignBudetField;

    @FXML
    private TableColumn<Createcampaigns, String> campaignBudgetColumn;

    @FXML
    private TextField campaignTitleField;

    @FXML
    private TableColumn<Createcampaigns, String> campaigntitleColumn;

    @FXML
    private TableColumn<Createcampaigns, String> startDateColumn;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private TableColumn<Createcampaigns, String> targetaudiColumn;

    @FXML
    private TextField targetaudiField;

    @FXML
    void addselectpropertyButton(ActionEvent event) {

    }

    @FXML
    public void backbutton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MarketingOfficerDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @FXML
    void removeselectedpropertybutton(ActionEvent event) {

    }
}
