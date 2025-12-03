package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class handleMaintenanceReqController
{
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,Integer> propertycol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,Integer> reqidcol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,String> issuecol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,Integer> tenantidMMcol;
    @javafx.fxml.FXML
    private ComboBox <String>updateStatusCB;
    @javafx.fxml.FXML
    private TextArea issueTA;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest, LocalDate> datecol;
    @javafx.fxml.FXML
    private ComboBox<String> filtercombobox;
    @javafx.fxml.FXML
    private Label propertyLabel;
    @javafx.fxml.FXML
    private Label tenantlabel;
    @javafx.fxml.FXML
    private Label managernoteLabel;
    @javafx.fxml.FXML
    private TableView<MaintenanceRequest> maintainacemanagertv;
    @javafx.fxml.FXML
    private Label reqidL;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backbuttonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjectManagerDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void applyCBonclickbutton(ActionEvent actionEvent) {
    }
}