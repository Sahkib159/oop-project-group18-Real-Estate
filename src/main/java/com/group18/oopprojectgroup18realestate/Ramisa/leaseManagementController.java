package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class leaseManagementController
{
    @javafx.fxml.FXML
    private Label messageaboutTerminate;



    @javafx.fxml.FXML
    private TableColumn<lease,String> typecol;
    @javafx.fxml.FXML
    private Label messageL;
    @javafx.fxml.FXML
    private TableView<lease> tableviewLease;
    @javafx.fxml.FXML
    private TableColumn<lease,Integer> leaseID;
    @javafx.fxml.FXML
    private TableColumn<lease,Integer>propertyidCol;
    @javafx.fxml.FXML
    private TableColumn<lease,LocalDate> startCol;
    @javafx.fxml.FXML
    private TableColumn<lease,Double> rentcol;
    @javafx.fxml.FXML
    private TableColumn<lease, LocalDate> endcol;


    private ArrayList<lease> leaseList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {

        leaseID.setCellValueFactory(new PropertyValueFactory<>("leaseID"));
        propertyidCol.setCellValueFactory(new PropertyValueFactory<>("propertyID"));
        typecol.setCellValueFactory(new PropertyValueFactory<>("propertyType"));
        rentcol.setCellValueFactory(new PropertyValueFactory<>("monthlyRent"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endcol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        loadOC(null);
    }

    @javafx.fxml.FXML
    public void backbuttonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void terminate(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void renewOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void showOC(ActionEvent actionEvent) {
    }
}