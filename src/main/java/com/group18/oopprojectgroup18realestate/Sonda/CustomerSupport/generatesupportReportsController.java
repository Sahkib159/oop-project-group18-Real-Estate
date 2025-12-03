package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class generatesupportReportsController {

    @FXML
    private TableColumn<generatesupport, String> customercolumn;

    @FXML
    private TableColumn<generatesupport, String> datecolumn;

    @FXML
    private ComboBox<String> departmentfiltercombobox;

    @FXML
    private DatePicker enddatepicker;

    @FXML
    private ComboBox<String> reporttypecombobox;

    @FXML
    private DatePicker startdatepicker;

    @FXML
    private TableColumn<generatesupport, String> statuscolumn;

    @FXML
    private TableColumn<generatesupport, String> ticketidcolumn;

    @FXML
    private TableColumn<generatesupport, String> typecolumn;
    @FXML
    private TableView tableview;

    @FXML
    void clearfilterbutton(ActionEvent event) {

    }

    @FXML
    void generatereportbutton(ActionEvent event) {

    }

}
