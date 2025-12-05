<<<<<<< HEAD
//package com.group18.oopprojectgroup18realestate.Ramisa;
//
//public class rentTrackingController
//{
//    @javafx.fxml.FXML
//    private ComboBox YearCB;
//    @javafx.fxml.FXML
//    private TableView rentTrackTableview;
//    @javafx.fxml.FXML
//    private TableColumn paidCol;
//    @javafx.fxml.FXML
//    private Label pendingrentL;
//    @javafx.fxml.FXML
//    private TableColumn tenantCOl;
//    @javafx.fxml.FXML
//    private TableColumn rentamountCol;
//    @javafx.fxml.FXML
//    private Label generatemessage;
//    @javafx.fxml.FXML
//    private ComboBox monthCB;
//    @javafx.fxml.FXML
//    private Label totalexpectedL;
//    @javafx.fxml.FXML
//    private TableColumn idCol;
//    @javafx.fxml.FXML
//    private TableColumn dateCol;
//    @javafx.fxml.FXML
//    private TableColumn statusCol;
//    @javafx.fxml.FXML
//    private TableColumn pendingCol;
//    @javafx.fxml.FXML
//    private Label collectrentL;
//
//    @javafx.fxml.FXML
//    public void initialize() {
//    }
//
//    @javafx.fxml.FXML
//    public void LoadOC(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void generateOC(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void backbutton(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void refreshOC(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void exportOC(ActionEvent actionEvent) {
//    }
//}
=======
package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class rentTrackingController
{
    @javafx.fxml.FXML
    private ComboBox<Integer> YearCB;
    @javafx.fxml.FXML
    private TableView<RentPaymentRelated> rentTrackTableview;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Double> paidCol;
    @javafx.fxml.FXML
    private Label pendingrentL;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Integer> tenantCOl;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Double> rentamountCol;
    @javafx.fxml.FXML
    private Label generatemessage;
    @javafx.fxml.FXML
    private ComboBox<String> monthCB;
    @javafx.fxml.FXML
    private Label totalexpectedL;
    @javafx.fxml.FXML
    private TableColumn <RentPaymentRelated,Integer>idCol;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<RentPaymentRelated,Double> pendingCol;
    @javafx.fxml.FXML
    private Label collectrentL;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void LoadOC(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateOC(ActionEvent actionEvent) {
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
    public void exportOC(ActionEvent actionEvent) {
    }
}
>>>>>>> origin/main
