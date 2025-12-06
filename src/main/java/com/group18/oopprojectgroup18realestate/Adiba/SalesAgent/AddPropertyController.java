package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;


public class AddPropertyController
{
    @javafx.fxml.FXML
    private TableColumn<addNewProperty, String> sizeCol;
    @javafx.fxml.FXML
    private TableColumn<addNewProperty, String> locationCol;
    @javafx.fxml.FXML
    private TextField locationTF;
    @javafx.fxml.FXML
    private TextField priceTF;
    @javafx.fxml.FXML
    private TableView<addNewProperty> bookingTable;
    @javafx.fxml.FXML
    private TableColumn<addNewProperty, String> availabilityCol;
    @javafx.fxml.FXML
    private TextField buyerNameTF;
    @javafx.fxml.FXML
    private TextField featuresTF;
    @javafx.fxml.FXML
    private Label outputLabel1;
    @javafx.fxml.FXML
    private TextField availabilityTF;
    @javafx.fxml.FXML
    private TextField sizeTF;
    @javafx.fxml.FXML
    private TableColumn<addNewProperty, String> propertyIdCol;
    @javafx.fxml.FXML
    private TableColumn<addNewProperty, String> priceCol;
    @javafx.fxml.FXML
    private TextField propertyIdTF;
    @javafx.fxml.FXML
    private TableColumn<addNewProperty, String> featuresCol;
    @javafx.fxml.FXML
    private TableColumn<addNewProperty, String> buyerNameCol;

    @javafx.fxml.FXML
    public void initialize() {
        propertyIdCol.setCellValueFactory(new PropertyValueFactory<>("propertyId"));
        buyerNameCol.setCellValueFactory(new PropertyValueFactory<>("buyerName"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        availabilityCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
        featuresCol.setCellValueFactory(new PropertyValueFactory<>("features"));

    }

    @javafx.fxml.FXML
    public void savePropertyOA(ActionEvent actionEvent) {
        if (propertyIdTF.getText().isEmpty() || buyerNameTF.getText().isEmpty() ||
                priceTF.getText().isEmpty() || sizeTF.getText().isEmpty() ||
                locationTF.getText().isEmpty() || availabilityTF.getText().isEmpty() ||
                featuresTF.getText().isEmpty()) {
            outputLabel1.setText("All fields must be filled");
            return;

        }

        addNewProperty prop = new addNewProperty(
                propertyIdTF.getText(),
                buyerNameTF.getText(),
                priceTF.getText(),
                sizeTF.getText(),
                locationTF.getText(),
                availabilityTF.getText(),
                featuresTF.getText()
        );
        bookingTable.getItems().add(prop);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("addBooking.bin"))) {
            out.writeObject(new ArrayList<>(bookingTable.getItems()));
            outputLabel1.setText("Property saved successfully");
        } catch (Exception e) {
            outputLabel1.setText("Error saving property");

        }


        propertyIdTF.clear();
        buyerNameTF.clear();
        priceTF.clear();
        sizeTF.clear();
        locationTF.clear();
        availabilityTF.clear();
        featuresTF.clear();
    }

    @javafx.fxml.FXML
    public void loadSelectedOA(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("addBooking.bin"))) {
            ArrayList<addNewProperty> props = (ArrayList<addNewProperty>) in.readObject();
            bookingTable.getItems().setAll(props);
            outputLabel1.setText("Properties loaded successfully");
        } catch (FileNotFoundException e) {
            outputLabel1.setText("No properties found");
        } catch (Exception e) {
            outputLabel1.setText("Error loading properties");
        }
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("SalesAgentDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }
}