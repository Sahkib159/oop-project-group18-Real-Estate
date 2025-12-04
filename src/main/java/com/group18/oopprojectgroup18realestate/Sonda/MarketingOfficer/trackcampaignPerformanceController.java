package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class trackcampaignPerformanceController {

    @FXML
    private TextField ClickField;

    @FXML
    private TableColumn<?, ?> areacolumn;

    @FXML
    private TableColumn<?, ?> datecolumn;

    @FXML
    private TableColumn<?, ?> demandcolumn;

    @FXML
    private TextField leadField;

    @FXML
    private TableColumn<?, ?> priceTrendColumn;

    @FXML
    private ComboBox<?> reporttypeCombobox;

    @FXML
    private ComboBox<?> selectcompaignComboBox;

    @FXML
    private DatePicker selectperiodDatePicker;

    @FXML
    private TableColumn<?, ?> tableviewcolumn;

    @FXML
    private TextField viewField;

    @FXML
    void ExportReportButton(ActionEvent event) {

    }

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void refreshmetricsbutton(ActionEvent event) {

    }

}
