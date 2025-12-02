package com.group18.oopprojectgroup18realestate.Ramisa;


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

public class propertySearchController
{
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,String> typeCol;
    @javafx.fxml.FXML
    private TextField locationTF;
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,Integer> propertyIDCol;
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,String> statusCol;
    @javafx.fxml.FXML
    private ComboBox<String> typeCB;
    @javafx.fxml.FXML
    private TableView<PropertyRental> searchPropertyTableview;
    @javafx.fxml.FXML
    private TextField budgetTF;
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,String> LocationCol;
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,Double> priceCol;
    @javafx.fxml.FXML
    private Label outputLabel;


    private ArrayList<PropertyRental> allpropertiesList = new ArrayList<>();
    private ArrayList<BookMark> bookmarkList = new ArrayList<>();
    private ObservableList<PropertyRental> propertyList;
    @javafx.fxml.FXML
    private Label messageL;


    @javafx.fxml.FXML
    public void initialize() {
        System.out.println("property search screen loaded");

        allpropertiesList = new ArrayList<>();
        bookmarkList = new ArrayList<>();
        propertyList = FXCollections.observableArrayList();


        typeCB.getItems().addAll("apartment","house","studio","flat","all");


        propertyIDCol.setCellValueFactory( new PropertyValueFactory<>("propertyID"));
        LocationCol.setCellValueFactory( new PropertyValueFactory<>("location"));
        typeCol.setCellValueFactory( new PropertyValueFactory<>("propertyType"));
        priceCol.setCellValueFactory( new PropertyValueFactory<>("rentPrice"));
        statusCol.setCellValueFactory( new PropertyValueFactory<>("status"));


        // after projectmanager add/remove properties,loads properties in search list


        propertyList.addAll(allpropertiesList);
        searchPropertyTableview.setItems(propertyList);

    }

    @javafx.fxml.FXML
    public void bookPropertyOnClickButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchPropertyOnClick(ActionEvent actionEvent) {
        String location = locationTF.getText().strip();
        String type = typeCB.getValue();
        String budgetText = budgetTF.getText().strip();

        //empty check
        if (location.isEmpty() || type==null || budgetText.isEmpty()){
            messageL.setText("please fill all information");
            return;
        }


        // validation (budget)
        double budget;
        try{
            budget = Double.parseDouble(budgetText);
        } catch (Exception e) {
            messageL.setText("invalid budget format");
            return;

        }






    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}