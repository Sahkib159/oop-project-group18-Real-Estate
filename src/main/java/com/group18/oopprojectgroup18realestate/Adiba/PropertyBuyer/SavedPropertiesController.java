package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class SavedPropertiesController
{
    @javafx.fxml.FXML
    private TableColumn<savedProperties, String> locationCol;
    @javafx.fxml.FXML
    private TableColumn<savedProperties, String> sizeCol;
    @javafx.fxml.FXML
    private TableColumn<savedProperties, String> nameCol;
    @javafx.fxml.FXML
    private TableView<savedProperties> savedPropertiesTable;
    @javafx.fxml.FXML
    private TableColumn<savedProperties, Double> priceCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void removeOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewDetailsOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PropertyBuyerDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }
}