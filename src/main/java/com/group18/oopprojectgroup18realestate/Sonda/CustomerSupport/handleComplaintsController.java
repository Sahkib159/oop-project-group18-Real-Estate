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
    private ComboBox<?> complaintstatuscombobox;

    @FXML
    private ComboBox<?> complainttypecombobox;

    @FXML
    private TextField contractnumbertextfield;

    @FXML
    private TableColumn<?, ?> customernamecolumn;

    @FXML
    private TextField customernametextfield;

    @FXML
    private TableColumn<?, ?> datesubmittedcolumn;

    @FXML
    private TableColumn<?, ?> idcolumn;

    @FXML
    private TableColumn<?, ?> statuscolumn;

    @FXML
    private TableColumn<?, ?> typecolumn;
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
