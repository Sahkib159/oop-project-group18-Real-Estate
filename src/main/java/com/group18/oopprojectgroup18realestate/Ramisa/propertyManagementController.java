package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class propertyManagementController {

    @javafx.fxml.FXML
    private TextField rentTF;
    @javafx.fxml.FXML
    private ComboBox<String> proTypeTF;
    @javafx.fxml.FXML
    private TextField contactTF;
    @javafx.fxml.FXML
    private TextField loIDTF;
    @javafx.fxml.FXML
    private TextField proIDTF;
    @javafx.fxml.FXML
    private ComboBox<String> statusTF;
    @javafx.fxml.FXML
    private TextField facilitesTF;
    @javafx.fxml.FXML
    private Label messageL;
    @javafx.fxml.FXML
    private TableView<propertymanagement> PMtableView;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement, Integer> idcol;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement, String> locCol;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement, String> typeCOL;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement, Double> PriceCol;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement, String> StatusCOL;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement, String> facilitiesCOL;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement, Integer> contactCOL;

    private ArrayList<propertymanagement> propertyList = new ArrayList<>();



    @javafx.fxml.FXML
    public void initialize() {

        proTypeTF.getItems().addAll("Apartment", "House", "Flat", "Commercial");
        statusTF.getItems().addAll("Available", "Occupied", "Maintenance");

        idcol.setCellValueFactory(new PropertyValueFactory<>("propertyID"));
        locCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        typeCOL.setCellValueFactory(new PropertyValueFactory<>("propertyType"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
        StatusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));
        facilitiesCOL.setCellValueFactory(new PropertyValueFactory<>("facilities"));
        contactCOL.setCellValueFactory(new PropertyValueFactory<>("contact"));

        loadOC(null);
    }

    @javafx.fxml.FXML
    public void backbutton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjectManagerDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void addbuttonOC(ActionEvent actionEvent) {

        String propertyID = proIDTF.getText().trim();
        String location = loIDTF.getText().trim();
        String rentText = rentTF.getText().trim();
        String type = proTypeTF.getValue();
        String status = statusTF.getValue();
        String contactText = contactTF.getText().trim();
        String facilities = facilitesTF.getText().trim();

        if (propertyID.isEmpty() || location.isEmpty() || rentText.isEmpty()
                || type == null || status == null
                || contactText.isEmpty() || facilities.isEmpty()) {
            messageL.setText("Please fill all information!");
            return;
        }

        int propertyIdInt;
        try {
            propertyIdInt = Integer.parseInt(propertyID);
            if (propertyIdInt <= 0) throw new NumberFormatException();
        } catch (Exception e) {
            messageL.setText("Invalid Property ID!");
            return;
        }

        double rentDouble;
        try {
            rentDouble = Double.parseDouble(rentText);
            if (rentDouble <= 0) throw new NumberFormatException();
        } catch (Exception e) {
            messageL.setText("Invalid rent!");
            return;
        }

        int contactInt;
        try {
            contactInt = Integer.parseInt(contactText);
        } catch (Exception e) {
            messageL.setText("Invalid contact number!");
            return;
        }

        propertymanagement newProperty =
                new propertymanagement(propertyIdInt, location, rentDouble,
                        type, status, contactInt, facilities);

        propertyList.add(newProperty);
        saveToFile();

        PMtableView.getItems().setAll(propertyList);
        messageL.setText("Property saved!");
    }


    @javafx.fxml.FXML
    public void showOC(ActionEvent actionEvent) {

        propertymanagement selected = PMtableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageL.setText("Please select a property");
            return;
        }

        proIDTF.setText(String.valueOf(selected.getPropertyID()));
        loIDTF.setText(selected.getLocation());
        proTypeTF.setValue(selected.getPropertyType());
        rentTF.setText(String.valueOf(selected.getRentPrice()));
        statusTF.setValue(selected.getStatus());
        contactTF.setText(String.valueOf(selected.getContact()));
        facilitesTF.setText(selected.getFacilities());

        messageL.setText("Property loaded!");
    }


    @javafx.fxml.FXML
    public void updateOC(ActionEvent actionEvent) {

        propertymanagement selected = PMtableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageL.setText("Please select a property");
            return;
        }

        try {
            selected.setPropertyID(Integer.parseInt(proIDTF.getText().trim()));
            selected.setLocation(loIDTF.getText().trim());
            selected.setRentPrice(Double.parseDouble(rentTF.getText().trim()));
            selected.setPropertyType(proTypeTF.getValue());
            selected.setStatus(statusTF.getValue());
            selected.setContact(Integer.parseInt(contactTF.getText().trim()));
            selected.setFacilities(facilitesTF.getText().trim());

            PMtableView.refresh();
            saveToFile();
            messageL.setText("Property updated!");

        } catch (Exception e) {
            messageL.setText("Invalid update data!");
        }
    }


    @javafx.fxml.FXML
    public void removeOC(ActionEvent actionEvent) {

        propertymanagement selected = PMtableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageL.setText("Please select a property to remove!");
            return;
        }

        propertyList.remove(selected);
        PMtableView.getItems().remove(selected);
        saveToFile();

        messageL.setText("Property removed!");
    }


    @javafx.fxml.FXML
    public void searchOC(ActionEvent actionEvent) {

        try {
            int searchID = Integer.parseInt(proIDTF.getText().trim());
            PMtableView.getItems().clear();

            for (propertymanagement p : propertyList) {
                if (p.getPropertyID() == searchID) {
                    PMtableView.getItems().add(p);
                    messageL.setText("Property found!");
                    return;
                }
            }

            messageL.setText("Property not found!");

        } catch (Exception e) {
            loadOC(null);
        }
    }


    @javafx.fxml.FXML
    public void loadOC(ActionEvent actionEvent) {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("properties.bin"))) {

            propertyList = (ArrayList<propertymanagement>) in.readObject();
            PMtableView.getItems().setAll(propertyList);
            messageL.setText("Loaded successfully!");

        } catch (Exception e) {
            messageL.setText("No saved file found!");
        }
    }


    private void saveToFile() {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("properties.bin"))) {

            out.writeObject(propertyList);

        } catch (Exception e) {
            messageL.setText("Saving failed!");
        }
    }
}
