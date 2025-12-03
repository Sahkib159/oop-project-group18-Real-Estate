package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class manageuserfeedbackRatings {

    @FXML
    private TableColumn<?, ?> customernamecolumn;

    @FXML
    private TextField customernametextfield;

    @FXML
    private ComboBox<?> customertypecombobox;

    @FXML
    private TableColumn<?, ?> datesubmittedcolumn;

    @FXML
    private TableColumn<?, ?> feedbackidcolumn;

    @FXML
    private TextField feedbackidtextfield;

    @FXML
    private TextField feedbackmassagetextfield;

    @FXML
    private TableColumn<?, ?> ratingcolumn;

    @FXML
    private ComboBox<?> ratingcombobox;

    @FXML
    private TableColumn<?, ?> typecolumn;

    @FXML
    void clearformbutton(ActionEvent event) {

    }

    @FXML
    void submitfeedbackbutton(ActionEvent event) {

    }

    @FXML
    void updatefeedbackbutton(ActionEvent event) {

    }

}
