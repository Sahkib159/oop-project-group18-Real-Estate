package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class generatesupportReportsController {

    @FXML
    private TableColumn<Generatesupportreports, String> customercolumn;

    @FXML
    private TableColumn<Generatesupportreports, String> datecolumn;

    @FXML
    private ComboBox<String> departmentfiltercombobox;

    @FXML
    private DatePicker enddatepicker;

    @FXML
    private ComboBox<String> reporttypecombobox;

    @FXML
    private DatePicker startdatepicker;

    @FXML
    private TableColumn<Generatesupportreports, String> statuscolumn;

    @FXML
    private TableColumn<Generatesupportreports, String> ticketidcolumn;

    @FXML
    private TableColumn<Generatesupportreports, String> typecolumn;
    @FXML
    private TableView tableview;

    @FXML
    void clearfilterbutton(ActionEvent event) {

    }

    @FXML
    void generatereportbutton(ActionEvent event) {

    }

}
