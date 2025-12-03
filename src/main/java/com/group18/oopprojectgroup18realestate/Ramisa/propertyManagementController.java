package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class propertyManagementController
{
    @javafx.fxml.FXML
    private TextField rentTF;
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,String> typeCOL;
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,String> StatusCOL;
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,Double> PriceCol;
    @javafx.fxml.FXML
    private ComboBox<String> proTypeTF;
    @javafx.fxml.FXML
    private TextField contactTF;
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,String> facilitiesCOL;
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,Integer> idcol;
    @javafx.fxml.FXML
    private TableColumn<PropertyRental,String> locCol;
    @javafx.fxml.FXML
    private TextField loIDTF;
    @javafx.fxml.FXML
    private TextField proIDTF;
    @javafx.fxml.FXML
    private ComboBox statusTF;
    @javafx.fxml.FXML
    private TableView<PropertyRental> PMtableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearOC(ActionEvent actionEvent) {
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
    public void refreshOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void removeOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void showOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addbuttonOC(ActionEvent actionEvent) {
    }
}