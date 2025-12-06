package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class generateReportsController {

    @FXML
    private TextField TotalClickTextField;

    @FXML
    private TableColumn<?, ?> campaignNameColumn;

    @FXML
    private TableColumn<?, ?> clickColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TableColumn<?, ?> leadsColumn;

    @FXML
    private TextField leadsTextField;

    @FXML
    private ComboBox<?> reporttypeCombobox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private TextField tacleviewTextField;

    @FXML
    private TableColumn<?, ?> viewColumn;

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void clearfiltersButton(ActionEvent event) {

    }

    @FXML
    void generatereportButton(ActionEvent event) {

    }

}
