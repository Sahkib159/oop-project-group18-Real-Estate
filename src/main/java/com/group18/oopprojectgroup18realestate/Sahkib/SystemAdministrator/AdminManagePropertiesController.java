package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator.Property;
import com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator.PropertyService;

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
import java.util.List;

public class AdminManagePropertiesController {

    @FXML
    private TextField propertyLocationTextField;
    @FXML
    private TextField propertyPriceTextField;
    @FXML
    private TextField propertyTitleTextField;
    @FXML
    private TextField propertyIdTextField;

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

    @FXML
    private ComboBox<String> statusComboBox;

    // Main property list (loaded from file)
    private ObservableList<Property> propertyList;

    @FXML
    public void initialize() {

        // TableView column mapping
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        // ComboBox
        statusComboBox.getItems().addAll("Available", "Sold", "Rented", "Pending");

        // Load from file
        List<Property> loaded = PropertyService.loadProperties();
        propertyList = FXCollections.observableArrayList(loaded);


        // SAMPLE DATA
        /*
        propertyList.add(new Property("P101", "Luxury Apartment", "Gulshan", 55000, "Available"));
        propertyList.add(new Property("P102", "Office Space", "Banani", 80000, "Rented"));
        PropertyService.saveProperties(new ArrayList<>(propertyList));
        */

        tableView.setItems(propertyList);
    }


    @FXML
    public void addPropertyOnClick(ActionEvent actionEvent) {
        String id = propertyIdTextField.getText();
        String title = propertyTitleTextField.getText();
        String location = propertyLocationTextField.getText();
        String priceStr = propertyPriceTextField.getText();
        String status = statusComboBox.getValue();

        if (id.isEmpty() || title.isEmpty() || location.isEmpty() || priceStr.isEmpty() || status == null) {
            showAlert("Error", "Please fill all fields");
            return;
        }

        double price;
        try { price = Double.parseDouble(priceStr); }
        catch (Exception e) {
            showAlert("Error", "Price must be a number!");
            return;
        }

        // Prevent duplicate ID
        for (Property p : propertyList) {
            if (p.getId().equalsIgnoreCase(id)) {
                showAlert("Error", "Property ID already exists!");
                return;
            }
        }

        Property newProperty = new Property(id, title, location, price, status);

        propertyList.add(newProperty);
        PropertyService.saveProperties(propertyList);

        tableView.refresh();
        clearFields();

        showAlert("Success", "Property Added!");
//I added it later
        LogService.addLog("Property " + id + " added.");

    }


    @FXML
    public void editPropertyOnClick(ActionEvent actionEvent) {
        Property selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a property to edit!");
            return;
        }

        String id = propertyIdTextField.getText();
        String title = propertyTitleTextField.getText();
        String location = propertyLocationTextField.getText();
        String priceStr = propertyPriceTextField.getText();
        String status = statusComboBox.getValue();

        if (id.isEmpty() || title.isEmpty() || location.isEmpty() || priceStr.isEmpty() || status == null) {
            showAlert("Error", "Please fill all fields");
            return;
        }

        double price;
        try { price = Double.parseDouble(priceStr); }
        catch (Exception e) {
            showAlert("Error", "Price must be a number!");
            return;
        }

        // Update property
        selected.setId(id);
        selected.setTitle(title);
        selected.setLocation(location);
        selected.setPrice(price);
        selected.setStatus(status);

        PropertyService.saveProperties(propertyList);
        tableView.refresh();
        clearFields();

        showAlert("Success", "Property Updated!");
//I added it later
        LogService.addLog("Property " + id + " updated.");

    }


    @FXML
    public void deletePropertyOnClick(ActionEvent actionEvent) {
        Property selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a property to delete!");
            return;
        }

        propertyList.remove(selected);
        PropertyService.saveProperties(propertyList);

        tableView.refresh();
        showAlert("Success", "Property Deleted!");
//I added it later
        LogService.addLog("Property " + selected.getId() + " deleted.");

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
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
