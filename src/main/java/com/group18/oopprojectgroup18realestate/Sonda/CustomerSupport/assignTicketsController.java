package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class assignTicketsController {

    @FXML
    private TableColumn<assignTickets, String> assignedtocolumn;

    @FXML
    private ComboBox<String> assigntocombobox;

    @FXML
    private TextField currentstatusField;

    @FXML
    private TableColumn<assignTickets, String> customercolumn;

    @FXML
    private TableColumn<assignTickets, String> issuetypecolumn;

    @FXML
    private TableColumn<assignTickets, String> prioritycolumn;

    @FXML
    private ComboBox<?> prioritycombobox;

    @FXML
    private ComboBox<?> selectdepartmentcombobox;

    @FXML
    private TableColumn<?, ?> statuscolumn;

    @FXML
    private TextField tickedidfield;

    @FXML
    private TableColumn<assignTickets, String> ticketidcolumn;

    @FXML
    private TextField ticketsummaryField;
    @FXML
    private TableView tableview;

    @FXML
    void assignticketbutton(ActionEvent event) {

    }

    @FXML
    void cleatformbutton(ActionEvent event) {

    }

    @FXML
    void updateassignmentbutton(ActionEvent event) {

    }

}
