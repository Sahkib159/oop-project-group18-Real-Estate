package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class assistduringpropertyviewingSchedulingController {

    @FXML
    private TableColumn<assistduringproperty, String> bookingidcolumn;

    @FXML
    private TextField bookingidfield;

    @FXML
    private TableColumn<assistduringproperty, String> customercolumn;

    @FXML
    private TextField customercontactField;

    @FXML
    private TextField customernamefield;

    @FXML
    private TableColumn<assistduringproperty, String> datecolumn;

    @FXML
    private DatePicker preferreddatepicker;

    @FXML
    private ComboBox<?> preferredtimecombobox;

    @FXML
    private TextField propertyidField;

    @FXML
    private TableColumn<AssistduringpropertyviewingScheduling, String> propertyidcolumn;

    @FXML
    private TableColumn<AssistduringpropertyviewingScheduling, String> timecolumn;
    @FXML
    private TableView<assistduringproperty> tableview;

    @FXML
    void checkavailabilitybutton(ActionEvent event) {

    }

    @FXML
    void savebookingbutton(ActionEvent event) {

    }

    @FXML
    void updatebookingbutton(ActionEvent event) {

    }

}
