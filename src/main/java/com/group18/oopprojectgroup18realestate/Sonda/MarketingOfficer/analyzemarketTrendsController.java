package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class analyzemarketTrendsController {

    @FXML
    private TableColumn<Analyzemarket, String> analyzeColumn;

    @FXML
    private ComboBox<String> areaCombobox;

    @FXML
    private ComboBox<String> competetorCombobox;

    @FXML
    private TableColumn<Analyzemarket, String> competitorColumn;

    @FXML
    private TableColumn<Analyzemarket, String> exportColumn;

    @FXML
    private TableColumn<Analyzemarket, String> selectareaColumn;

    @FXML
    private TableColumn<Analyzemarket, String> summaryColumn;

    @FXML
    private TextField summaryTextField;

    @FXML
    void analyzeButton(ActionEvent event) {

    }

    @FXML
    public void backbutton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MarketingOfficerdashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @FXML
    void exportButton(ActionEvent event) {

    }
}
