//<<<<<<< HEAD
//package com.group18.oopprojectgroup18realestate.Ramisa;
//
//import javafx.scene.control.*;
//
//public class handleMaintenanceReqController
//{
//    @javafx.fxml.FXML
//    private TableColumn propertycol;
//    @javafx.fxml.FXML
//    private TableColumn reqidcol;
//    @javafx.fxml.FXML
//    private TableColumn issuecol;
//    @javafx.fxml.FXML
//    private TableColumn tenantidMMcol;
//    @javafx.fxml.FXML
//    private Button appycombobox;
//    @javafx.fxml.FXML
//    private ComboBox updateStatusCB;
//    @javafx.fxml.FXML
//    private TextArea issueTA;
//    @javafx.fxml.FXML
//    private TableColumn datecol;
//    @javafx.fxml.FXML
//    private ComboBox filtercombobox;
//    @javafx.fxml.FXML
//    private Label propertyLabel;
//    @javafx.fxml.FXML
//    private Label tenantlabel;
//    @javafx.fxml.FXML
//    private Label managernoteLabel;
//    @javafx.fxml.FXML
//    private TableView maintainacemanagertv;
//    @javafx.fxml.FXML
//    private Label reqidL;
//
//    @javafx.fxml.FXML
//    public void initialize() {
//    }}
//=======
package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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

    private ArrayList<MaintenanceRequest> maintenanceList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        updateStatusCB.getItems().addAll("Open", "In Progress", "Resolved");
        filtercombobox.getItems().addAll("All", "Open", "In Progress", "Resolved");

        reqidcol.setCellValueFactory(new PropertyValueFactory<>("requestID"));
        tenantidMMcol.setCellValueFactory(new PropertyValueFactory<>("tenantID"));
        propertycol.setCellValueFactory(new PropertyValueFactory<>("propertyID"));
        issuecol.setCellValueFactory(new PropertyValueFactory<>("issue"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("submittedDate"));


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
//>>>>>>> origin/main
