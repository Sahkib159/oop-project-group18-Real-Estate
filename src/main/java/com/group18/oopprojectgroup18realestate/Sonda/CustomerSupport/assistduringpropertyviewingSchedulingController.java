package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;



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
    private ComboBox<String> preferredtimecombobox;

    @FXML
    private TextField propertyidField;

    @FXML
    private TableColumn<AssistduringpropertyviewingScheduling, String> propertyidcolumn;

    @FXML
    private TableColumn<AssistduringpropertyviewingScheduling, String> timecolumn;
    @FXML
    private TableView<AssistduringpropertyviewingScheduling> tableview;

    @javafx.fxml.FXML
    public void initialize() {

    }


    @FXML
    void checkavailabilitybutton(ActionEvent event) {

    }

    @FXML
    void savebookingbutton(ActionEvent event) {

    }

    @FXML
    void updatebookingbutton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            AssistduringpropertyviewingScheduling y;
            ois = new ObjectInputStream(new FileInputStream("Assistduringproperty.bin"));
            while (true) {
                y = (AssistduringpropertyviewingScheduling) ois.readObject();
                tableview.getItems().addAll(y);
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
