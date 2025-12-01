package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AdminManagePropertiesController
{
    @javafx.fxml.FXML
    private TextField propertyLocationTextField;
    @javafx.fxml.FXML
    private TableColumn<Property, String> titleCol;
    @javafx.fxml.FXML
    private TableColumn<Property, String> idCol;
    @javafx.fxml.FXML
    private TextField propertyPriceTextField;
    @javafx.fxml.FXML
    private TableColumn<Property, String> statusCol;
    @javafx.fxml.FXML
    private TextField propertyTitleTextField;
    @javafx.fxml.FXML
    private TableView<Property> tableView;
    @javafx.fxml.FXML
    private TextField propertyIdTextField;
    @javafx.fxml.FXML
    private TableColumn<Property, String> priceCol;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;


    private ObservableList<Property> propertyList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        statusComboBox.getItems().addAll("Available", "Sold", "Rented", "Pending");

        // sample data
        propertyList.add(new Property("P101", "Luxury Apartment", "Gulshan", 55000, "Available"));
        propertyList.add(new Property("P102", "Office Space", "Banani", 80000, "Rented"));

        tableView.setItems(propertyList);
    }

    @javafx.fxml.FXML
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
        try {
            price = Double.parseDouble(priceStr);
        } catch (Exception e) {
            showAlert("Error", "Price must be a number!");
            return;
        }

        // Update data
        selected.setId(id);
        selected.setTitle(title);
        selected.setLocation(location);
        selected.setPrice(price);
        selected.setStatus(status);

        tableView.refresh();
        clearFields();

        showAlert("Success", "Property Updated!");

    }



    @javafx.fxml.FXML
    public void deletePropertyOnClick(ActionEvent actionEvent) {
        Property selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a property to delete!");
            return;
        }

        propertyList.remove(selected);
        tableView.refresh();

        showAlert("Success", "Property Deleted!");
    }


    @javafx.fxml.FXML
    public void addPropertyOnClick(ActionEvent actionEvent) {
        String id = propertyIdTextField.getText();
        String title = propertyTitleTextField.getText();
        String location = propertyLocationTextField.getText();
        String priceStr = propertyPriceTextField.getText();
        String status = statusComboBox.getValue();

        // Validation
        if (id.isEmpty() || title.isEmpty() || location.isEmpty() || priceStr.isEmpty() || status == null) {
            showAlert("Error", "Please fill all fields");
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceStr);
        } catch (Exception e) {
            showAlert("Error", "Price must be a number!");
            return;
        }

        // Check if property already exists
        for (Property p : propertyList) {
            if (p.getId().equalsIgnoreCase(id)) {
                showAlert("Error", "Property ID already exists!");
                return;
            }
        }

        propertyList.add(new Property(id, title, location, price, status));
        tableView.refresh();
        clearFields();

        showAlert("Success", "Property Added!");
    }
    private void clearFields() {
        propertyIdTextField.clear();
        propertyTitleTextField.clear();
        propertyLocationTextField.clear();
        propertyPriceTextField.clear();
        statusComboBox.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}