package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class managesupportTicketsController {

    @FXML
    private ComboBox<?> priorityCombobox;

    @FXML
    private TableColumn<?, ?> prioritycolumn;

    @FXML
    private ComboBox<?> ticketStatusComboBox;

    @FXML
    private TableColumn<?, ?> ticketidColumn;

    @FXML
    private TextField ticketidTextfield;

    @FXML
    private TableColumn<?, ?> ticketstatuscolumn;

    @FXML
    private TableColumn<?, ?> usernamecolumn;

    @FXML
    private TextField usernametextField;

    @FXML
    void closeticketbutton(ActionEvent event) {

    }

    @FXML
    void createticketbutton(ActionEvent event) {

    }

    @FXML
    void updateticketbutton(ActionEvent event) {

    }

}
