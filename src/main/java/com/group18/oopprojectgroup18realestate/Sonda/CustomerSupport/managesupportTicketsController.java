package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class managesupportTicketsController {

    @FXML
    private ComboBox<String> priorityCombobox;

    @FXML
    private TableColumn<Managesupporttickets, String> prioritycolumn;

    @FXML
    private ComboBox<String> ticketStatusComboBox;

    @FXML
    private TableColumn<Managesupporttickets, String> ticketidColumn;

    @FXML
    private TextField ticketidTextfield;

    @FXML
    private TableColumn<Managesupporttickets, String> ticketstatuscolumn;

    @FXML
    private TableColumn<Managesupporttickets, String> usernamecolumn;

    @FXML
    private TextField usernametextField;
    @FXML
    private TableView<Managesupporttickets> tableview;

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
