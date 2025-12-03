package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;

public class generatesupportReportsController {

    @FXML
    private TableColumn<?, ?> customercolumn;

    @FXML
    private TableColumn<?, ?> datecolumn;

    @FXML
    private ComboBox<?> departmentfiltercombobox;

    @FXML
    private DatePicker enddatepicker;

    @FXML
    private ComboBox<?> reporttypecombobox;

    @FXML
    private DatePicker startdatepicker;

    @FXML
    private TableColumn<?, ?> statuscolumn;

    @FXML
    private TableColumn<?, ?> ticketidcolumn;

    @FXML
    private TableColumn<?, ?> typecolumn;

    @FXML
    void clearfilterbutton(ActionEvent event) {

    }

    @FXML
    void generatereportbutton(ActionEvent event) {

    }

}
