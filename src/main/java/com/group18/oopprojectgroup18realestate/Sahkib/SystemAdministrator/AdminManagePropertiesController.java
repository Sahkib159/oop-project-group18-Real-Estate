package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.Property;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminManagePropertiesController {

    @FXML
    private TextField propertyIdTextField;
    @FXML
    private TextField propertyTitleTextField;
    @FXML
    private TextField propertyLocationTextField;
    @FXML
    private TextField propertyPriceTextField;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private TableView<Property> tableView;
    @FXML
    private TableColumn<Property, String> idCol;
    @FXML
    private TableColumn<Property, String> titleCol;
    @FXML
    private TableColumn<Property, String> statusCol;
    @FXML
    private TableColumn<Property, String> priceCol;

    private ObservableList<Property> propertyList;

    @FXML
    public void initialize() {

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        statusComboBox.getItems().addAll("Available", "Sold", "Rented", "Pending");

        List<Property> loaded = PropertyService.loadProperties();
        propertyList = FXCollections.observableArrayList(loaded);

        tableView.setItems(propertyList);
    }

    @FXML
    public void addPropertyOnClick(ActionEvent event) {

        String id = propertyIdTextField.getText();
        String title = propertyTitleTextField.getText();
        String location = propertyLocationTextField.getText();
        String priceStr = propertyPriceTextField.getText();
        String status = statusComboBox.getValue();

        if (id.isEmpty() || title.isEmpty() || location.isEmpty() ||
                priceStr.isEmpty() || status == null) {
            showAlert("Error", "Please fill all fields.");
            return;
        }

        double price;
        try { price = Double.parseDouble(priceStr); }
        catch (Exception e) {
            showAlert("Error", "Price must be a number.");
            return;
        }

        for (Property p : propertyList) {
            if (p.getId().equalsIgnoreCase(id)) {
                showAlert("Error", "Property ID already exists.");
                return;
            }
        }

        Property newP = new Property(id, title, location, price, status);
        propertyList.add(newP);

        PropertyService.saveProperties(new ArrayList<>(propertyList));

        clearFields();
        tableView.refresh();
        showAlert("Success", "Property added successfully.");
    }

    @FXML
    public void editPropertyOnClick(ActionEvent event) {

        Property selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Error", "Select a property to edit.");
            return;
        }

        selected.setId(propertyIdTextField.getText());
        selected.setTitle(propertyTitleTextField.getText());
        selected.setLocation(propertyLocationTextField.getText());
        selected.setPrice(Double.parseDouble(propertyPriceTextField.getText()));
        selected.setStatus(statusComboBox.getValue());

        PropertyService.saveProperties(new ArrayList<>(propertyList));

        clearFields();
        tableView.refresh();
        showAlert("Success", "Property updated successfully.");
    }

    @FXML
    public void deletePropertyOnClick(ActionEvent event) {

        Property selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a property to delete.");
            return;
        }

        propertyList.remove(selected);
        PropertyService.saveProperties(new ArrayList<>(propertyList));

        tableView.refresh();
        showAlert("Success", "Property deleted successfully.");
    }

    private void clearFields() {
        propertyIdTextField.clear();
        propertyTitleTextField.clear();
        propertyLocationTextField.clear();
        propertyPriceTextField.clear();
        statusComboBox.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setTitle(title);
        a.setContentText(msg);
        a.showAndWait();
    }

    @FXML
    public void backOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
