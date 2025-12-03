package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class tenantManagementController
{
    @javafx.fxml.FXML
    private TableColumn<TenantRecord,String> propertycol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, LocalDate> leaseStartCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord,Integer> appidcol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord,String> tenantCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord,Integer> properetyidCOl;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord,LocalDate> leaseendCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord,LocalDate> dateappCOl;
    @javafx.fxml.FXML
    private TableView<TenantRecord> tenantapplicationtableView;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord,Integer> tenantidCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord,Integer> tenantappidCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord,String> emailCOL;
    @javafx.fxml.FXML
    private TableView<TenantRecord> tenantmanagementtV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void approvebuttonOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void showallbutton(ActionEvent actionEvent) {
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
    public void searchtenantbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewfulldetailsOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void declinedOC(ActionEvent actionEvent) {
    }
}