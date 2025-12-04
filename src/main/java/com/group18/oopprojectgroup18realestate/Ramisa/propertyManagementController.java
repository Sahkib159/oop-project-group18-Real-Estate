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

public class propertyManagementController
{
    @javafx.fxml.FXML
    private TextField rentTF;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,String> typeCOL;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,String>StatusCOL;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,Double> PriceCol;
    @javafx.fxml.FXML
    private ComboBox<String> proTypeTF;
    @javafx.fxml.FXML
    private TextField contactTF;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,String> facilitiesCOL;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,Integer> idcol;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,String> locCol;
    @javafx.fxml.FXML
    private TextField loIDTF;
    @javafx.fxml.FXML
    private TextField proIDTF;
    @javafx.fxml.FXML
    private ComboBox<String> statusTF;
    @javafx.fxml.FXML
    private TableView<propertymanagement> PMtableView;
    @javafx.fxml.FXML
    private Label messageL;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,Integer> contactCOL;


    //Property Management Controller,propertymanagement model class(Manager can: Add, Update, Remove, Search properties)




    //arraylist
    private ArrayList<propertymanagement> propertyList =new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {

        //  comboboxes
        proTypeTF.getItems().addAll("Apartment", "House", "Flat", "Commercial");
        statusTF.getItems().addAll("Available", "Occupied", "Maintenance");

        // tablecolumns
        idcol.setCellValueFactory(new PropertyValueFactory<>("propertyID"));
        locCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        typeCOL.setCellValueFactory(new PropertyValueFactory<>("propertyType"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
        StatusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));
        facilitiesCOL.setCellValueFactory(new PropertyValueFactory<>("facilities"));

        loadOC(null);

    }


    @javafx.fxml.FXML
    public void backbutton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjectManagerDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void removeOC(ActionEvent actionEvent) {
        propertymanagement selected = PMtableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageL.setText(" Please select a property to remove!");
            return;
        }
        propertyList.remove(selected);
        PMtableView.getItems().remove(selected);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("properties.bin"))) {
            out.writeObject(propertyList);
        } catch (IOException e) {
            messageL.setText(" Remove failed!");
        }


    }

    @javafx.fxml.FXML
    public void updateOC(ActionEvent actionEvent) {
        propertymanagement selected = PMtableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageL.setText("Please select a property from table!");
            return;
        }

        String propertyID = proIDTF.getText().strip();
        String location = loIDTF.getText().strip();
        String rentText = rentTF.getText().strip();
        String type = proTypeTF.getValue();
        String status = statusTF.getValue();
        String contact = contactTF.getText().strip();
        String facilities = "WiFi, Parking";

        // Validation1
        if ( propertyID.isEmpty() || location.isEmpty() || rentText.isEmpty() || type == null || status == null || contact.isEmpty() ) {
            messageL.setText("please fill all information");
            return;
        }

        // Validation2
        int propertyIdInt;
        try {
            propertyIdInt = Integer.parseInt(propertyID);
            if (propertyIdInt <= 0) {
                messageL.setText(" PropertyID should be positive!");
                return;
            }
        } catch (NumberFormatException e) {
            messageL.setText(" Invalid Property ID!");
            return;
        }

        // Validation3

        double rentDouble;
        try {
            rentDouble = Double.parseDouble(rentText);
            if (rentDouble <= 0) {
                messageL.setText("Rent should positive!");
                return;
            }
        } catch (NumberFormatException e) {
            messageL.setText("Invalid rent amount!");
            return;
        }
        // Validation4
        int contactInt;
        try {
            contactInt = Integer.parseInt(contact);
        } catch (NumberFormatException e) {
            messageL.setText("Invalid contact number!");
            return;
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("properties.bin"))) {
            out.writeObject(propertyList);
            messageL.setText("Property updated!");
            PMtableView.refresh();
            ;
        } catch (IOException e) {
            messageL.setText("Update failed!");
        }



    }

    @javafx.fxml.FXML
    public void showOC(ActionEvent actionEvent) {
        propertymanagement selected = PMtableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageL.setText("Please select a property first!");
            return;
        }

        proIDTF.setText(String.valueOf(selected.getPropertyID()));
        loIDTF.setText(selected.getLocation());
        proTypeTF.setValue(selected.getPropertyType());
        rentTF.setText(String.valueOf(selected.getRentPrice()));
        statusTF.setValue(selected.getStatus());
        contactTF.setText(String.valueOf(selected.getContact()));

        messageL.setText(" Property details loaded!");

    }

    @javafx.fxml.FXML
    public void searchOC(ActionEvent actionEvent) {
        try {
            int searchID = Integer.parseInt(proIDTF.getText().strip());
            PMtableView.getItems().clear();

            for (propertymanagement p : propertyList) {
            if (p.getPropertyID() == searchID) {
                PMtableView.getItems().add(p);
                messageL.setText("Property found!");
                return;
            }
        }messageL.setText("Property not found!");

    } catch (NumberFormatException e) {
        loadOC(actionEvent);
    }


    }

    @javafx.fxml.FXML
    public void loadOC(ActionEvent actionEvent) {
        try(ObjectInputStream in = new ObjectInputStream( new FileInputStream("properties.bin"))){
            propertyList=(ArrayList<propertymanagement>) in.readObject();

            PMtableView.getItems().clear();
            for (propertymanagement p : propertyList) {
                PMtableView.getItems().add(p);
            }
            messageL.setText("Loaded successfully!");
        } catch (Exception e) {
            messageL.setText("No saved file found!");
        }
    }


    @javafx.fxml.FXML
    public void addbuttonOC(ActionEvent actionEvent) {
        String propertyID = proIDTF.getText().strip();
        String location = loIDTF.getText().strip();
        String rentText = rentTF.getText().strip();
        String type = proTypeTF.getValue();
        String status = statusTF.getValue();
        String contact = contactTF.getText().strip();
        String facilities = "WiFi, Parking";

        // Validation
        if ( propertyID.isEmpty() || location.isEmpty() || rentText.isEmpty() || type == null || status == null || contact.isEmpty() ) {
            messageL.setText("please fill all information");
            return;
        }

        int propertyIdInt;
        try {
            propertyIdInt = Integer.parseInt(propertyID);
            if (propertyIdInt <= 0) {
                messageL.setText(" PropertyID should be positive!");
                return;
            }
        } catch (NumberFormatException e) {
            messageL.setText(" Invalid Property ID!");
            return;
        }


        double rentDouble;
        try {
            rentDouble = Double.parseDouble(rentText);
            if (rentDouble <= 0) {
                messageL.setText("Rent should positive!");
                return;
            }
        } catch (NumberFormatException e) {
            messageL.setText("Invalid rent amount!");
            return;
        }


        int contactInt;
        try {
            contactInt = Integer.parseInt(contact);
        } catch (NumberFormatException e) {
            messageL.setText("Invalid contact number!");
            return;
        }

        //unique
        //for (propertymanagement p : propertyList){
         //   if (p.getPropertyID() == propertyID){
          //      messageL.setText("this Id already exist");
          //      return;
        //    }

       // }

        propertymanagement newProperty = new propertymanagement(propertyIdInt, location, type, rentDouble , status, facilities, contactInt );

        propertyList.add(newProperty);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("properties.bin"))) {
            out.writeObject(propertyList);
            messageL.setText("Property saved!");

            PMtableView.getItems().clear();
            PMtableView.getItems().addAll(propertyList);

        } catch (IOException e) {
            messageL.setText("Saving failed!");


        }

    }




}
