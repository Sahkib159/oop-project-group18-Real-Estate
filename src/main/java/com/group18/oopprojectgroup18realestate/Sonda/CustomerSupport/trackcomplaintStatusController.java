package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class trackcomplaintStatusController {

    @FXML
    private TextField complainthistorytextfield;

    @FXML
    private TextField complainttypetextfield;

    @FXML
    private TextField currentstatustextfield;

    @FXML
    private TableColumn<?, ?> customercolumn;

    @FXML
    private TextField customernametextfield;

    @FXML
    private TableColumn<?, ?> idcolumn;

    @FXML
    private TableColumn<?, ?> lastupdatedcolumn;

    @FXML
    private TextField searchbycomplainidtextfield;

    @FXML
    private TableColumn<?, ?> statuscolumn;

    @FXML
    private TableColumn<?, ?> typecolumn;

    @FXML
    void clearbutton(ActionEvent event) {

    }

    @FXML
    void refreshstatusbutton(ActionEvent event) {

    }

}
