package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class managePropertiesController {

    @FXML
    private ComboBox<?> PropertyTypeField;

    @FXML
    private ComboBox<?> StatusField;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TextField priceField;

    @FXML
    private TextField propertyIdField;

    @FXML
    private TableColumn<?, ?> propertyIdcolumn;

    @FXML
    private TableColumn<?, ?> propertynameColumn;

    @FXML
    private TextField propertynameField;

    @FXML
    private TableColumn<?, ?> propertytypeColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    void addPropertybutton(ActionEvent event) {

    }

    @FXML
    void backbutton(ActionEvent event) {

    }

    @FXML
    void updatePropertyButton(ActionEvent event) {

    }

}
