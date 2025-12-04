package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class assignTicketsController {

    @FXML
    private TableColumn<AssignTickets, String> assignedtocolumn;

    @FXML
    private ComboBox<String> assigntocombobox;

    @FXML
    private TextField currentstatusField;

    @FXML
    private TableColumn<AssignTickets, String> customercolumn;

    @FXML
    private TableColumn<AssignTickets, String> issuetypecolumn;

    @FXML
    private TableColumn<AssignTickets, String> prioritycolumn;

    @FXML
    private ComboBox<String> prioritycombobox;

    @FXML
    private ComboBox<String> selectdepartmentcombobox;

    @FXML
    private TableColumn<AssignTickets, String> statuscolumn;

    @FXML
    private TextField tickedidfield;

    @FXML
    private TableColumn<AssignTickets, String> ticketidcolumn;

    @FXML
    private TextField ticketsummaryField;
    @FXML
    private TableView tableview;

    @javafx.fxml.FXML
    public void initialize() {
        selectdepartmentcombobox.getItems().addAll("Sales",  "Maintenance",  "Finance", "Support");
        assigntocombobox.getItems().addAll("Staff Name", "Team");
        prioritycombobox.getItems().addAll("Low , Medium , High");
        //assignedtocolumn.setCellValueFactory("");


    }


    @FXML
    void assignticketbutton(ActionEvent event) {
        tableview.getItems().clear();


    }

    @FXML
    void cleatformbutton(ActionEvent event) {

    }

    @FXML
    void updateassignmentbutton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            CoordinateIssue y;
            ois = new ObjectInputStream(new FileInputStream("AssignTickets.bin"));
            while (true) {
                y = (CoordinateIssue) ois.readObject();
                tableview.getItems().add(y);
            }
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

}
