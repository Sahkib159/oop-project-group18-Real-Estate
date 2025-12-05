package com.group18.oopprojectgroup18realestate.Ramisa;

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
import java.time.LocalDate;
import java.util.ArrayList;

public class tenantManagementController
{
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, String> propertycol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, LocalDate> leaseStartCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, Integer> appidcol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, String> tenantCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, Integer> properetyidCOl;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, LocalDate> leaseendCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, LocalDate> dateappCOl;
    @javafx.fxml.FXML
    private TableView<TenantRecord> tenantapplicationtableView;
    @javafx.fxml.FXML
    private Label messageL;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, Integer> tenantidCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, Integer> tenantappidCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<TenantRecord, String> emailCOL;
    @javafx.fxml.FXML
    private TableView<TenantRecord> tenantmanagementtV;

    private ArrayList<TenantRecord> tenantList = new ArrayList<>();
    private ArrayList<TenantRecord> applicationList = new ArrayList<>();
    @javafx.fxml.FXML
    private TextField searchTF;


    @javafx.fxml.FXML
    public void initialize() {
        // Tenant table
        tenantidCol.setCellValueFactory(new PropertyValueFactory<>("tenantID"));
        tenantCol.setCellValueFactory(new PropertyValueFactory<>("tenantName"));
        emailCOL.setCellValueFactory(new PropertyValueFactory<>("email"));
        properetyidCOl.setCellValueFactory(new PropertyValueFactory<>("propertyID"));
        leaseStartCol.setCellValueFactory(new PropertyValueFactory<>("leaseStartDate"));
        leaseendCol.setCellValueFactory(new PropertyValueFactory<>("leaseEndDate"));

        // Application table
        appidcol.setCellValueFactory(new PropertyValueFactory<>("applicationId"));
        tenantappidCol.setCellValueFactory(new PropertyValueFactory<>("tenantID"));
        dateappCOl.setCellValueFactory(new PropertyValueFactory<>("dateApplied"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        propertycol.setCellValueFactory(new PropertyValueFactory<>("location"));

        loadAppOC(null);
        LoadtenantOC(null);
    }

    @javafx.fxml.FXML
    public void approvebuttonOC(ActionEvent actionEvent) {
        TenantRecord selected = tenantapplicationtableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageL.setText("Please select an application!");
            return;
        }

        selected.setStatus("Approved");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("applications.bin"))) {
            out.writeObject(applicationList);
            messageL.setText("Application approved!");
            tenantapplicationtableView.refresh();
        } catch (IOException e) {
            messageL.setText("Error approving!");
        }

    }

    @javafx.fxml.FXML
    public void showallbutton(ActionEvent actionEvent) {
        tenantmanagementtV.getItems().clear();
        for (TenantRecord t : tenantList) {
            tenantmanagementtV.getItems().add(t);
        }
        messageL.setText("Showing all tenants!");
    }

    @javafx.fxml.FXML
    public void loadAppOC(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("applications.bin"))) {
            applicationList = (ArrayList<TenantRecord>) in.readObject();

            tenantapplicationtableView.getItems().clear();
            for (TenantRecord t : applicationList) {
                tenantapplicationtableView.getItems().add(t);
            }
            messageL.setText("Loaded " + applicationList.size() + " applications!");
        } catch (FileNotFoundException e) {
            messageL.setText("No applications found!");

        } catch (Exception e) {
            messageL.setText("Error loading applications!");
        }
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
    public void refreshOC(ActionEvent actionEvent) {
        //loadAppOC();
       // LoadtenantOC();
        messageL.setText("Refreshed!");
    }

    @javafx.fxml.FXML
    public void LoadtenantOC(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("applications.bin"))) {
            applicationList = (ArrayList<TenantRecord>) in.readObject();

            tenantapplicationtableView.getItems().clear();
            for (TenantRecord t : applicationList) {
                tenantapplicationtableView.getItems().add(t);
            }
            messageL.setText("Loaded " + applicationList.size() + " applications!");
        } catch (FileNotFoundException e) {
            messageL.setText("No applications found!");
        } catch (Exception e) {
            messageL.setText("Error loading applications!");
        }

    }



    @javafx.fxml.FXML
    public void declinedOC(ActionEvent actionEvent) {
        TenantRecord selected = tenantapplicationtableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageL.setText("Please select an application!");
            return;
        }

        selected.setStatus("Declined");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("applications.bin"))) {
            out.writeObject(applicationList);
            messageL.setText("Application declined!");
            tenantapplicationtableView.refresh();
        } catch (IOException e) {
            messageL.setText("Error declining!");
        }
    }

    @javafx.fxml.FXML
    public void searchOC(ActionEvent actionEvent) {
        String searchText = searchTF.getText().strip();

        if (searchText.isEmpty()) {
            messageL.setText("Please enter Tenant ID or Name!");
            return;
        }
        tenantmanagementtV.getItems().clear();

    }

}