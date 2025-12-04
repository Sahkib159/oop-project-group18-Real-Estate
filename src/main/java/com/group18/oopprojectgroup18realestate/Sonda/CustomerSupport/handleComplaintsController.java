package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class handleComplaintsController {

    @FXML
    private TextField complaintidtextField;

    @FXML
    private ComboBox<String> complaintstatuscombobox;

    @FXML
    private ComboBox<String> complainttypecombobox;

    @FXML
    private TextField contractnumbertextfield;

    @FXML
    private TableColumn<Handlecomplaints, String> customernamecolumn;

    @FXML
    private TextField customernametextfield;

    @FXML
    private TableColumn<Handlecomplaints, String> datesubmittedcolumn;

    @FXML
    private TableColumn<Handlecomplaints, String> idcolumn;

    @FXML
    private TableColumn<Handlecomplaints, String> statuscolumn;

    @FXML
    private TableColumn<Handlecomplaints, String> typecolumn;
    @FXML
    private TableView tableview;

    @FXML
    void clearformbutton(ActionEvent event) {

    }

    @FXML
    void submitcomplaintbutton(ActionEvent event) {

    }

    @FXML
    void updatecomplaintbutton(ActionEvent event) {

    }

}
